package com.me.sauditourism;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.Window;
import android.view.WindowManager;

import java.util.Objects;

public class MainActivity extends AppCompatActivity{
    private MainFragment mainFragment = new MainFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment=  new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container1 ,mainFragment).commit();
    }
}