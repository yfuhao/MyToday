package text.bwie.today.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.kyleduo.switchbutton.SwitchButton;

import org.greenrobot.eventbus.EventBus;

import text.bwie.today.OfflineActivity;
import text.bwie.today.R;
import text.bwie.today.constants.Constants;
import text.bwie.today.events.MainActivityEvent;
import text.bwie.today.utils.PreferencesUtils;

/**
 * Created by lenovo-pc on 2017/5/10.
 */

public class LeftFragment extends BaseFragment implements View.OnClickListener{
    private SwitchButton switchButton;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.left_fragment, container, false);

        init();
        initView(view);
        init(view);

        return view;

    }

    private void init() {
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


    //日夜切换
    private void initView(View view) {

        switchButton = (SwitchButton) view.findViewById(R.id.switch_btn);

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                // isChecked true false
                System.out.println("isChecked = " + isChecked);
//
                boolean mode =  PreferencesUtils.getValueByKey(getContext(), Constants.isNightMode,isChecked);
                setMode(isChecked);
                EventBus.getDefault().post(new MainActivityEvent(isChecked));

                setBackground(isChecked);

            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }


    private void setBackground(boolean white){

        if(white){
            view.setBackgroundColor(Color.WHITE);
        } else {
            //夜间
            view.setBackgroundColor(Color.BLACK);
        }
    }


    // mode true 夜 false 日
    private void setMode(boolean mode){
        PreferencesUtils.addConfigInfo(getContext(), Constants.isNightMode,mode);

    }

}
