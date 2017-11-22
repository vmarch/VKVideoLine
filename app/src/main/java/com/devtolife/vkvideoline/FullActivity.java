package com.devtolife.vkvideoline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.VideoView;


public class FullActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full);

        String vidString = getIntent().getStringExtra("title");

        WebView browser=(WebView)findViewById(R.id.video_player);

        browser.loadUrl(vidString);

//        https://m.vk.com/video_ext.php?oid=-45441631&id=456240285&hash=678781a745502b7e&__ref=vk.api&api_hash=1511366326cadf2f988c46315c21_GQ2TKOJSGA3TGNQ


        System.out.println(vidString.toString());



    }

    }



