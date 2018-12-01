package com.faraa.sohrabpakravan.dambel.Helpers;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.faraa.sohrabpakravan.dambel.R;


public class CustomRatingBar extends android.support.v7.widget.AppCompatRatingBar {

    private Bitmap bitmapOn;
    private Bitmap bitmapOff;

    private Resources res = getResources();
    private Paint paint;

    private int radius = 80;
    private int WIDTH = 25;
    private int HEIGHT = 25;


    @Override
    protected void drawableStateChanged() {
        // TODO Auto-generated method stub
        super.drawableStateChanged();
    }


    public CustomRatingBar(Context context) {
        super(context);
        bitmapOn = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res, R.drawable.filled_purple_star), WIDTH, HEIGHT, true);
        bitmapOff = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res, R.drawable.empty_purple_star), WIDTH, HEIGHT, true);
    }

    public CustomRatingBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        bitmapOn = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res, R.drawable.filled_purple_star), WIDTH, HEIGHT, true);
        bitmapOff = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res, R.drawable.empty_purple_star), WIDTH, HEIGHT, true);
    }

    public CustomRatingBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        bitmapOn = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res, R.drawable.filled_purple_star), WIDTH, HEIGHT, true);
        bitmapOff = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res, R.drawable.empty_purple_star), WIDTH, HEIGHT, true);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(h, w, oldh, oldw);

        bitmapOn = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res, R.drawable.filled_purple_star), WIDTH, HEIGHT, true);
        bitmapOff = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res, R.drawable.empty_purple_star), WIDTH, HEIGHT, true);


    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec,
                                          int heightMeasureSpec) {
        super.onMeasure(heightMeasureSpec, widthMeasureSpec);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    protected synchronized void onDraw(Canvas canvas) {
        paint = new Paint();

        float rating = getRating();
        float x = getPivotX() - radius;
        float y = 0; // 60 for rotate 90
        double theta1 = 4 * Math.PI / 3 - Math.PI / (6);
        double theta2 = 4 * Math.PI / 3;

        for (int i = 1; i <= getNumStars(); ++i) {
            if (i <= (int) rating) {
                canvas.drawBitmap(bitmapOn, x, y, paint);
            } else {
                canvas.drawBitmap(bitmapOff, x, y, paint);
            }

            //x += radius * Math.abs((Math.cos(i * Math.PI / 4) -Math.cos((i - 1) * Math.PI / 4)));

            //if(i<3)
            //  y += radius * Math.abs((Math.sin(i * Math.PI / 4) - Math.sin((i - 1) * Math.PI / 4)));
            //            //                //else
            //y -= radius * Math.abs((Math.sin(i * Math.PI / 4) - Math.sin((i - 1) * Math.PI / 4)));

            x += radius * (Math.cos(theta2) - Math.cos(theta1));
            y -= radius * (Math.sin(theta2) - Math.sin(theta1));
            theta1 = theta2;
            theta2 += Math.PI / (6);
        }


       /* for (int i = 1; i <= stars; i++) {

            if (i <= 3) {

                x += 30;
                y += 10;

                if (i <= (int) rating ) {
                    bitmap = BitmapFactory.decodeResource(res, R.drawable.star_enable);
                } else {
                    bitmap = BitmapFactory.decodeResource(res, R.drawable.star_disable);
                }
                Bitmap scaled = Bitmap.createScaledBitmap(bitmap, 25, 25, true);
                canvas.drawBitmap(scaled, x, y, paint);
                //canvas.save();
            } else {

                x += 30;
                y -= 10;

                if (i<=(int) rating ) {
                    bitmap = BitmapFactory.decodeResource(res, R.drawable.star_enable);
                } else {
                    bitmap = BitmapFactory.decodeResource(res, R.drawable.star_disable);
                }
                Bitmap scaled = Bitmap.createScaledBitmap(bitmap, 25, 25, true);
                canvas.drawBitmap(scaled, x, y, paint);
                //canvas.save();
            }


        }*/

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled()) {
            return false;
        }

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                setSelected(true);
                setPressed(true);
                break;
            case MotionEvent.ACTION_MOVE:
                setProgress(//getMax()
                        (int) (getMax() * event.getX() / (2 * getPivotX() - radius)));
                onSizeChanged(getWidth(), getHeight(), 0, 0);

                break;
            case MotionEvent.ACTION_UP:
                setSelected(false);
                setPressed(false);
                break;

            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }

    @Override
    public synchronized void setProgress(int progress) {

        if (progress >= 0)
            super.setProgress(progress);

        else
            super.setProgress(0);
        // onSizeChanged(x, y, z, w);

    }
}