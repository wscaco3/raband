package top.ewind.raband.ui.fragment;

import android.os.Bundle;
import android.view.View;

import org.xutils.view.annotation.ContentView;

import top.ewind.raband.R;
import top.ewind.raband.base.BaseFragment;

@ContentView(R.layout.fragment_fav)
public class FavFragment extends BaseFragment {

    private String mParam1;

    public static FavFragment newInstance(String param1) {
        FavFragment fragment = new FavFragment();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString("param1");
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}
