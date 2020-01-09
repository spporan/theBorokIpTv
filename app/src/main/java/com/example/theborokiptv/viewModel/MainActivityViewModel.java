package com.example.theborokiptv.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.theborokiptv.Api.ApiResponse;
import com.example.theborokiptv.repository.TvRepository;

public class MainActivityViewModel extends ViewModel {
    private MediatorLiveData<ApiResponse> mApiResponse;
    private TvRepository myTvRepo;

    public MainActivityViewModel() {
        mApiResponse = new MediatorLiveData<>();
        myTvRepo = new TvRepository();
    }

    public LiveData<ApiResponse>getApiAccessToken(){
        mApiResponse.addSource(myTvRepo.getAccessToken(), apiResponse -> mApiResponse.setValue(apiResponse));
        return  mApiResponse;

    }
    public LiveData<ApiResponse>getTvList(int numberOfPage,int page){
        mApiResponse.addSource(myTvRepo.getTvList(numberOfPage, page), apiResponse -> mApiResponse.setValue(apiResponse));
        return  mApiResponse;
    }
}
