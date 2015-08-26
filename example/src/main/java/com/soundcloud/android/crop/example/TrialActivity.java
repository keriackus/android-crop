package com.soundcloud.android.crop.example;


import android.app.Activity;

import android.content.Context;

import android.graphics.Canvas;

import android.graphics.Color;

import android.graphics.Paint;

import android.graphics.Path;

import android.os.Bundle;

import android.view.View;


public class TrialActivity extends Activity {


    /**
     * Called when the activity is first created.
     */

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(new MyView(this));

    }


    public class MyView extends View {





        public MyView(Context context) {

            super(context);

            // TODO Auto-generated constructor stub

        }


        @Override

        protected void onDraw(Canvas canvas) {

            // TODO Auto-generated method stub

            super.onDraw(canvas);


            Paint paint = new Paint();

            paint.setColor(Color.WHITE);

            paint.setStrokeWidth(3);

            paint.setStyle(Paint.Style.STROKE);

            Path path = new Path(HexagonUtils.createPath(550, 700,HexagonUtils.HexagonType.VERTICAL, 1000, 1000,100));



            canvas.drawPath(path, paint);
        }


    }

}