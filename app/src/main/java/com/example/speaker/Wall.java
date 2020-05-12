package com.example.speaker;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Wall {
    private double x;
    private double y;

    private int width;
    private int height;

    public double getX() {
        return x; }
    public void setX(double x) {
        this.x = x; }
    public double getY() {
        return y; }
    public void setY(double y) {
        this.y = y; }

    public Wall(double x, double  y, int width , int height){
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }


    public Rect getBoxRect () {
        return new Rect((int)x, (int)y, (int)(x + width), (int)(y + height));
    }


    public boolean nearby (Sprite s) {
        return getBoxRect().intersect(s.getBoundingInBoxRect());
    }

    public void draw(Canvas canvas){
        Paint p = new Paint();
        p.setColor(Color.WHITE);
        canvas.drawRect((float) x,(float) y,(float) x+width,(float) y+height, p);
    }

}
