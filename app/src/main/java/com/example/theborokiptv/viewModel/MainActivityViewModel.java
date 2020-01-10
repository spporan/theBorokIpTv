package com.example.theborokiptv.viewModel;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;
import com.example.theborokiptv.Api.ApiResponse;
import com.example.theborokiptv.repository.TvRepository;

public class MainActivityViewModel extends ViewModel {
    private MediatorLiveData<ApiResponse> mApiResponse;
    private TvRepository myTvRepo;

    public MainActivityViewModel() {
        mApiResponse = new MediatorLiveData<>();

    }

    public LiveData<ApiResponse>getApiAccessToken(Context context){
        myTvRepo = new TvRepository(context);
        mApiResponse.addSource(myTvRepo.getAccessToken(), apiResponse -> mApiResponse.setValue(apiResponse));
        return  mApiResponse;

    }
    public LiveData<ApiResponse>getTvList(int numberOfPage,int page){
        mApiResponse.addSource(myTvRepo.getTvList(numberOfPage, page), apiResponse -> mApiResponse.setValue(apiResponse));
        return  mApiResponse;
    }
}
