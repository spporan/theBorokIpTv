package com.example.theborokiptv.screens;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.theborokiptv.R;
import com.example.theborokiptv.adapter.TvListAdapater;
import com.example.theborokiptv.viewModel.MainActivityViewModel;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {
    MainActivityViewModel viewModel;
    public static String accessToken;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    TvListAdapater tvListAdapater;
    ConstraintLayout layout;
    final static String TAG=MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        recyclerView=findViewById(R.id.recycler_view);
        layout = findViewById(R.id.layout);


       viewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
        viewModel.getApiAccessToken(this).observe(this, apiResponse -> {
            Log.i("before", "Data for accessToken " + apiResponse.getAccessToken());
            progressBar.setVisibility(View.VISIBLE);

            if (apiResponse.getError() == null) {


                if (apiResponse.getResponseCode() < 200 || apiResponse.getResponseCode() >= 400 ||apiResponse.getAccessToken()==null) {
                    progressBar.setVisibility(View.GONE);
                    getSnakeBar(apiResponse.getErrorMessage());

                    Log.i(TAG,apiResponse.getErrorMessage() +" \nError Code :"+apiResponse.getResponseCode());
                }else{
                    accessToken= apiResponse.getAccessToken();
                    if(accessToken!=null){
                        Log.i(TAG, "Data for accessToken " + apiResponse.getAccessToken());
                        getRequest();
                    }else {
                        getSnakeBar(apiResponse.getErrorMessage());

                        progressBar.setVisibility(View.GONE);
                        Log.i(TAG, "Data for accessToken nothing " + apiResponse.getAccessToken());

                    }
                }

            } else {
                // call failed.
                progressBar.setVisibility(View.GONE);
                getSnakeBar(apiResponse.getErrorMessage());

                Toast.makeText(MainActivity.this, "Error is " + apiResponse.getErrorMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error", "Error is " + apiResponse.getErrorMessage());

            }
        });

    }

    public void getRequest(){
        viewModel.getTvList(20,1).observe(this, apiResponse -> {

            if (apiResponse.getError() == null) {

                if (apiResponse.getResponseCode() < 200 || apiResponse.getResponseCode() >= 400||apiResponse.getTvList()==null ) {
                    progressBar.setVisibility(View.GONE);
                    getSnakeBar(apiResponse.getErrorMessage());

                    Log.i(TAG,apiResponse.getErrorMessage() +" \nError Code"+apiResponse.getResponseCode());
                }else{
                    progressBar.setVisibility(View.GONE);
                    tvListAdapater = new TvListAdapater(apiResponse.getTvList(), this);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setAdapter(tvListAdapater);
                    Log.i("Success", "Data response TV " + apiResponse.getTvList());


                }





            } else{
                progressBar.setVisibility(View.GONE);

                Log.e("Error", "Error is " + apiResponse.getErrorMessage());
                getSnakeBar(apiResponse.getErrorMessage());

            }
        });

    }

    private void getSnakeBar(String message){
        Snackbar.make(layout,message,Snackbar.LENGTH_LONG).show();
    }
}
