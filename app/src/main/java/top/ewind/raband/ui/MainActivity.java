package top.ewind.raband.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import top.ewind.raband.R;
import top.ewind.raband.base.BaseActivity;
import top.ewind.raband.ui.adapter.MainViewAdapt;
import top.ewind.raband.ui.decoration.DividerItemDecoration;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;
    @ViewInject(R.id.fab)
    private FloatingActionButton fab;
    @ViewInject(R.id.mainlist)
    private RecyclerView mainlist;
    @ViewInject(R.id.drawer_layout)
    private DrawerLayout drawer;
    @ViewInject(R.id.nav_view)
    private NavigationView navView;


    private MainViewAdapt mAdapt;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        layoutManager = new LinearLayoutManager(this);
        mainlist.setLayoutManager(layoutManager);
        List<String> numlist = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            numlist.add("old--" + i);
        }

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mAdapt = new MainViewAdapt(this, numlist);
        mainlist.setAdapter(mAdapt);
        mainlist.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        navView.setNavigationItemSelectedListener(this);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "增加一个列表项吗？", Snackbar.LENGTH_LONG)
                        .setAction("确认", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int position = layoutManager.findFirstCompletelyVisibleItemPosition();
                                mAdapt.addItem(position);
                            }
                        }).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent = new Intent();
        if (id == R.id.nav_camera) {
            intent.setClass(MainActivity.this, CardActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
