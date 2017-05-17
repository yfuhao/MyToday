package text.bwie.today.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import text.bwie.today.MyApplication;
import text.bwie.today.R;

/**
 * Created by lenovo-pc on 2017/5/10.
 */

public class RightFragment extends Fragment {

    private View view;
    private LinearLayout linearLayoutuser;
    private LinearLayout linearLayoutdenglu;
    private ImageView touxiang;
    private TextView user_name;
    private TextView user_zhanghao;
    private ImageView qqimageView;
    private ImageView xinlangimageView;
    private ImageView tingxunimageView;
    private SharedPreferences usershared;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.right_fragment, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        linearLayoutuser = (LinearLayout) view.findViewById(R.id.right_layout_user);
        linearLayoutdenglu = (LinearLayout) view.findViewById(R.id.right_layout_denglu);
        touxiang = (ImageView) view.findViewById(R.id.right_fragment_image_touxiang);
        user_name = (TextView) view.findViewById(R.id.right_fragment_tv_name);
        user_zhanghao = (TextView) view.findViewById(R.id.right_fragment_tv_zhanghao);

        usershared = getActivity().getSharedPreferences("user", Context.MODE_APPEND);

        qqimageView = (ImageView) view.findViewById(R.id.fragment_right_qq);
        xinlangimageView = (ImageView) view.findViewById(R.id.fragment_right_xinlang);
        tingxunimageView = (ImageView) view.findViewById(R.id.fragment_right_tingxun);
        String name = usershared.getString("user_name", null);
        String image = usershared.getString("user_image", null);
        String gender = usershared.getString("user_gender", null);
        if (name != null && image != null) {
            ImageLoader.getInstance().displayImage(image, touxiang, MyApplication.getdisplay());
            user_name.setText(name);
            user_zhanghao.setText(gender);
            linearLayoutuser.setVisibility(View.VISIBLE);
            linearLayoutdenglu.setVisibility(View.INVISIBLE);
        } else {
            linearLayoutuser.setVisibility(View.INVISIBLE);
            linearLayoutdenglu.setVisibility(View.VISIBLE);
        }

        //图片的监听事件
        imageclick();


    }

    private void imageclick() {
        qqimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //图片的监听事件
                shard();
            }
        });
        xinlangimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //图片的监听事件 Toast.makeText(getActivity(), "qq", Toast.LENGTH_SHORT).show();
                shard();
            }
        });
        tingxunimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //图片的监听事件 Toast.makeText(getActivity(), "qq", Toast.LENGTH_SHORT).show();
                shard();
            }
        });
    }

    //
    public void shard() {

        // mShareAPI.getPlatformInfo(UserinfoActivity.this, SHARE_MEDIA.SINA, umAuthListener);

        UMShareAPI.get(getActivity()).getPlatformInfo(getActivity(), SHARE_MEDIA.QQ, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {
                Toast.makeText(getActivity(), "开始登陆", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                String uid = map.get("uid");
                //姓名
                String name = map.get("name");
                //性别
                String gender = map.get("gender");
                //头像
                String iconurl = map.get("iconurl");
                String unionid = map.get("unionid");
                //添加到数据库中
                usershared.edit().putString("user_name", name).commit();
                usershared.edit().putString("user_image", iconurl).commit();
                usershared.edit().putString("user_gender", gender).commit();
                linearLayoutuser.setVisibility(View.VISIBLE);
                linearLayoutdenglu.setVisibility(View.INVISIBLE);
                ImageLoader.getInstance().displayImage(iconurl, touxiang, MyApplication.getdisplay());
                user_name.setText(name);
                user_zhanghao.setText("性别:" + gender);

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
