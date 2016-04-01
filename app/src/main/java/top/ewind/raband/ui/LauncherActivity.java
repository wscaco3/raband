package top.ewind.raband.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import org.xutils.ex.DbException;
import org.xutils.x;
import org.xutils.DbManager;
import org.xutils.view.annotation.ContentView;

import top.ewind.raband.R;
import top.ewind.raband.base.BaseActivity;
import top.ewind.raband.pojo.Setting;

@ContentView(R.layout.activity_launcher)
public class LauncherActivity extends BaseActivity {

    boolean needGuide = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DbManager db = x.getDb(mApplication.daoConfig);
        try {
            Setting setting = db.selector(Setting.class).where("name","=","firstlaunch").findFirst();
            if(setting == null){
                setting = new Setting();
                setting.setName("firstlaunch");
                setting.setValue("no");
                needGuide = true;
                db.save(setting);
            }
        } catch (DbException e) {}

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                //overridePendingTransition(R.anim.splash_screen_fade,R.anim.splash_screen_hold);
                if(needGuide){
                    intent.setClass(LauncherActivity.this, GuideActivity.class);
                }
                else intent.setClass(LauncherActivity.this, MainActivity.class);
                startActivity(intent);
                LauncherActivity.this.finish();
            }
        }, 2500);
    }
}
