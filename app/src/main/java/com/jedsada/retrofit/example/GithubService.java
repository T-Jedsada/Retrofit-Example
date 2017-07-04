package com.jedsada.retrofit.example;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubService {

    @GET("users/{username}")
    Call<UserInfo> getUserInfo(String username);
}
