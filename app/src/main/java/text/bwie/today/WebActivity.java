package text.bwie.today;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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
        System.out.println("url = "+url);
        webview.loadUrl(url);
        //在app中显示网页
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                webview.loadUrl(url);
                return true;
            }
        });

    }
}
