package com.syl.mp3online.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.syl.mp3online.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }
}
