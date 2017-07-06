package com.jedsada.retrofit.example;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jedsada.retrofit.example.adapter.RepoAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListReposActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private RecyclerView list;
    private RepoAdapter adapterListRepos;

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
        NetworkModule.getInstance().githubService().getUserRepos("pondthaitay")
                .enqueue(new Callback<List<UserReposDao>>() {
                    @Override
                    public void onResponse(Call<List<UserReposDao>> call, Response<List<UserReposDao>> response) {
                        progressDialog.dismiss();
                        adapterListRepos.setData(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<UserReposDao>> call, Throwable t) {
                        // TODO : handler error
                        progressDialog.dismiss();
                    }
                });
    }

    private void setupProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
    }
}
