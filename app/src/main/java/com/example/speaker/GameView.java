package com.example.speaker;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;



public class GameView extends View{

    private Sprite player;
    private Sprite target;
    private InitializeNPC npc;
    private Background background;
    private InitializeWalls walls;
    private SpeakButton button;
    private DialogWindow dialog;

    private int viewWidth;
    private int viewHeight;

    private float moveX = 0;
    private float moveY = 0;

    private float postX = 0;
    private float postY = 0;

    private int tarX;
    private int tarY;
    private int playX;
    private int playY;
    private boolean onetime = true;

    private final int timerInterval = 30;

    public GameView(Context context) {
        super(context);

        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.mainman);
        int w = b.getWidth()/4;
        int h = b.getHeight()/3;

        playX = w;
        playY = h;

        Rect firstFrame = new Rect(0, 0, w, h);
        player = new Sprite(viewWidth/2, viewHeight/2, 0, 0, firstFrame, b);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 2 && j == 2) {
                    continue;
                }
                player.addFrame(new Rect(j*w, i*h, j*w+w, i*h+h));
            }
        }
        b = BitmapFactory.decodeResource(getResources(), R.drawable.target);
        w = b.getWidth()/6;
        h = b.getHeight()/3;

        tarX = w;
        tarY = h;

        firstFrame = new Rect(0, 0, w, h);
        target = new Sprite(viewWidth/2, viewHeight/2, 0, 0, firstFrame, b);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {

                if (i ==0 && j == 0) {
                    continue;
                }

                if (i ==2 && j == 4) {
                    continue;
                }

                target.addFrame(new Rect(j*w, i*h, j*w+w, i*h+h));
            }
        }

        Timer t = new Timer();
        t.start();


        b = BitmapFactory.decodeResource(getResources(), R.drawable.map);
        background = new Background(b);

        walls = new InitializeWalls("map1");
        npc = new InitializeNPC("map1", context);
        button = new SpeakButton();
        dialog = new DialogWindow();
    }



    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRGB(79, 144, 146);
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setTextSize(55.0f);
        p.setColor(Color.WHITE);

        background.draw(canvas, viewWidth, viewHeight);
        target.draw(canvas);


//        for(Wall wall : walls.getListWall()){ //show all the walls
//        wall.draw(canvas);
//        }

        for (NPC unit : npc.getListNPC()) { //show all the npc
            unit.draw(canvas);
        }

        player.draw(canvas);

        if (onetime) {
            target.setX(viewWidth / 2 - tarX / 2);
            target.setY(viewHeight / 2 - tarY / 2);
            player.setX(viewWidth / 2 - playX / 2);
            player.setY(viewHeight / 2 - playY / 2);
            onetime = false;
        }

        for (NPC unit : npc.getListNPC()) {
            if (unit.isSpeak()) {
                button.draw(canvas,viewWidth,viewHeight);
            }
        }
        if (button.isDialog()){
            dialog.draw(canvas,viewWidth,viewHeight);
        }
    }


    protected void update () {
        player.update(timerInterval);
        target.update(timerInterval);
        background.update(player,target,walls,npc);

        if (player.getY() + player.getFrameHeight() > viewHeight) {
            player.setY(viewHeight - player.getFrameHeight());
            player.setVy(0);
        }
        else if (player.getY() <= 0) {
            player.setY(0);
            player.setVy(0);
        }
        if (player.getX() + player.getFrameWidth() > viewWidth) {
            player.setX(viewWidth - player.getFrameWidth());
            player.setVx(0);
        }
        else if (player.getX() <= 0) {
            player.setX(0);
            player.setVx(0);
        }

        if (target.getY() + target.getFrameHeight() > viewHeight) {
            target.setY(viewHeight - target.getFrameHeight());
        }
        else if (target.getY() <= 0) {
            target.setY(0);
        }
        if (target.getX() + target.getFrameWidth() > viewWidth) {
            target.setX(viewWidth - target.getFrameWidth());
        }
        else if (target.getX() <= 0) {
            target.setX(0);
        }

        if (target.intersect(player)) {
                target.setVy(0);
                target.setVx(0);
                player.setVx(0);
                player.setVy(0);
                player.stopAnimate();
        }


        for(Wall wall : walls.getListWall()){
            if(wall.nearby(player)){
                target.setVy(0);
                target.setVx(0);
                player.stopAnimate();
                player.setX(player.getVx()*-0.25+player.getX());
                player.setY(player.getVy()*-0.25+player.getY());
                player.setVx(0);
                player.setVy(0);
            }
        }

        button.setIt(false);

        for(NPC unit: npc.getListNPC()){
            if(unit.toSpeak(player)){
                unit.setSpeak(true);
                button.setIt(true);
            }
        }
        for(NPC unit: npc.getListNPC()){
            if(!unit.toSpeak(player)){
                unit.setSpeak(false);
            }
        }

        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int eventAction = event.getAction();
        if (eventAction == MotionEvent.ACTION_DOWN) {

            if (button.onClick(event)) {
                button.setDialog(true);
            } else {

                if(!button.isDialog()) {
                    if (event.getY() > 0 && event.getX() > 0) {
                        float centeringX = (player.getBoundingBoxRect().left - player.getBoundingBoxRect().right) / 2;
                        float centeringY = (player.getBoundingBoxRect().top - player.getBoundingBoxRect().bottom) / 2;

                        moveX = event.getX() - player.getBoundingBoxRect().left + centeringX;
                        moveY = event.getY() - player.getBoundingBoxRect().top + centeringY;


                        postX = player.getBoundingBoxRect().left + centeringX + moveX;

                        if (postX > viewWidth - centeringX * 2) {
                            postX -= centeringX;
                        }
                        if (postX < 0 + centeringX * 2) {
                            postX += centeringX;
                        }

                        postY = player.getBoundingBoxRect().top + centeringY + moveY;
                        if (postY > viewWidth - centeringY * 2) {
                            postY -= centeringY;
                        }
                        if (postY < 0 + centeringY * 2) {
                            postY += centeringY;
                        }

                        target.setX(event.getX() + centeringX);
                        target.setY(event.getY() + centeringY);

                        if (event.getX() < player.getBoundingBoxRect().right) {
                            Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.mainmanback);
                            player.setBitmap(b);
                        }

                        if (event.getX() > player.getBoundingBoxRect().left) {
                            Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.mainman);
                            player.setBitmap(b);
                        }
                        player.setVx(moveX / (Math.abs(moveX) + Math.abs(moveY)) * 200);
                        player.setVy(moveY / (Math.abs(moveX) + Math.abs(moveY)) * 200);

                    }
                }

                if(dialog.Close(event)){ button.setDialog(false); }
            }
        }

        return true;
    }


    class Timer extends CountDownTimer {

        public Timer() {
            super(Integer.MAX_VALUE, timerInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

            update ();
        }

        @Override
        public void onFinish() {

        }
    }
}