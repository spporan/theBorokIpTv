package com.example.theborokiptv.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

import com.example.theborokiptv.R;

public class TvScreenActivity extends AppCompatActivity {
    VideoView videoView;
    ProgressBar progressBar;
    private MediaController mediacontroller;
    private Uri uri;
    String uriPath ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_screen);
        videoView = findViewById(R.id.tv_view);
        progressBar=findViewById(R.id.progress_circular);
        mediacontroller = new MediaController(this);
        mediacontroller.setAnchorView(videoView);
        progressBar.setVisibility(View.VISIBLE);


        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            uriPath = bundle.getString("url");
            Log.i("tv url :", uriPath);
        }

        try {
            Uri uri=Uri.parse(uriPath);
            videoView.setVideoURI(uri);
            videoView.setOnCompletionListener(mp -> {

            });
            videoView.start();


        }catch (Exception ex){

        }
        videoView.requestFocus();
        videoView.setOnPreparedListener(mp -> {
            progressBar.setVisibility(View.GONE);
            videoView.start();
        });




    }
}
