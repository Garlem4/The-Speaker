package com.example.speaker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;


public class Background {

    private Bitmap bitmap;
    private double x;
    private double y;

    private double VX;
    private double VY;

    private int width;
    private int height;


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
    public double getVX() {
        return VX;
    }
    public void setVX(double VX) {
        this.VX = VX;
    }
    public double getVY() {
        return VY;
    }
    public void setVY(double VY) {
        this.VY = VY;
    }
    public Background(Bitmap bitmap){
        this.bitmap = bitmap;
        this.x = 0;
        this.y = 0;
        this.VX = 0;
        this.VY = 0;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void draw (Canvas canvas, int width, int height) {
        Paint p = new Paint();
        this.width = width;
        this.height = height;

        Rect frame = new Rect((int)x, (int)y, (int)Math.round(width+x), (int)Math.round(height+y));

        canvas.drawBitmap(bitmap, frame, canvas.getClipBounds(), p);
    }
    public void update(Sprite spritep, Sprite spritet, Sprite npc) {
        if(spritep.getVx() != 0){

        VX = spritep.getVx();
        VY = spritep.getVy();
            if(x < 0 && VX < 0){VX = 0; VY = 0;}
            if(y < 0 && VY < 0){VY = 0; VX = 0;}
            if(x+width > bitmap.getWidth() && VX > 0){VY = 0; VX = 0;}
            if(y+height > bitmap.getHeight() && VY > 0){VY = 0; VX = 0;}

        x = x + VX * 0.05;
        y = y + VY * 0.05;
        spritet.setVx(VX*-1.7);
        spritet.setVy(VY*-1.7);
        npc.setX(npc.getX() + VX * -0.05);
        npc.setY(npc.getY() + VY * -0.05);
        }else {
            if (!spritep.onCenter(this.width, this.height)) {
                float centeringX = (spritep.getBoundingBoxRect().left - spritep.getBoundingBoxRect().right) / 2;
                float centeringY = (spritep.getBoundingBoxRect().top - spritep.getBoundingBoxRect().bottom) / 2;
                double moveX = spritep.getBoundingBoxRect().left - centeringX - this.width / 2;
                double moveY = spritep.getBoundingBoxRect().top - centeringY - this.height / 2;
                VX = moveX / (Math.abs(moveX) + Math.abs(moveY)) * 500;
                VY = moveY / (Math.abs(moveX) + Math.abs(moveY)) * 500;
                if(x < 0 && VX < 0){VX = 0;}
                if(y < 0 && VY < 0){VY = 0;}
                if(x+width > bitmap.getWidth() && VX > 0){VX = 0;}
                if(y+height > bitmap.getHeight() && VY > 0){VY = 0;}

                x = x + VX * 0.05;
                y = y + VY * 0.05;
                spritep.setX(spritep.getX() + VX * -0.05);
                spritep.setY(spritep.getY() + VY * -0.05);
                spritet.setX(spritet.getX() + VX * -0.05);
                spritet.setY(spritet.getY() + VY * -0.05);
                npc.setX(npc.getX() + VX * -0.05);
                npc.setY(npc.getY() + VY * -0.05);
            }
        }
    }
}
