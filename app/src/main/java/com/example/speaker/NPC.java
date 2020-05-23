package com.example.speaker;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;


public class NPC {

    private Bitmap bitmap;
    private double x;
    private double y;

    private int width;
    private int height;


    public boolean isSpeak() { return speak; }
    public void setSpeak(boolean speak) { this.speak = speak; }

    private boolean speak;

    public Bitmap getBitmap() { return bitmap; }

    public double getX() {
        return x; }
    public void setX(double x) {
        this.x = x; }
    public double getY() {
        return y; }
    public void setY(double y) {
        this.y = y; }

    public NPC(double x, double y, Bitmap bitmap){
        this.bitmap = bitmap;
        this.x = x/1.334;
        this.y = y/1.334;
        this.width = bitmap.getWidth()/4;
        this.height = bitmap.getHeight()/4;
    }

    public Rect getBoxRect () {
        return new Rect((int)x, (int)y, (int)(x + width), (int)(y + height));
    }

    public boolean toSpeak (Sprite s) {
        return getBoxRect().intersect(s.getBoundingInBoxRect());
    }

    public void draw (Canvas canvas) {
        Paint p = new Paint();
        Rect frame = new Rect((int)x, (int)y, (int)(x + width), (int)(y + height));
        Rect frame2 = new Rect((int)0, (int)0, (int)width*4, (int)height*4);

        canvas.drawBitmap(bitmap, frame2, frame, p);
    }
}
