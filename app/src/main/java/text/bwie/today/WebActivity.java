package text.bwie.today;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;

/**
 * Created by yufuhao on 2017/5/17.
 */

public class WebActivity extends Activity {

    private WebView webview;
    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webview = (WebView) findViewById(R.id.web_activity);
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        // webview.getSettings().
        webview.loadUrl(url);
//        WebSettings webSettings = webview.getSettings();
//        webSettings.setUseWideViewPort(true);//设置此属性，可任意比例缩放
//        webSettings.setLoadWithOverviewMode(true);
        //webview.setPluginsEnabled(true);

        //在app中显示网页
//        webview.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                view.loadUrl(url);
//                return false;
//            }
//        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
