package com.example.speaker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

public class DialogWindow {
    private CloseDialogButton closeB;
    private int viewWidth;
    private int viewHeight;

    public DialogWindow(){
        this.viewHeight = viewHeight;
        this.viewWidth = viewWidth;
        closeB = new CloseDialogButton();
    }
    public void draw(Canvas canvas, int viewWidth, int viewHeight, Bitmap id, Context context){
        Paint p = new Paint();
        p.setColor(Color.LTGRAY);
        canvas.drawRect(50,100,viewWidth-50,viewHeight-100,p);

        Bitmap bg = BitmapFactory.decodeResource(context.getResources(),R.drawable.dialog);

        Rect frame = new Rect(50,100, viewWidth-50, viewHeight-100);
        Rect frame2 = new Rect(0,0, bg.getWidth(),bg.getHeight());

        canvas.drawBitmap(bg, frame2, frame, p);

        frame = new Rect(50,100, viewWidth-50, viewHeight*5/10-8);
        frame2 = new Rect(id.getWidth()/5,0, (int)Math.round(id.getWidth()/1.25),(int)Math.round(id.getHeight()/1.5));

        canvas.drawBitmap(id, frame2, frame, p);


        p.setColor(Color.BLACK);
        p.setTextSize(40.0f);
        canvas.drawText("Здесь текст NPC",70,(viewHeight-100)*625/1000,p);

        canvas.drawText("Здесь вариант ответа №1",70,(viewHeight-100)*775/1000,p);

        canvas.drawText("Здесь вариант ответа №2",70,(viewHeight-100)*87/100,p);

        canvas.drawText("Здесь вариант ответа №3",70,(viewHeight-100)*96/100,p);

        closeB.draw(canvas,viewWidth);
    }

   public boolean Close(MotionEvent event){
        return closeB.onClick(event);
   }
}
