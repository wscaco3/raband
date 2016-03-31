package top.ewind.raband.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import top.ewind.raband.R;
import top.ewind.raband.base.BaseFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.fragment_detail)
public class DetailFragment extends BaseFragment {
    @ViewInject(R.id.tvInfo)
    private TextView tvInfo;

    public static DetailFragment newInstance(String info) {
        Bundle args = new Bundle();
        DetailFragment fragment = new DetailFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvInfo.setText(getArguments().getString("info"));
    }
}
