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

    public Bitmap getBitmap() {
        return bitmap; }
    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap; }
    public double getX() {
        return x; }
    public void setX(double x) {
        this.x = x; }
    public double getY() {
        return y; }
    public void setY(double y) {
        this.y = y; }
    public int getWidth() {
        return width; }
    public void setWidth(int width) {
        this.width = width; }
    public int getHeight() {
        return height; }
    public void setHeight(int height) {
        this.height = height; }

    public NPC(double x, double y, Bitmap bitmap){
        this.bitmap = bitmap;
        this.x = x;
        this.y = y;
        this.width = bitmap.getWidth();
        this.height = bitmap.getHeight();
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
        Rect frame2 = new Rect((int)0, (int)0, (int)width, (int)height);

        canvas.drawBitmap(bitmap, frame2, frame, p);
    }
}
