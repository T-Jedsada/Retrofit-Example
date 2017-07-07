package com.jedsada.retrofit.example;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jedsada.retrofit.example.adapter.RepoAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListReposActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private RecyclerView list;
    private RepoAdapter adapterListRepos;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_repos);
        list = findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        adapterListRepos = new RepoAdapter();
        list.setAdapter(adapterListRepos);
        setupProgressDialog();
        progressDialog.show();

        final List<UserReposDao> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            UserReposDao userReposDao = new UserReposDao();
            userReposDao.setName(String.format("Loop : %d", i));
            userReposDao.setLanguage(String.valueOf(i));
            list.add(userReposDao);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
                adapterListRepos.setData(list);
            }
        }, 1000);
//        NetworkModule.getInstance().githubService().getUserRepos("pondthaitay")
//                .enqueue(new Callback<List<UserReposDao>>() {
//                    @Override
//                    public void onResponse(Call<List<UserReposDao>> call, Response<List<UserReposDao>> response) {
//
//                        adapterListRepos.setData(response.body());
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<UserReposDao>> call, Throwable t) {
//                        // TODO : handler error
//                        progressDialog.dismiss();
//                    }
//                });
    }

    private void setupProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
    }
}
