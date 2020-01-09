package com.example.theborokiptv.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.theborokiptv.Api.ApiInterface;
import com.example.theborokiptv.Api.ApiResponse;
import com.example.theborokiptv.Api.ApiService;
import com.example.theborokiptv.model.AccessToken;
import com.example.theborokiptv.model.DataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvRepository {
   public ApiInterface apiInterface;
   public TvRepository(){
       apiInterface= ApiService.getRetrofitInstance();


   }

   private LiveData<ApiResponse> getAccessToken(){
       final MutableLiveData<ApiResponse> AccessTokenResponse = new MutableLiveData<>();

        apiInterface.getAccessToken().enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                if (response.isSuccessful()) {
                    AccessTokenResponse.postValue(new ApiResponse(response.body().getAccessToken()));
                }
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
                AccessTokenResponse.postValue(new ApiResponse(t));
            }
        });

       return AccessTokenResponse;

   }

   private LiveData<ApiResponse>getTvList(int numberOfPage,int page){
       final MutableLiveData<ApiResponse> tvListResponse = new MutableLiveData<>();
       apiInterface.getTvList(numberOfPage,page).enqueue(new Callback<DataModel>() {
           @Override
           public void onResponse(Call<DataModel> call, Response<DataModel> response) {
               if(response.isSuccessful()){
                   tvListResponse.postValue(new ApiResponse(response.body().getData()));
               }

           }

           @Override
           public void onFailure(Call<DataModel> call, Throwable t) {
               tvListResponse.postValue(new ApiResponse(t));
           }
       });

       return tvListResponse;


   }
}
