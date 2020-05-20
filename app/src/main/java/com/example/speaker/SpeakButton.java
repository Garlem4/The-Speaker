package com.example.speaker;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

public class SpeakButton {

    private Rect but;
    private boolean isIt = false;
    private boolean dialog = false;

    public boolean isDialog() { return dialog; }

    public void setDialog(boolean dialog) { this.dialog = dialog; }

    public boolean isIt() { return isIt; }

    public void setIt(boolean it) { isIt = it; }




    public void draw(Canvas canvas, int viewWidth, int viewHeight){
        Paint p = new Paint();
        p.setTextSize(55.0f);
        p.setColor(Color.GRAY);
        but = new Rect(viewWidth / 2 - 150, viewHeight - 250, viewWidth / 2 + 150,viewHeight - 125);
        canvas.drawRect(but,p);
        p.setColor(Color.WHITE);
        canvas.drawText("Speak!", viewWidth / 2 - 80, viewHeight - 175, p);
    }

    public boolean onClick(MotionEvent event){
        if (isIt==true) {
            Rect ev = new Rect((int) event.getX() - 10, (int) event.getY() - 10, (int) event.getX() + 10, (int) event.getY() + 10);
            return ev.intersect(but);
        } else {return false;}
    }

}
