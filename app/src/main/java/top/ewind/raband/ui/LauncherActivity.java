package top.ewind.raband.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import org.xutils.view.annotation.ContentView;

import top.ewind.raband.R;
import top.ewind.raband.base.BaseActivity;

@ContentView(R.layout.activity_launcher)
public class LauncherActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(LauncherActivity.this, MainActivity.class);
                startActivity(intent);
                //overridePendingTransition(R.anim.splash_screen_fade,R.anim.splash_screen_hold);
                LauncherActivity.this.finish();
            }
        }, 2500);
    }
}
