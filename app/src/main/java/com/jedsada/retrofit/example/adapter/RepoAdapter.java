package com.jedsada.retrofit.example.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jedsada.retrofit.example.R;
import com.jedsada.retrofit.example.UserReposDao;

import java.util.ArrayList;
import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<ReposViewHolder> {

    private List<UserReposDao> daos = new ArrayList<>();

    public void setData(List<UserReposDao> list) {
        daos.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public ReposViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ReposViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(ReposViewHolder holder, int position) {
        holder.setDataItem(daos.get(position));
    }

    @Override
    public int getItemCount() {
        return daos.size();
    }
}