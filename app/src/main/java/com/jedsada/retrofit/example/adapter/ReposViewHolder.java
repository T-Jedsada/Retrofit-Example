package com.jedsada.retrofit.example.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jedsada.retrofit.example.R;
import com.jedsada.retrofit.example.UserReposDao;

class ReposViewHolder extends RecyclerView.ViewHolder {
    private TextView tvName;
    private TextView tvLanguage;

    ReposViewHolder(View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tv_name);
        tvLanguage = itemView.findViewById(R.id.tv_language);
    }

    public void setDataItem(UserReposDao item) {
        tvName.setText(item.getName());
        tvLanguage.setText(item.getLanguage());
    }
}
