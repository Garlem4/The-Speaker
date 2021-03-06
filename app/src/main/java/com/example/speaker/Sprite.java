package com.example.speaker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.List;


public class Sprite {
    private Bitmap bitmap;

    private List<Rect> frames;
    private int frameWidth;
    private int frameHeight;
    private int currentFrame;
    private double frameTime;
    private double timeForCurrentFrame;

    private double x;
    private double y;

    private double velocityX;
    private double velocityY;

    private int padding;


    public Sprite(double x,
                  double y,
                  double velocityX,
                  double velocityY,
                  Rect initialFrame,
                  Bitmap bitmap)     {

        this.x = x;
        this.y = y;
        this.velocityX = velocityX;
        this.velocityY = velocityY;

        this.bitmap = bitmap;

        this.frames = new ArrayList<Rect>();
        this.frames.add(initialFrame);

        this.bitmap = bitmap;

        this.timeForCurrentFrame = 0.0;
        this.frameTime = 50;
        this.currentFrame = 0;

        this.frameWidth = initialFrame.width()/2;
        this.frameHeight = initialFrame.height()/2;

        this.padding = 20;
    }

    public void setBitmap(Bitmap NewBitmap){
        this.bitmap = NewBitmap;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getFrameWidth() {
        return frameWidth;
    }


    public int getFrameHeight() {
        return frameHeight;
    }

    public double getVx() {
        return velocityX;
    }

    public void setVx(double velocityX) {
        this.velocityX = velocityX;
    }

    public double getVy() {
        return velocityY;
    }

    public void setVy(double velocityY) {
        this.velocityY = velocityY;
    }

    public void addFrame (Rect frame) {
        frames.add(frame);
    }

    public void update (int ms) {
        timeForCurrentFrame += ms;

        if (timeForCurrentFrame >= frameTime) {
            currentFrame = (currentFrame + 1) % frames.size();
            timeForCurrentFrame = timeForCurrentFrame - frameTime;
        }

        x = x + velocityX * ms/1000.0;
        y = y + velocityY * ms/1000.0;
    }

    public void stopAnimate(){
        timeForCurrentFrame = 0;
        currentFrame = 1;
    }

    public void draw (Canvas canvas) {
        Paint p = new Paint();

        Rect destination = new Rect((int)x, (int)y, (int)(x + frameWidth), (int)(y + frameHeight));
        canvas.drawBitmap(bitmap, frames.get(currentFrame), destination,  p);
    }

    public Rect getBoundingBoxRect () {
        return new Rect((int)x-5,
                (int)y-5,
                (int)(x + frameWidth + 5),
                (int)(y + frameHeight + 5));
    }

    public Rect getBoundingInBoxRect () {
        return new Rect((int)x+frameWidth/3, (int)y+frameHeight/3, (int)(x + 2*frameWidth/3), (int)(y + 2*frameHeight/3));
    }


    public boolean intersect (Sprite s) {
        return getBoundingInBoxRect().intersect(s.getBoundingInBoxRect());
    }

    public boolean onCenter (int width, int height) {
        return getBoundingInBoxRect().intersect(
                new Rect((int)(width/2-5),(int)(height/2-5),(int)(width/2+5),(int)(height/2+5))
        );
    }

}
