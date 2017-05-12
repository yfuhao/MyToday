package text.bwie.today.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import text.bwie.today.OfflineActivity;
import text.bwie.today.R;

/**
 * Created by lenovo-pc on 2017/5/10.
 */

public class LeftFragment extends BaseFragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.left_fragment, container, false);

        init(view);

        return view;

    }

    private void init(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.left_xiazai);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OfflineActivity.class);
                startActivity(intent);
            }
        });
        JumpToRegister();

    }

    //跳转到更多登录
    private void JumpToRegister() {
        TextView text_more = (TextView) view.findViewById(R.id.left_more);
        text_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}
