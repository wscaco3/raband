package top.ewind.raband.ui;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import top.ewind.raband.R;
import top.ewind.raband.base.BaseActivity;
import top.ewind.raband.ui.fragment.DetailFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@ContentView(R.layout.activity_detail)
public class DetailActivity extends BaseActivity {


    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;
    @ViewInject(R.id.collapsing_toolbar)
    private CollapsingToolbarLayout collapsingToolbar;
    @ViewInject(R.id.ivImage)
    private ImageView ivImage;
    @ViewInject(R.id.sliding_tabs)
    private TabLayout tabLayout;
    @ViewInject(R.id.viewpager)
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        collapsingToolbar.setTitle("失控");

        ImageView ivImage = (ImageView)findViewById(R.id.ivImage);
        ivImage.setImageResource(R.drawable.book1);

        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("内容简介"));
        tabLayout.addTab(tabLayout.newTab().setText("作者简介"));
        tabLayout.addTab(tabLayout.newTab().setText("目录"));
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager mViewPager) {
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(DetailFragment.newInstance(getAsset("book_content.txt")), "内容简介");
        adapter.addFragment(DetailFragment.newInstance(getAsset("book_author.txt")), "作者简介");
        adapter.addFragment(DetailFragment.newInstance(getAsset("book_menu.txt")), "目录");
        mViewPager.setAdapter(adapter);
    }

    private String getAsset(String fileName) {
        AssetManager am = getResources().getAssets();
        InputStream is = null;
        try {
            is = am.open(fileName, AssetManager.ACCESS_BUFFER);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Scanner(is).useDelimiter("\\Z").next();
    }


    static class MyPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
