package com.example.theborokiptv.screens;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theborokiptv.Api.ApiInterface;
import com.example.theborokiptv.Api.ApiService;
import com.example.theborokiptv.R;
import com.example.theborokiptv.adapter.TvListAdapater;
import com.example.theborokiptv.model.AccessToken;
import com.example.theborokiptv.viewModel.MainActivityViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    MainActivityViewModel viewModel;
    public static    String accessToken="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvc2FzdGFpcHR2LmNvbVwvYXBpXC90b2tlbiIsImlhdCI6MTU3ODU5MjU2NywiZXhwIjoxNTc4NTk2MTY3LCJuYmYiOjE1Nzg1OTI1NjcsImp0aSI6IjB5cGNtYWtFblpvcjdUNU0iLCJzdWIiOjEsInBydiI6Ijg3ZTBhZjFlZjlmZDE1ODEyZmRlYzk3MTUzYTE0ZTBiMDQ3NTQ2YWEifQ.8jibPiBKnYznS3kV2yYbvVDk92Jo4nyoXCRuq-CcAUkv";
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    TvListAdapater tvListAdapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        recyclerView=findViewById(R.id.recycler_view);


       viewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
//        viewModel.getApiAccessToken().observe(this, apiResponse -> {
//            Log.i("before", "Data for accessToken " + apiResponse.getAccessToken());
//            progressBar.setVisibility(View.VISIBLE);
//            if (apiResponse == null) {
//                // handle error here
//                return;
//            }
//            if (apiResponse.getError() == null) {
//                // call is successful
//                accessToken= apiResponse.getAccessToken();
//                if(accessToken!=null){
//                    Log.i("Success", "Data for accessToken " + apiResponse.getAccessToken());
//                    getRequest();
//                }
//
//
//
//            } else {
//                // call failed.
//                progressBar.setVisibility(View.GONE);
//
//                Throwable e = apiResponse.getError();
//                Toast.makeText(MainActivity.this, "Error is " + e.getMessage(), Toast.LENGTH_SHORT).show();
//                Log.e("Error", "Error is " + e.getLocalizedMessage());
//
//            }
//        });


//        ApiInterface apiInterface= ApiService.getRetrofitInstance();
//        apiInterface.getAccessToken().enqueue(new Callback<AccessToken>() {
//            @Override
//            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
//                if (response.body() != null) {
//                            //data.setValue(response.body());
//                            Log.d("Response", " result:: " + response.body());
//                            Log.i("info",response.body().getAccessToken());
//                            Toast.makeText(getApplicationContext(),"Response "+response.body().getAccessToken(),Toast.LENGTH_LONG).show();
//
//                        }else {
//                    Log.d("Response", " result:: " + response.body());
//                }
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
getRequest();
    }

    public void getRequest(){
        viewModel.getTvList(20,1).observe(this, apiResponse -> {
            progressBar.setVisibility(View.VISIBLE);

            if (apiResponse == null) {
                // handle error here
                return;
            }
            if (apiResponse.getError() == null&&apiResponse.getTvList()!=null) {
                // call is successful
                progressBar.setVisibility(View.GONE);

                tvListAdapater = new TvListAdapater(apiResponse.getTvList(), this);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(tvListAdapater);
                Log.i("Success", "Data response TV " + apiResponse.getTvList());


            } else if( apiResponse.getError()!=null){
                // call failed.
                Throwable e = apiResponse.getError();
               // progressBar.setVisibility(View.GONE);

                Toast.makeText(MainActivity.this, "Error is " + e.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error", "Error is " + e.getLocalizedMessage());

            }
        });

    }
}
