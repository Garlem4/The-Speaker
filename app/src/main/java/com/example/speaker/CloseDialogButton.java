package com.example.speaker;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;


public class CloseDialogButton {
    private Rect but;

    public CloseDialogButton(){
        but = new Rect(150,100,50,200);
    }


    public void draw(Canvas canvas, int viewWidth){
        Paint p = new Paint();
        p.setTextSize(100.0f);
        p.setColor(Color.BLACK);
        but = new Rect(viewWidth-150,100,viewWidth-50,200);
        canvas.drawRect(but,p);
        p.setColor(Color.WHITE);
        canvas.drawText("X", viewWidth - 130, 185, p);
    }

    public boolean onClick(MotionEvent event){
            Rect ev = new Rect((int) event.getX() - 10, (int) event.getY() - 10, (int) event.getX() + 10, (int) event.getY() + 10);
            return ev.intersect(but);
    }

}
