package top.ewind.raband.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.xutils.x;

public class BaseActivity extends AppCompatActivity {

    protected MApplication mApplication;
    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        mApplication = (MApplication) getApplicationContext();
    }
}
