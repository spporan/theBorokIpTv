package com.example.theborokiptv.Api;

import com.example.theborokiptv.model.AccessToken;
import com.example.theborokiptv.model.DataModel;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("token?key=820783060533")
    Call<AccessToken> getAccessToken(
            //@Query("key") long key
    );

    @Headers({
            "Content-Type: application/json",
            "X-Requested-With: XMLHttpRequest"
    })
    @GET("movies")
    Call<DataModel> getTvList(
            @Query("number_per_page") int numberPerPage,
            @Query("page") int page
           // @Header("Authorization") String authorization

    );

}
