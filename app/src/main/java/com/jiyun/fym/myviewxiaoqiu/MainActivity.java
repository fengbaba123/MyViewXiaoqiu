package com.jiyun.fym.myviewxiaoqiu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = (LinearLayout) findViewById(R.id.activity);
        DrawView drawView = new DrawView(this);
        drawView.setMinimumHeight(200);
        drawView.setMinimumWidth(200);
        ll.addView(drawView);
    }
}
