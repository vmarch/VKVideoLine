package com.devtolife.vkvideoline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.VideoView;


public class FullActivity extends AppCompatActivity {

    VideoView videoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full);
        String vidString = getIntent().getStringExtra("urlOfVKPlayer");

        WebView mWebView = (WebView) findViewById(R.id.video_play);

        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new WebChromeClient());

//        mWebView.loadData(vidString, "text/html", "UTF-8");

        mWebView.loadUrl(vidString);

    }
}



