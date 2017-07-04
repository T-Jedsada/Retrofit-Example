package com.jedsada.retrofit.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GithubService githubService = NetworkModule.getInstance().githubService();
        githubService.getUserInfo("pondthaitay").enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                // TODO : handler success
                Log.d(TAG, response.body().getLogin());
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {
                // TODO : handler error
                Log.e(TAG, t.getMessage());
            }
        });
    }
}