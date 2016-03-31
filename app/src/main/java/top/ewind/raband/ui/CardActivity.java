package top.ewind.raband.ui;

import android.content.Intent;
import android.os.Bundle;
import top.ewind.raband.R;
import top.ewind.raband.base.BaseActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_card)
public class CardActivity extends BaseActivity {

    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setTitle(R.string.title_book);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    public void goDetail(View view){
        Intent intent = new Intent(this,DetailActivity.class);
        startActivity(intent);
    }
}
