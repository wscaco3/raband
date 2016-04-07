package top.ewind.raband.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import top.ewind.raband.R;
import top.ewind.raband.base.BaseActivity;
import top.ewind.raband.base.BaseFragment;
import top.ewind.raband.ui.fragment.FavFragment;
import top.ewind.raband.ui.fragment.ItemFragment;
import top.ewind.raband.ui.fragment.MainFragment;
import top.ewind.raband.ui.fragment.dummy.DummyContent;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.HashMap;
import java.util.Map;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, ItemFragment.OnListFragmentInteractionListener {
    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;
    @ViewInject(R.id.drawer_layout)
    private DrawerLayout drawer;
    @ViewInject(R.id.nav_view)
    private NavigationView navView;

    private Map<String,BaseFragment> fragmentMap;
    private BaseFragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
        fragmentMap = new HashMap<String,BaseFragment>();
        setFragment("home");
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void setFragment(String type){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.setCustomAnimations(R.anim.alpha_enter,R.anim.alpha_exit);
        BaseFragment switchFragment = fragmentMap.get(type);
        if(switchFragment!=null&&currentFragment!=null&&type.equals(currentFragment.getTag())){
            return;
        }
        boolean isAdd = false;
        if(switchFragment==null){
            if(type.equals("home")){
                switchFragment = MainFragment.newInstance("ok");
            }
            else if(type.equals("find")){
                switchFragment = FavFragment.newInstance("ok");
            }
            else if(type.equals("fav")){
                switchFragment = ItemFragment.newInstance(1);
            }
            else if(type.equals("msg")){
                switchFragment =  ItemFragment.newInstance(4);
            }
            else switchFragment =  MainFragment.newInstance("ok");
            fragmentMap.put(type,switchFragment);
            isAdd = true;
        }
        if(currentFragment==null){
            transaction.replace(R.id.main_content, switchFragment,type);
        }
        else{
            transaction.hide(currentFragment);
            if(isAdd){
                transaction.add(R.id.main_content, switchFragment,type);
            }
            else transaction.show(switchFragment);
        }
        currentFragment = switchFragment;
        transaction.commit();
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
            setFragment("home");
        } else if (id == R.id.nav_gallery) {
            setFragment("find");
        } else if (id == R.id.nav_slideshow) {
            setFragment("fav");
        } else if (id == R.id.nav_manage) {
            setFragment("msg");
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Log.d("MainActivity","onListFragmentInteraction OK");
    }
}
