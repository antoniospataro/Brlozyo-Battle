package com.arsgg.brolzyobattle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

class Map {
    private boolean exit;
    private Texture background1;
    private Texture background2;
    private Texture background3;
    private Texture map1;
    private Texture map2;
    private Texture map3;
    private Sprite ma1;
    private Sprite ma2;
    private Sprite ma3;
    private Sprite cursor;
    private Animation<TextureRegion> animation;
    private int menuposition = 60;
    private Music music;

    Map() {
        inizialize();
    }

    private void inizialize(){
        create();
        sets();
        if(!music.isPlaying())
            music();
    }

    private void create(){
        music= Gdx.audio.newMusic(Gdx.files.internal("music/opening.mp3"));
        exit=false;
        background1= new Texture("Background/map1.png");
        background2= new Texture("Background/map2.png");
        background3= new Texture("Background/map3.png");
        map1=new Texture("Background/map1.png");
        map2=new Texture("Background/map2.png");
        map3=new Texture("Background/map3.png");
        ma1=new Sprite(map1);
        ma2= new Sprite(map2);
        ma3 = new Sprite(map3);
        cursor= new Sprite(map3);
        MyGdxGame.nMap=1;
    }

    private void sets(){
        music.setLooping(true);
        music.setVolume(0.5f);
        ma1.setSize(60,60);
        cursor.setSize(40,40);
        ma2.setSize(40,40);
        ma3.setSize(40,40);
        ma3.setX(menuposition*7);
        ma3.setY(menuposition*3);
        ma2.setX(menuposition*4);
        ma2.setY(menuposition*3);
        ma1.setX(menuposition);
        ma1.setY(menuposition*3);
        cursor.setX(ma1.getX()+10);
        cursor.setY(ma1.getY());
        animation=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Menu/cursor.gif").read());
    }

    void music(){ music.play();}

    void draw(Batch batch, float time){
        cursor.setRegion(animation.getKeyFrame(time));
        batch.begin();
        drawCursorSelection(batch);
        batch.end();
        keyInput();
        if(exit){music.stop();MyGdxGame.isMap=false;MyGdxGame.isMusic=false;MyGdxGame.isBattle=true;}
    }

    private void drawCursorSelection(Batch batch){
        if(cursor.getX()-10==ma1.getX()){
            batch.draw(background1,0,0);
            ma1.setSize(150,150);
            ma2.setSize(130,130);
            ma3.setSize(130,130);
            ma1.draw(batch);
            ma2.draw(batch);
            ma3.draw(batch);}
        else if(cursor.getX()-10==ma2.getX()){
            batch.draw(background2,0,0);
            ma2.setSize(150,150);
            ma1.setSize(130,130);
            ma3.setSize(130,130);
            ma1.draw(batch);
            ma2.draw(batch);
            ma3.draw(batch); }
        else if(cursor.getX()-10==ma3.getX()){
            batch.draw(background3,0,0);
            ma3.setSize(150,150);
            ma2.setSize(130,130);
            ma1.setSize(130,130);
            ma1.draw(batch);
            ma2.draw(batch);
            ma3.draw(batch);}
        cursor.draw(batch);
    }
    private void keyInput(){

        if(Gdx.input.isKeyJustPressed(Input.Keys.DEL)||Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            MyGdxGame.isMenu=true;
            MyGdxGame.isMap=false;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) && cursor.getX()-10!=ma3.getX()){cursor.setPosition(cursor.getX()+menuposition*3,cursor.getY());}
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT) && cursor.getX()-10!=ma1.getX()){cursor.setPosition(cursor.getX()-menuposition*3,cursor.getY());}

        if ((Gdx.input.isKeyJustPressed(Input.Keys.ENTER)||Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) && cursor.getX()-10==ma1.getX()){MyGdxGame.nMap=1;exit=true;}
        if ((Gdx.input.isKeyJustPressed(Input.Keys.ENTER)||Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) && cursor.getX()-10==ma2.getX()){MyGdxGame.nMap=2;exit=true;}
        if ((Gdx.input.isKeyJustPressed(Input.Keys.ENTER)||Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) && cursor.getX()-10==ma3.getX()){ MyGdxGame.nMap=3;exit=true;}
    }

    void remove(){
        background1.dispose();
        background2.dispose();
        background3.dispose();
        map1.dispose();
        map2.dispose();
        map3.dispose();
        music.dispose();
    }
}


