package text.bwie.today;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lenovo-pc on 2017/5/11.
 */

public class RegisterPhoneActivity extends Activity {

    private EditText user_phone;
    private EditText user_password;
    private TextView tv_register;
    private Button btn_register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        ImageView image_back= (ImageView) findViewById(R.id.left_head_back);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        user_phone = (EditText) findViewById(R.id.register_activity_edit_phone);
        user_password = (EditText) findViewById(R.id.register_activity_edit_password);
        tv_register = (TextView) findViewById(R.id.register_activity_text_register);
        btn_register = (Button) findViewById(R.id.register_activity_btn_register);



    }
}
