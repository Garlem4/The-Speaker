package com.example.speaker;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
    public void draw(Canvas canvas,  int viewWidth, int viewHeight){
        Paint p = new Paint();
        p.setColor(Color.GRAY);
        canvas.drawRect(50,100,viewWidth-50,viewHeight-100,p);
        closeB.draw(canvas,viewWidth);
    }

   public boolean Close(MotionEvent event){
        return closeB.onClick(event);
   }
}
