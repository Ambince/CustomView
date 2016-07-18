package com.example.administrator.coupondisplayviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016/7/13 0013.
 */
public class CouponDisplayView extends LinearLayout {private Paint mPaint;
    /**
     * 圆间距
     */
    private float gap = 10;
    /**
     * 半径
     */
    private float radius = 20;
    /**
     * 圆数量
     */
    private int circleNum;

    private float remain;


    public CouponDisplayView(Context context) {
        super(context);
    }

    public CouponDisplayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.v("Amence","CouponDisplayView");
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setDither(true);
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.v("Amence","onSizeChanged");
        if (remain==0){
            //计算不整除的剩余部分
            remain = (int)(w-gap)%(2*radius+gap);
        }
        circleNum = (int) ((w-gap)/(2*radius+gap));
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.v("Amence","onDraw");

        for (int i=0;i<circleNum;i++){
            float x = gap+radius+remain/2+((gap+radius*2)*i);
            canvas.drawCircle(x,0,radius,mPaint);
            canvas.drawCircle(x,getHeight(),radius,mPaint);
        }
    }
}
