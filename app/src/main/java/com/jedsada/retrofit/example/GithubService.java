package com.jedsada.retrofit.example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {

    @GET("users/{username}")
    Call<UserInfo> getUserInfo(@Path("username") String username);
}
