package text.bwie.today.wxapi;

import android.os.Bundle;

import com.umeng.weixin.callback.WXCallbackActivity;

import text.bwie.today.R;

public class WXEntryActivity extends WXCallbackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxentry);

    }
}
