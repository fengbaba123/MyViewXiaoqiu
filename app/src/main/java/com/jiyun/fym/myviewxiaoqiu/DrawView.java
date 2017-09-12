package com.jiyun.fym.myviewxiaoqiu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 冯玉苗 on 2017/4/24.
 */

public class DrawView extends View {
    Canvas canvas;
    Handler handler=new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    if (x + 10 <= canvas.getWidth()) {
                        x += 1;
                    } else {
                        x = 0;
                    }
                    invalidate();
                    break;
            }

        }
    };
    float x = 60, y = 60;
    Paint paint = new Paint();

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas=canvas;
        paint.setColor(Color.GREEN);
        canvas.drawCircle(x, y, 15, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                Timer timer=new Timer();
                timer.schedule(new Task(),100,1);
                return true;
        }

        x = event.getX();
        y = event.getY();
        invalidate();
        return true;
    }

    public class Task extends TimerTask {
        @Override
        public void run() {
            handler.sendEmptyMessage(1);
        }
    }
}
