package com.example.theborokiptv.screens;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.theborokiptv.R;
import com.example.theborokiptv.viewModel.MainActivityViewModel;


public class MainActivity extends AppCompatActivity {
    MainActivityViewModel viewModel;
    public static    String accessToken;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);


        viewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
        viewModel.getApiAccessToken().observe(this, apiResponse -> {
            progressBar.setVisibility(View.VISIBLE);
            if (apiResponse == null) {


                // handle error here
                return;
            }
            if (apiResponse.getError() == null) {
                // call is successful
                accessToken= apiResponse.getAccessToken();
                if(accessToken!=null){
                    Log.i("Success", "Data for accessToken " + apiResponse.getAccessToken());
                    getRequest();
                }



            } else {
                // call failed.
                Throwable e = apiResponse.getError();
                Toast.makeText(MainActivity.this, "Error is " + e.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error", "Error is " + e.getLocalizedMessage());

            }
        });


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

    public void getRequest(){
        viewModel.getTvList(20,1).observe(this, apiResponse -> {
            if (apiResponse == null) {
                // handle error here
                return;
            }
            if (apiResponse.getError() == null&&apiResponse.getTvList()!=null) {
                // call is successful
                progressBar.setVisibility(View.GONE);

                Log.i("Success", "Data response TV " + apiResponse.getTvList());

            } else if( apiResponse.getError()!=null){
                // call failed.
                Throwable e = apiResponse.getError();
                progressBar.setVisibility(View.GONE);

                Toast.makeText(MainActivity.this, "Error is " + e.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error", "Error is " + e.getLocalizedMessage());

            }
        });

    }
}
