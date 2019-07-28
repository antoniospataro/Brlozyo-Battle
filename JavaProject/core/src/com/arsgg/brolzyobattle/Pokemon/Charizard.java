package com.arsgg.brolzyobattle.Pokemon;

import com.arsgg.brolzyobattle.GifDecoder;
import com.arsgg.brolzyobattle.Menu;
import com.arsgg.brolzyobattle.Mosse.Turbofuoco;
import com.arsgg.brolzyobattle.Mosse.Proiettile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Charizard extends Mostro {

    public Charizard(boolean[] statoTasti) {
        super(statoTasti);
        hpMax=130;
        hp=hpMax;
        bulletsize=40;
        velocita=2;
        forza=20;
        x=0;
        y=0;

        Up=         GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Charizard/Up.gif").read());
        UpLeft=     GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Charizard/UpLeft.gif").read());
        UpRight=    GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Charizard/UpRight.gif").read());
        Down=       GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Charizard/Down.gif").read());
        DownRight=  GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Charizard/DownRight.gif").read());
        DownLeft=   GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Charizard/DownLeft.gif").read());
        Right=      GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Charizard/Right.gif").read());
        Left=       GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Charizard/Left.gif").read());


        AttUp=         GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Charizard/Attacco/Up.gif").read());
        AttUpLeft=     GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Charizard/Attacco/UpLeft.gif").read());
        AttUpRight=    GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Charizard/Attacco/UpRight.gif").read());
        AttDown=       GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Charizard/Attacco/Down.gif").read());
        AttDownRight=  GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Charizard/Attacco/DownRight.gif").read());
        AttDownLeft=   GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Charizard/Attacco/DownLeft.gif").read());
        AttRight=      GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Charizard/Attacco/Right.gif").read());
        AttLeft=       GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Charizard/Attacco/Left.gif").read());

        attuale=Up;
        sprite =new Sprite(attuale.getKeyFrame(1.0F));
        sprite.setSize(Menu.resize,Menu.resize);
    }

    @Override
    Proiettile Spara() {

        Proiettile p=new Turbofuoco(x,y,direzione,bulletsize,bulletsize);
        return p;
    }
}
