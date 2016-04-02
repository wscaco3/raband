package top.ewind.raband.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import top.ewind.raband.R;

public class GuideActivity extends AppIntro {

    @Override
    public void init(Bundle savedInstanceState) {
        addSlide(AppIntroFragment.newInstance("t1", "c1", R.drawable.guide01, Color.BLUE));
        addSlide(AppIntroFragment.newInstance("t2", "c2", R.drawable.guide02, Color.GREEN));
        addSlide(AppIntroFragment.newInstance("t3", "c3", R.drawable.guide03, Color.RED));
        setDoneText("开始");
        showSkipButton(false);
    }

    @Override
    public void onSkipPressed() {

    }

    @Override
    public void onNextPressed() {

    }

    @Override
    public void onDonePressed() {
        Intent intent = new Intent();
        intent.setClass(GuideActivity.this, MainActivity.class);
        startActivity(intent);
        GuideActivity.this.finish();
    }

    @Override
    public void onSlideChanged() {

    }
}
