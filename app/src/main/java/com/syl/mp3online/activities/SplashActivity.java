package com.syl.mp3online.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.syl.mp3online.R;

/**
 * Created by ainsc on 2016/4/4/004.
 */
public class SplashActivity extends Activity {

    StackTraceElement stackElent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        },5000);
    }
}
