package com.arsgg.brolzyobattle;

import com.arsgg.brolzyobattle.Mosse.Proiettile;
import com.arsgg.brolzyobattle.Pokemon.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.ArrayList;
import java.util.Random;


class Battle {
    private Collisioni collisioni;
    ArrayList<Proiettile> proiettili1;
    ArrayList<Proiettile> proiettili2;
    private LifeBar libR;
    private LifeBar libL;
    private Texture r;
    private Texture l;
    static Mostro player1;
    static Mostro player2;
    private Music music;
    private Texture background;
    private Controlli controllo1;
    private Controlli controllo2;
    private InputMultiplexer inp;
    private AI ai;
    static Item p;
    static Random rand;
    private boolean ispause;
    private Texture pause;

    Battle(){inizialize();}

    private void inizialize(){
        rand=null;
        p=null;
        ispause=false;
        libL= new LifeBar(true);
        libR = new LifeBar(false);

        //creazione 1 pg
        controllo1 = new Controlli(0);
        setPlayer();

        inp=new InputMultiplexer();
        inp.addProcessor(controllo1);
        if(controllo2!=null)
            inp.addProcessor(controllo2);

        Gdx.input.setInputProcessor(inp);

        setMap();

        proiettili1=new ArrayList<Proiettile>();
        proiettili2=new ArrayList<Proiettile>();
        collisioni=new Collisioni(this);
        pause= new Texture("Menu/Pause.png");
    }

    void music(){
        music.play();
    }

    void draw(Batch batch, float time){


            //inizio disegno pkmn e proiettili
            batch.begin();

            batch.draw(background, 0, 0);
            player1.getAttuale().draw(batch);
            player2.getAttuale().draw(batch);
            batch.draw(r, 340, 430);
            batch.draw(l, 0, 430);
            libR.stampaVita(batch, player2);
            libL.stampaVita(batch, player1);
            if (p != null)
                p.drawItem(batch);
            for (Proiettile p : proiettili1) {
                p.getDisegno().draw(batch);
            }
            for (Proiettile p : proiettili2) {
                p.getDisegno().draw(batch);
            }

            batch.end();
            //fine disegni
            if(!ispause) {
                if (MyGdxGame.isSingleplayer) {
                    ai.aggiorna();
                }

                Proiettile p1 = player1.aggiornamento(time);
                Proiettile p2 = player2.aggiornamento(time);

                if (p1 != null)
                    proiettili1.add(p1);
                if (p2 != null)
                    proiettili2.add(p2);

                for (Proiettile p : proiettili1) {
                    p.aggiorna(time);
                }

                for (Proiettile p : proiettili2) {
                    p.aggiorna(time);
                }
                collisioni.controlliCollisioni();
                collisioni.potionCollisioni();

                if (player2.getHp() <= 0 || player1.getHp() <= 0) {
                    MyGdxGame.isMenuMulti = false;
                    MyGdxGame.isBattle = false;
                    MyGdxGame.isMenu = false;
                    if (player1.getHp() <= 0 && player2.getHp() > 0)
                        MyGdxGame.isWinnerP2 = true;
                    else if (player2.getHp() <= 0 && player1.getHp() > 0)
                        MyGdxGame.isWinnerP1 = true;
                    music.stop();
                }
            }
        else{
            batch.begin();
            batch.draw(pause,480/2-100,560/2-80);
            batch.end();
        }
        InputPause();
    }

    private void InputPause(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            ispause= !ispause;
        }
    }

    private void setMap(){
        if(MyGdxGame.nMap==1){
            background= new Texture("Background/map1.png");
            music= Gdx.audio.newMusic(Gdx.files.internal("music/battle1.mp3"));}
        else if(MyGdxGame.nMap==2){
            background= new Texture("Background/map2.png");
            music= Gdx.audio.newMusic(Gdx.files.internal("music/battle2.mp3"));}
        else if(MyGdxGame.nMap==3) {
            background = new Texture("Background/map3.png");
            music= Gdx.audio.newMusic(Gdx.files.internal("music/battle3.mp3"));}
        music.setLooping(true);
        music.setVolume(0.5f);
    }

    private void setPlayer(){
        if(MyGdxGame.isMewtwoP1){
            l= new Texture("Face/Mewtwo.png");
            player1 = new Mewtwo(controllo1.StatoTasti);}
        else if(MyGdxGame.isAmpharosP1){
            l= new Texture("Face/Ampharos.png");
            player1 = new Ampharos(controllo1.StatoTasti);}
        else if(MyGdxGame.isChariP1){
            l= new Texture("Face/Charizard.png");
            player1 = new Charizard(controllo1.StatoTasti);}
        else{
            l= new Texture("Face/Gengar.png");
            player1= new Gengar((controllo1.StatoTasti));}
        player1.setY(250);
        player1.setX(40);


        //creazione 2giocatore
        if(!MyGdxGame.isSingleplayer){
            controllo2= new Controlli(1);
            if(MyGdxGame.isChariP2){
                player2 = new Charizard(controllo2.StatoTasti);
                r= new Texture("Face/Charizard.png");}
            else if(MyGdxGame.isMewtwoP2){
                player2 = new Mewtwo(controllo2.StatoTasti);
                r= new Texture("Face/Mewtwo.png");}
            else if(MyGdxGame.isAmpharosP2){
                player2 = new Ampharos(controllo2.StatoTasti);
                r= new Texture("Face/Ampharos.png");}
            else{
                player2= new Gengar((controllo2.StatoTasti));
                r= new Texture("Face/Gengar.png");
            }
        }

        else{
            ai = new AI();
            if(MyGdxGame.isChariP2){
                player2 = new Charizard(ai.statoTasti);
                r= new Texture("Face/Charizard.png");}
            else if(MyGdxGame.isMewtwoP2){
                player2 = new Mewtwo(ai.statoTasti);
                r= new Texture("Face/Mewtwo.png");}
            else if(MyGdxGame.isAmpharosP2){
                player2 = new Ampharos(ai.statoTasti);
                r= new Texture("Face/Ampharos.png");}
            else{
                player2= new Gengar((ai.statoTasti));
                r= new Texture("Face/Gengar.png");
            }
            ai.setGiocatori();
        }
        //fine creazione 2 pg
        player2.setY(250);
        player2.setX(550);
    }

    void dispose(){
        music.dispose();
        libL.dispose();
        libR.dispose();
        l.dispose();
        r.dispose();
        background.dispose();
        pause.dispose();
    }
}
