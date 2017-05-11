package text.bwie.today.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import text.bwie.today.R;
import text.bwie.today.utils.RegisterBean;

/**
 * Created by lenovo-pc on 2017/5/11.
 */


public class RegisterActivityRegister extends Activity {

    private EditText user_phone;
    private EditText user_password;
    private Button btn_register;
    private String phone;
    private String password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    private void init() {
        ImageView image_back = (ImageView) findViewById(R.id.left_head_back);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        user_phone = (EditText) findViewById(R.id.register_activity_edit_phone);
        user_password = (EditText) findViewById(R.id.register_activity_edit_password);
        btn_register = (Button) findViewById(R.id.register_activity_btn_register);

        //点击完成注册,进行验证
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = user_phone.getText().toString();
                password = user_password.getText().toString();
                checkLogin(phone, password);
            }
        });

    }

    //网络获取信息
    private void checkLogin(String phone, String password) {

        RequestParams params = new RequestParams("http://qhb.2dyt.com/Bwei/register?");


        params.addParameter("phone", phone);
        params.addParameter("password", password);
        params.addParameter("postkey", "1503d");

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                RegisterBean registerBean = gson.fromJson(result, RegisterBean.class);
                System.out.println(result);
                if (registerBean.getRet_code() == 200) {
                    Toast.makeText(RegisterActivityRegister.this, registerBean.getRet_msg(), Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(RegisterActivityRegister.this, registerBean.getRet_msg(), Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {
            }
        });

    }

}
