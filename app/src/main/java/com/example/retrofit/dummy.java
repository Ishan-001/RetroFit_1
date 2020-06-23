package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface dummy {


    @GET("users")
    Call<List<users>> getUsers();

    @POST("login")
    Call<users2> createUser(@Body users user);

    @FormUrlEncoded
    @POST("users")
    Call<users> createUser(
            @Field("email") String email,
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("add")
    Call<URL> addURL(
            @Field("url") String url
    );

    @POST("add")
    Call<URL> addURL(@Body URL url);
}
