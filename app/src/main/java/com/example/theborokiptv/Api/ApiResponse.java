package com.example.theborokiptv.Api;

import com.example.theborokiptv.model.TvModel;

import java.util.List;

public class ApiResponse {
    public List<TvModel> tvList;
    private Throwable error;
    private String accessToken;
    private String errorMessage;
    private int responseCode;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }


    public ApiResponse(List<TvModel> tvList,int responseCode) {
        this.tvList = tvList;
        this.error = null;
        this.responseCode = responseCode;
    }



    public ApiResponse(Throwable error,String errorMessage) {
        this.error = error;
        this.tvList = null;
        this.errorMessage=errorMessage;
    }
    public ApiResponse(Throwable error,String errorMessage,int responseCode) {
        this.error = error;
        this.errorMessage = errorMessage;
        this.responseCode=responseCode;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;

    }

    public ApiResponse(String accessToken,int responseCode) {
        this.error = null;
        this.accessToken = accessToken;
        this.responseCode = responseCode;

    }

    public List<TvModel> getTvList() {
        return tvList;
    }

    public void setTvList(List<TvModel> tvList) {
        this.tvList = tvList;
    }

    public Throwable getError() {
        return error;
    }

    public void setError(Throwable error) {
        this.error = error;
    }
}
