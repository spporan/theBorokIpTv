package com.example.theborokiptv.Api;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

   private final static String  BASE_URL="https://sastaiptv.com/api/";
    private static String ACCESS_TOKEN="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvc2FzdGFpcHR2LmNvbVwvYXBpXC90b2tlbiIsImlhdCI6MTU3ODUxNTQ5OSwiZXhwIjoxNTc4NTE5MDk5LCJuYmYiOjE1Nzg1MTU0OTksImp0aSI6IkVIeUQ3MnNNNzJhalpCV1EiLCJzdWIiOjEsInBydiI6Ijg3ZTBhZjFlZjlmZDE1ODEyZmRlYzk3MTUzYTE0ZTBiMDQ3NTQ2YWEifQ.aWX-Lyfzooh1htFiPdWtE60j5A3mI2kF6ZQfKxECYc8";
    final  int PAGE=1;
    final  int  NUMBER_OF_PAGE=20;
    private static Retrofit retrofit;
    private static ApiInterface apiInterface;

    private static OkHttpClient client = new OkHttpClient.Builder().addInterceptor(chain -> {
        Request newRequest  = chain.request().newBuilder()
                .addHeader("Authorization","Bearer "+ ACCESS_TOKEN)
                .build();
        return chain.proceed(newRequest);
    }).build();




    public static ApiInterface getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface=retrofit.create(ApiInterface.class);
        }
        return apiInterface;
    }


}
