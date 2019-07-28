package com.arsgg.brolzyobattle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Random;

class Multiplayer {
    private Texture multi1;
    private Texture single1;
    private Texture multi2;
    private Texture single2;
    private Texture menuBackground;
    private Texture ghost;
    Texture brolzyobattle;
    private Sprite ghos;
    private Animation<TextureRegion> animation;
    private Sprite cursor;
    private Music music;
    private Integer dark;
    private float magic;

    void inizialize() {

        //possibilità randomica,all'avvio del eseguibile, di trovare un tema Lavandonia(città famosa nella fanbase pokemon)
        dark= new Random().nextInt(20);

        if(dark==1){magic=1f;
            ghost= new Texture("Menu/Ghost.png");
            ghos= new Sprite(ghost);
            ghos.setColor(1,1,1,1);
            ghos.setSize(160,150);
            ghos.setY(330);
            ghos.setX(230);
            menuBackground = new Texture("Menu/lavandonia.png");
            music= Gdx.audio.newMusic(Gdx.files.internal("music/lavender town's theme.mp3"));
        }
        else{
            menuBackground = new Texture("Menu/BackgroundMenu.png");
            brolzyobattle =new Texture("Menu/BrolzyoBattle.png");
            music= Gdx.audio.newMusic(Gdx.files.internal("music/Pokémon Theme Song.mp3"));
        }
        //end

        music.setLooping(true);
        music.setVolume(0.5f);
        single1 = new Texture("Menu/Singleplayer1.png");
        cursor= new  Sprite(single1);
        cursor.setSize(Menu.resize,Menu.resize);
        single2 = new Texture("Menu/Singleplayer2.png");
        multi1 = new Texture("Menu/Multiplayer1.png");
        multi2 = new Texture("Menu/Multiplayer2.png");
        cursor.setX(300);
        cursor.setY(100);
        animation=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP,Gdx.files.internal("Menu/cursor.gif").read());
    }

    void music() {
        music.play();
    }

    void draw(Batch batch, float time) {
        if(!music.isPlaying())
            music();
        cursor.setRegion(animation.getKeyFrame(time));
        batch.begin();
        batch.draw(menuBackground,0,0);
        drawCursorSelection(batch);
        if(dark==1){
            ghos.setAlpha(magic);
            ghos.draw(batch);if(magic>0){magic-=0.012;}else magic=1;}
        else
            batch.draw(brolzyobattle,640/2-250,480/2+70);
        batch.end();
        keyInput();
    }

    //disegna icona selezionata più grande, altre meno grandi.
    private void drawCursorSelection(Batch batch){
        if(cursor.getY()==100){
            batch.draw(multi2,100,100);
            batch.draw(single1,100,200);}
        else{
            batch.draw(multi1,100,100);
            batch.draw(single2,100,200);}
        cursor.draw(batch);
    }

    //prende gli input attuali e modifica posizione cursore/variabili di stato del menu
    private void keyInput(){
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN) && cursor.getY() != 100) {
            cursor.setPosition(cursor.getX() , cursor.getY()-100);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP) && cursor.getY() != 200) {
            cursor.setPosition(cursor.getX() , cursor.getY()+100);
        }
        if ((Gdx.input.isKeyJustPressed(Input.Keys.ENTER)||Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) && cursor.getY() ==200) {
            music.stop();
            MyGdxGame.isMenu = true;
            MyGdxGame.isMusic = false;
            MyGdxGame.isBattle = false;
            MyGdxGame.isSingleplayer = true;
            MyGdxGame.isMenuMulti =false;
        }
        if ((Gdx.input.isKeyJustPressed(Input.Keys.ENTER)||Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) && cursor.getY() ==100) {
            music.stop();
            MyGdxGame.isMenu = true;
            MyGdxGame.isMusic = false;
            MyGdxGame.isBattle = false;
            MyGdxGame.isSingleplayer = false;
            MyGdxGame.isMenuMulti =false;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.C)){
            MyGdxGame.isCredit=true;
            MyGdxGame.isMenuMulti=false;
            music.stop();
        }
    }

    void remove() {
        menuBackground.dispose();
        single1.dispose();
        single2.dispose();
        multi1.dispose();
        multi2.dispose();
        if(dark==1)
            ghost.dispose();
        else
            brolzyobattle.dispose();
        music.dispose();
    }

}
