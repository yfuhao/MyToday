package text.bwie.today;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by lenovo-pc on 2017/5/10.
 */

public class RegisterActivity extends Activity {

    private Button btn_phone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mroeregister);

        init();

    }

    private void init() {
        btn_phone = (Button) findViewById(R.id.register_phone);
        ImageView image_back= (ImageView) findViewById(R.id.left_head_back);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,RegisterPhoneActivity.class);
                startActivity(intent);
            }
        });


    }
}
