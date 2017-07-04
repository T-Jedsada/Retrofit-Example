package com.jedsada.retrofit.example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {

    @GET("users/{username}")
    Call<UserInfoDao> getUserInfo(@Path("username") String username);

    @GET("users/{username}/repos")
    Call<List<UserReposDao>> getUserRepos(@Path("username") String username);
}
