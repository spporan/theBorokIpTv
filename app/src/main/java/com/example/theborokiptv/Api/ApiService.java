package com.example.theborokiptv.Api;
import android.content.Context;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class ApiService {

   private final static String  BASE_URL="https://sastaiptv.com/api/";
    private static Retrofit retrofit;
    private static ApiInterface apiInterface;
    private static OkHttpClient client;

    public static ApiInterface getRetrofitInstance(Context context) {
        client= new OkHttpClient.Builder().addInterceptor(new ConnectivityInterceptor(context)).build();
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface=retrofit.create(ApiInterface.class);
        return apiInterface;
    }


}
