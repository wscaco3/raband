package top.ewind.raband.base;

import android.app.Application;

import org.xutils.x;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
