package com.example.theborokiptv.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.theborokiptv.Api.ApiInterface;
import com.example.theborokiptv.Api.ApiResponse;
import com.example.theborokiptv.Api.ApiService;
import com.example.theborokiptv.Api.NoConnectivityException;
import com.example.theborokiptv.model.AccessToken;
import com.example.theborokiptv.model.DataModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvRepository {
   private ApiInterface apiInterface;
   public TvRepository(Context context){
       apiInterface= ApiService.getRetrofitInstance(context);


   }

   public LiveData<ApiResponse> getAccessToken(){
       final MutableLiveData<ApiResponse> AccessTokenResponse = new MutableLiveData<>();

        apiInterface.getAccessToken().enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                if (response.isSuccessful()) {
                    AccessTokenResponse.postValue(new ApiResponse(response.body().getAccessToken(),response.code()));
                }else {
                    Log.i("Error Code:", String.valueOf(response.code()));
                    AccessTokenResponse.postValue(new ApiResponse(null,"Something went wrong with error code "+response.code()+"!",response.code()));

                }

            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
                Log.i("Response failed:",t.getMessage());
                if (t  instanceof NoConnectivityException) {
                    Log.i("TAAG ", t.getMessage());
                    AccessTokenResponse.postValue(new ApiResponse(t,t.getMessage()));
                }else {
                    AccessTokenResponse.postValue(new ApiResponse(t,t.getMessage()));

                }


            }
        });

       return AccessTokenResponse;

   }

   public LiveData<ApiResponse>getTvList(int numberOfPage,int page){
       final MutableLiveData<ApiResponse> tvListResponse = new MutableLiveData<>();
       apiInterface.getTvList(numberOfPage,page).enqueue(new Callback<DataModel>() {
           @Override
           public void onResponse(Call<DataModel> call, Response<DataModel> response) {
               if(response.isSuccessful()){
                   tvListResponse.postValue(new ApiResponse(response.body().getData(),response.code()));
               }else {
                   tvListResponse.postValue(new ApiResponse(null,"Something went wrong with error code "+response.code()+"!",response.code()));

                   Log.i("Error Code:", String.valueOf(response.code()));

               }

           }

           @Override
           public void onFailure(Call<DataModel> call, Throwable t) {
               if (t  instanceof NoConnectivityException) {
                   Log.i("TAAG ", t.getMessage());
                   tvListResponse.postValue(new ApiResponse(t,t.getMessage()));
               }else {
                   tvListResponse.postValue(new ApiResponse(t,t.getMessage()));

               }
           }
       });

       return tvListResponse;


   }
}
