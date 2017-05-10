package text.bwie.today.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import text.bwie.today.R;

/**
 * Created by lenovo-pc on 2017/5/10.
 */

public class LeftFragment extends BaseFragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.left_fragment,container,false);


        return view;

    }


}
