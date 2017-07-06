package com.jedsada.retrofit.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // load image with Glide
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(android.R.color.darker_gray);
        requestOptions.error(android.R.color.darker_gray);
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);

        Glide.with(this)
                .load("https://d3nmt5vlzunoa1.cloudfront.net/kotlin/files/2017/05/android_kotlin.png")
                .into((ImageView) findViewById(R.id.image));

        findViewById(R.id.btn_repos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListReposActivity.class));
            }
        });
    }
}