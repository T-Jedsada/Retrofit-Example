package com.jedsada.retrofit.example;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

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
        githubService.getUserInfo("pondthaitay").enqueue(new Callback<UserInfoDao>() {
            @Override
            public void onResponse(Call<UserInfoDao> call, Response<UserInfoDao> response) {
                // TODO : handler success
                Log.d(TAG, response.body().getLogin());
            }

            @Override
            public void onFailure(Call<UserInfoDao> call, Throwable t) {
                // TODO : handler error
                Log.e(TAG, t.getMessage());
            }
        });

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");

        //after call APIs show dialog
        progressDialog.show();
        githubService.getUserRepos("pondthaitay").enqueue(new Callback<List<UserReposDao>>() {
            @Override
            public void onResponse(Call<List<UserReposDao>> call, Response<List<UserReposDao>> response) {
                progressDialog.dismiss();
                Log.d(TAG, String.valueOf(response.body().size()));
                Log.d(TAG, response.body().get(0).getFullName());
                ((TextView) findViewById(R.id.tv_result))
                        .setText(response.body().get(0).getFullName());
            }

            @Override
            public void onFailure(Call<List<UserReposDao>> call, Throwable t) {
                progressDialog.dismiss();
                Log.d(TAG, t.getMessage());
            }
        });
    }
}