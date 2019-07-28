package com.arsgg.brolzyobattle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;

public class Menu {
    private Texture menuBackground;
    private Sprite chariDown;
    private Animation<TextureRegion> animation;
    private Animation<TextureRegion> chariAnimation;
    private Animation<TextureRegion> mewAnimation;
    private Animation<TextureRegion> ampharosAnimation;
    private Animation<TextureRegion> gengarAnimation;
    private Texture mewtwoP;
    private Texture mewtwoN;
    private Texture gengarP;
    private Texture gengarN;
    private Texture ampharN;
    private Texture ampharP;
    private Texture chariP;
    private Texture chariN;
    private Sprite amphaP;
    private Sprite amphaN;
    private Sprite gengaP;
    private Sprite gengaN;
    private Sprite charP;
    private Sprite charN;
    private Sprite mewtwP;
    private Sprite mewtwN;
    private Sprite menu;
    private Sprite cursor;
    private Sprite selected;
    private Music music;
    public static float resize=45;
    private float finestrelle;
    private float menuposition=45;
    private boolean exit=false;

    Menu() {
        inizialize();
    }

    private void inizialize(){
        create();
        sets();
        reset();
        music();
    }

    private void create(){
        finestrelle=resize+20F;
        music= Gdx.audio.newMusic(Gdx.files.internal("music/opening.mp3"));
        menuBackground = new Texture("Menu/BackgroundMenu.png");
        chariP = new Texture("Face/Charizard.png");
        mewtwoP = new Texture("Face/Mewtwo.png");
        gengarP=new Texture("Face/Gengar.png");
        ampharP= new Texture("Face/Ampharos.png");
        chariN = new Texture("Face/CharizardN.png");
        mewtwoN = new Texture("Face/MewtwoN.png");
        gengarN=new Texture("Face/GengarN.png");
        ampharN= new Texture("Face/AmpharosN.png");
        amphaN= new Sprite(ampharN);
        amphaP= new Sprite(ampharP);
        gengaP = new Sprite(gengarP);
        gengaN = new Sprite(gengarN);
        charP = new Sprite(chariP);
        charN= new Sprite(chariN);
        mewtwP = new Sprite(mewtwoP);
        mewtwN = new Sprite(mewtwoN);
        selected= new Sprite(chariN);
        cursor= new  Sprite(mewtwoP);
        chariDown= new Sprite(chariP);
        menu= new Sprite(menuBackground);
    }

    //settaggio variabili
    private void sets(){
        music.setLooping(true);
        music.setVolume(0.5f);
        chariDown.setX(640/2-menuposition);
        chariDown.setY(480/2+menuposition);
        chariDown.setSize(finestrelle,finestrelle);
        menu.setSize(640,480);
        amphaP.setSize(finestrelle,finestrelle);
        amphaP.setX(menuposition*11);
        amphaP.setY(menuposition*3);
        amphaN.setSize(finestrelle,finestrelle);
        amphaN.setX(menuposition*11);
        amphaN.setY(menuposition*3);
        gengaP.setSize(finestrelle,finestrelle);
        gengaP.setX(menuposition*8);
        gengaP.setY(menuposition*3);
        gengaN.setSize(finestrelle,finestrelle);
        gengaN.setX(menuposition*8);
        gengaN.setY(menuposition*3);
        mewtwP.setSize(finestrelle,finestrelle);
        mewtwP.setX(menuposition*5);
        mewtwP.setY(menuposition*3);
        mewtwN.setSize(finestrelle,finestrelle);
        mewtwN.setX(menuposition*5);
        mewtwN.setY(menuposition*3);
        charP.setSize(finestrelle,finestrelle);
        charN.setSize(finestrelle,finestrelle);
        charP.setX(menuposition*2);
        charP.setY(menuposition*3);
        charN.setX(menuposition*2);
        charN.setY(menuposition*3);
        cursor.setX(charP.getX()+10);
        cursor.setY(charP.getY());
        selected.setY(MyGdxGame.height-60);
        selected.setX(20);
        animation=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP,Gdx.files.internal("Menu/cursor.gif").read());
        chariAnimation=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG,Gdx.files.internal("Charizard/Down.gif").read());
        mewAnimation=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG,Gdx.files.internal("mewtwo/Down.gif").read());
        ampharosAnimation=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG,Gdx.files.internal("Ampharos/Down.gif").read());
        gengarAnimation=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG,Gdx.files.internal("Gengar/Down.gif").read());
    }

    void music(){
        if(!music.isPlaying())
            music.play();
    }

    void draw(Batch batch,float time){
        cursor.setRegion(animation.getKeyFrame(time));
        batch.begin();
        menu.draw(batch);
        drawSelected(batch,time);
        drawCursorSelection(batch,time);
        batch.end();
        keyInput();
        if(exit){music.stop();MyGdxGame.isMenu=false;MyGdxGame.isMusic=false;MyGdxGame.isMap=true;}
    }

    //reset dei valori
    private void reset(){
        MyGdxGame.isMewtwoP1=false;
        MyGdxGame.isChariP2=false;
        MyGdxGame.isChariP1=false;
        MyGdxGame.isMewtwoP2=false;
        MyGdxGame.isGengarP1=false;
        MyGdxGame.isGengarP2=false;
        MyGdxGame.isAmpharosP1=false;
        MyGdxGame.isAmpharosP2=false;
    }

    //disegna selezionato da player1
    private void drawSelected(Batch batch, float time){
        if(MyGdxGame.isChariP1){
            selected.setRegion(chariAnimation.getKeyFrame(time));
            selected.draw(batch);}
        if(MyGdxGame.isGengarP1){
            selected.setRegion(gengarAnimation.getKeyFrame(time));
            selected.draw(batch);}
        if(MyGdxGame.isMewtwoP1){
            selected.setRegion(mewAnimation.getKeyFrame(time));
            selected.draw(batch);}
        if(MyGdxGame.isAmpharosP1){
            selected.setRegion(ampharosAnimation.getKeyFrame(time));
            selected.draw(batch);}
    }

    //ingrandisce e diminuisce icone in base alla posizione/disegna il selezionato dal puntatore
    private void drawCursorSelection(Batch batch, float time){
        if(cursor.getX()-10==charP.getX()){
            charN.draw(batch);
            gengaP.draw(batch);
            mewtwP.draw(batch);
            amphaP.draw(batch); }
        else if(cursor.getX()-10==gengaP.getX()){
            charP.draw(batch);
            gengaN.draw(batch);
            mewtwP.draw(batch);
            amphaP.draw(batch);}
        else if(cursor.getX()-10==mewtwP.getX()){
            charP.draw(batch);
            gengaP.draw(batch);
            mewtwN.draw(batch);
            amphaP.draw(batch);}
        else if(cursor.getX()-10==amphaP.getX()){
            charP.draw(batch);
            gengaP.draw(batch);
            mewtwP.draw(batch);
            amphaN.draw(batch);}
        cursor.draw(batch);
        if(cursor.getX()-10==charP.getX()){
            chariDown.setRegion(chariAnimation.getKeyFrame(time));
            chariDown.draw(batch); }
        if(cursor.getX()-10==amphaP.getX()){
            chariDown.setRegion(ampharosAnimation.getKeyFrame(time));
            chariDown.draw(batch); }
        if(cursor.getX()-10==gengaP.getX()){
            chariDown.setRegion(gengarAnimation.getKeyFrame(time));
            chariDown.draw(batch); }
        if(cursor.getX()-10==mewtwP.getX()){
            chariDown.setRegion(mewAnimation.getKeyFrame(time));
            chariDown.draw(batch); }
    }

    //input
    private void keyInput(){
        //ritorna al multiplayer o elimina selezione
        if(Gdx.input.isKeyJustPressed(Input.Keys.DEL)||Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            if(MyGdxGame.isAmpharosP1||MyGdxGame.isChariP1||MyGdxGame.isGengarP1||MyGdxGame.isMewtwoP1)
                reset();
            else{
                MyGdxGame.isMenuMulti=true;
                MyGdxGame.isMenu=false;
            }
        }
        //end

        //credits
        if(Gdx.input.isKeyJustPressed(Input.Keys.C)){
            MyGdxGame.isCredit=true;
            MyGdxGame.isMenuMulti=false;
            music.stop();
        }//end

        //muovi destra e sinistra
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) && cursor.getX()-10!=amphaP.getX()){cursor.setPosition(cursor.getX()+menuposition*3,cursor.getY());}
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT) && cursor.getX()-10!=charP.getX()){cursor.setPosition(cursor.getX()-menuposition*3,cursor.getY());}
        //end

        //selezione dei personaggi
        if ((Gdx.input.isKeyJustPressed(Input.Keys.ENTER)||Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) && cursor.getX()-10==charP.getX()){if(MyGdxGame.isChariP1||MyGdxGame.isGengarP1||MyGdxGame.isAmpharosP1||MyGdxGame.isMewtwoP1){MyGdxGame.isChariP2=true;exit=true;}
        else{MyGdxGame.isChariP1=true;}
        }
        if ((Gdx.input.isKeyJustPressed(Input.Keys.ENTER)||Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) && cursor.getX()-10==gengaP.getX()){if(MyGdxGame.isChariP1||MyGdxGame.isGengarP1||MyGdxGame.isMewtwoP1||MyGdxGame.isAmpharosP1){MyGdxGame.isGengarP2=true;exit=true;}
        else {MyGdxGame.isGengarP1=true;}
        }
        if ((Gdx.input.isKeyJustPressed(Input.Keys.ENTER)||Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) && cursor.getX()-10==mewtwP.getX()){if(MyGdxGame.isChariP1||MyGdxGame.isGengarP1||MyGdxGame.isMewtwoP1||MyGdxGame.isAmpharosP1){MyGdxGame.isMewtwoP2=true;exit=true;}
        else {MyGdxGame.isMewtwoP1=true;}
        }
        if ((Gdx.input.isKeyJustPressed(Input.Keys.ENTER)||Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) && cursor.getX()-10==amphaP.getX()){if(MyGdxGame.isChariP1||MyGdxGame.isGengarP1||MyGdxGame.isMewtwoP1||MyGdxGame.isAmpharosP1){MyGdxGame.isAmpharosP2=true;exit=true;}
        else {MyGdxGame.isAmpharosP1=true;}
        }
        //end
    }

    void remove(){
        chariP.dispose();
        mewtwoP.dispose();
        gengarP.dispose();
        chariN.dispose();
        mewtwoN.dispose();
        gengarN.dispose();
        menuBackground.dispose();
        music.dispose();
    }
}
