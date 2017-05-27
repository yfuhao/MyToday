package text.bwie.today.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kyleduo.switchbutton.SwitchButton;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.greenrobot.eventbus.EventBus;

import java.util.Map;

import text.bwie.today.City_list.City_activity;
import text.bwie.today.MyApplication;
import text.bwie.today.OfflineActivity;
import text.bwie.today.R;
import text.bwie.today.constants.Constants;
import text.bwie.today.events.MainActivityEvent;
import text.bwie.today.utils.PreferencesUtils;

/**
 * Created by lenovo-pc on 2017/5/10.
 */

public class LeftFragment extends BaseFragment implements View.OnClickListener {
    private SwitchButton switchButton;
    private View view;
    private ImageView qq;
    private ImageView tengxun;
    private ImageView weibo;
    private LinearLayout denglu;
    private LinearLayout user;
    private ImageView user_image;
    private TextView user_name;
    private TextView user_gender;
    private SharedPreferences usershared;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.left_fragment, container, false);
        //第三方登陆
        initqq(view);

        //日间夜间切换
        initView(view);
        //离线缓存监听
        init(view);

        city_list(view);

        return view;

    }

    private void city_list(View view) {
        ImageView image_city = (ImageView) view.findViewById(R.id.left_city);
        image_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), City_activity.class);
                startActivity(intent);
            }
        });
    }


    //离线缓存监听
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

                boolean mode = PreferencesUtils.getValueByKey(getContext(), Constants.isNightMode, isChecked);
                setMode(isChecked);
                EventBus.getDefault().post(new MainActivityEvent(isChecked));

                setBackground(isChecked);

            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }


    private void setBackground(boolean white) {

        if (white) {
            view.setBackgroundColor(Color.WHITE);
        } else {
            //夜间
            view.setBackgroundColor(Color.BLACK);
        }
    }


    // mode true 夜 false 日
    private void setMode(boolean mode) {
        PreferencesUtils.addConfigInfo(getContext(), Constants.isNightMode, mode);

    }

    //第三方登陆
    private void initqq(View view) {
        usershared = getActivity().getSharedPreferences("user", Context.MODE_APPEND);
        denglu = (LinearLayout) view.findViewById(R.id.fragment_left_denglu);
        user = (LinearLayout) view.findViewById(R.id.fragment_left_user);
        qq = (ImageView) view.findViewById(R.id.left_image_qzone);
        tengxun = (ImageView) view.findViewById(R.id.left_image_tencent);
        weibo = (ImageView) view.findViewById(R.id.left_image_weibo);
        //显示图片
        user_image = (ImageView) view.findViewById(R.id.fragment_left_user_image);
        user_name = (TextView) view.findViewById(R.id.fragment_left_user_name);
        user_gender = (TextView) view.findViewById(R.id.fragment_left_user_gender);
        String name = usershared.getString("user_name", null);
        String image = usershared.getString("user_image", null);
        String gender = usershared.getString("user_gender", null);
        if (name != null && image != null) {
            ImageLoader.getInstance().displayImage(image, user_image, MyApplication.getdisplay());
            user_name.setText(name);
            user_gender.setText(gender);
            user.setVisibility(View.VISIBLE);
            denglu.setVisibility(View.INVISIBLE);
        } else {
            user.setVisibility(View.INVISIBLE);
            denglu.setVisibility(View.VISIBLE);
        }

        //图片的监听
        imageonclick();
    }

    private void imageonclick() {
        qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shard();
            }
        });
        tengxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shard();
            }
        });
        weibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shard();
            }
        });
    }

    //
    public void shard() {

        UMShareAPI.get(getActivity()).getPlatformInfo(getActivity(), SHARE_MEDIA.QQ, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {
                Toast.makeText(getActivity(), "开始登陆", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                //String uid = map.get("uid");
                String name = map.get("name");
                //性别
                String gender = map.get("gender");
                String iconurl = map.get("iconurl");
                // String unionid = map.get("unionid");
                user_name.setText(name);
                ImageLoader.getInstance().displayImage(iconurl, user_image, MyApplication.getdisplay());
                user_name.setText(name);
                user_gender.setText(gender);
                usershared.edit().putString("user_name", name).commit();
                usershared.edit().putString("user_image", iconurl).commit();
                usershared.edit().putString("user_gender", gender).commit();
                denglu.setVisibility(View.INVISIBLE);
                user.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                Toast.makeText(getActivity(), "登录失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {
                Toast.makeText(getActivity(), "登录取消", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(getActivity()).onActivityResult(requestCode, resultCode, data);
    }
}
