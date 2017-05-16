package text.bwie.today.fragments;

import android.content.Intent;
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

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import text.bwie.today.R;

/**
 * Created by lenovo-pc on 2017/5/10.
 */

public class RightFragment extends Fragment {

    private View view;
    private LinearLayout linearLayoutuser;
    private LinearLayout linearLayoutdenglu;
    private ImageView touxiang;
    private TextView name;
    private TextView zhanghao;

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
        name = (TextView) view.findViewById(R.id.right_fragment_tv_name);
        zhanghao = (TextView) view.findViewById(R.id.right_fragment_tv_zhanghao);

        ImageView qqimageView = (ImageView) view.findViewById(R.id.fragment_right_qq);
        ImageView xinlangimageView = (ImageView) view.findViewById(R.id.fragment_right_xinlang);
        ImageView tingxunimageView = (ImageView) view.findViewById(R.id.fragment_right_tingxun);
        qqimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //图片的监听事件
                shard(SHARE_MEDIA.QQ);
            }
        });
        xinlangimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //图片的监听事件
                shard(SHARE_MEDIA.SINA);
            }
        });
        tingxunimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //图片的监听事件
                shard(SHARE_MEDIA.QQ);
            }
        });

    }

    //
    public void shard(SHARE_MEDIA qq) {

        // mShareAPI.getPlatformInfo(UserinfoActivity.this, SHARE_MEDIA.SINA, umAuthListener);

        UMShareAPI.get(getActivity()).getPlatformInfo(getActivity(), qq, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {
                Toast.makeText(getActivity(), "开始登陆", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                String uid = map.get("uid");
                String name = map.get("name");
                String gender = map.get("gender");
                String iconurl = map.get("iconurl");
//                linearLayoutuser.setVisibility(View.VISIBLE);
//                linearLayoutdenglu.setVisibility(View.INVISIBLE);
               // ImageLoader.getInstance().displayImage(iconurl, touxiang);
                System.out.println("name+name " + name);

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
