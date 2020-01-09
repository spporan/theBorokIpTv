package com.example.theborokiptv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.theborokiptv.Api.ApiInterface;
import com.example.theborokiptv.Api.ApiService;
import com.example.theborokiptv.model.AccessToken;
import com.example.theborokiptv.model.DataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ApiInterface apiInterface=ApiService.getRetrofitInstance().create(ApiInterface.class);
//        apiInterface.getAccessToken().enqueue(new Callback<AccessToken>() {
//            @Override
//            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
//                if (response.body() != null) {
//                            //data.setValue(response.body());
//                            Log.d("Response", " result:: " + response.body());
//                            Log.i("info",response.body().getAccessToken());
//                            Toast.makeText(getApplicationContext(),"Response "+response.body().getAccessToken(),Toast.LENGTH_LONG).show();
//
//                        }
//            }
//
//            @Override
//            public void onFailure(Call<AccessToken> call, Throwable t) {
//
//            }
//        });

//        apiInterface.getTvList(20,1)
//                .enqueue(new Callback<DataModel>() {
//
//
//                    @Override
//                    public void onResponse(Call<DataModel> call, Response<DataModel> response) {
//                        Log.d("Response", "onResponse response:: " + response);
//
//
//                        if (response.body() != null) {
//                            //data.setValue(response.body());
//
//
//                            Log.d("Response", " result:: " + response.body());
//                            Log.i("info",response.body().getStatus());
//                            Toast.makeText(getApplicationContext(),"Response "+response.toString(),Toast.LENGTH_LONG).show();
//
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<DataModel> call, Throwable t) {
//                        Log.d("Error", " result:: " +t.getMessage());
//                        Toast.makeText(getApplicationContext(),"Response "+t.getMessage(),Toast.LENGTH_LONG).show();
//
//
//                    }
//                });

    }
}
