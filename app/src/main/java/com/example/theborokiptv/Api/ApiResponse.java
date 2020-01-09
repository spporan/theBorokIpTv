package com.example.theborokiptv.Api;

import com.example.theborokiptv.model.TvModel;

import java.util.List;

public class ApiResponse {
    public List<TvModel> tvList;
    private Throwable error;
    private String accessToken;

    public ApiResponse(List<TvModel> tvList) {
        this.tvList = tvList;
        this.error = null;
    }

    public ApiResponse(Throwable error) {
        this.error = error;
        this.tvList = null;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public ApiResponse(String accessToken) {
        this.error = null;
        this.accessToken = accessToken;
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
