package com.arsgg.brolzyobattle.Pokemon;

import com.arsgg.brolzyobattle.GifDecoder;
import com.arsgg.brolzyobattle.Menu;
import com.arsgg.brolzyobattle.Mosse.Pallaombra;
import com.arsgg.brolzyobattle.Mosse.Proiettile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Gengar extends Mostro {
    public Gengar(boolean[] statoTasti) {
        super(statoTasti);
        hpMax=220;
        hp=hpMax;
        bulletsize=40;
        velocita=4;
        forza=10;
        x=0;
        y=0;

        Up=         GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Gengar/Up.gif").read());
        UpLeft=     GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Gengar/UpLeft.gif").read());
        UpRight=    GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Gengar/UpRight.gif").read());
        Down=       GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Gengar/Down.gif").read());
        DownRight=  GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Gengar/DownRight.gif").read());
        DownLeft=   GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Gengar/DownLeft.gif").read());
        Right=      GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Gengar/Right.gif").read());
        Left=       GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Gengar/Left.gif").read());


        AttUp=         GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Gengar/Attacco/Up.gif").read());
        AttUpLeft=     GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Gengar/Attacco/UpLeft.gif").read());
        AttUpRight=    GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Gengar/Attacco/UpRight.gif").read());
        AttDown=       GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Gengar/Attacco/Down.gif").read());
        AttDownRight=  GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Gengar/Attacco/DownRight.gif").read());
        AttDownLeft=   GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Gengar/Attacco/DownLeft.gif").read());
        AttRight=      GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Gengar/Attacco/Right.gif").read());
        AttLeft=       GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Gengar/Attacco/Left.gif").read());

        attuale=Up;
        sprite =new Sprite(attuale.getKeyFrame(1.0F));
        sprite.setSize(Menu.resize,Menu.resize);
    }

    @Override
    Proiettile Spara() {

        Proiettile p=new Pallaombra(x,y,direzione,bulletsize,bulletsize);
        return p;
    }
}

