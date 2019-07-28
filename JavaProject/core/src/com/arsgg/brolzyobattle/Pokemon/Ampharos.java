package com.arsgg.brolzyobattle.Pokemon;

import com.arsgg.brolzyobattle.GifDecoder;
import com.arsgg.brolzyobattle.Menu;
import com.arsgg.brolzyobattle.Mosse.Elettropalla;
import com.arsgg.brolzyobattle.Mosse.Proiettile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Ampharos extends Mostro {
    public Ampharos(boolean[] statoTasti) {
        super(statoTasti);
        bulletsize=40;
        velocita=3;
        forza=15;
        x=0;
        y=0;
        hpMax=100;
        hp=hpMax;

        Up=         GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Ampharos/Up.gif").read());
        UpLeft=     GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Ampharos/UpLeft.gif").read());
        UpRight=    GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Ampharos/UpRight.gif").read());
        Down=       GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Ampharos/Down.gif").read());
        DownRight=  GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Ampharos/DownRight.gif").read());
        DownLeft=   GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Ampharos/DownLeft.gif").read());
        Right=      GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Ampharos/Right.gif").read());
        Left=       GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("Ampharos/Left.gif").read());


        AttUp=         GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Ampharos/Attacco/Up.gif").read());
        AttUpLeft=     GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Ampharos/Attacco/UpLeft.gif").read());
        AttUpRight=    GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Ampharos/Attacco/UpRight.gif").read());
        AttDown=       GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Ampharos/Attacco/Down.gif").read());
        AttDownRight=  GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Ampharos/Attacco/DownRight.gif").read());
        AttDownLeft=   GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Ampharos/Attacco/DownLeft.gif").read());
        AttRight=      GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Ampharos/Attacco/Right.gif").read());
        AttLeft=       GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Ampharos/Attacco/Left.gif").read());

        attuale=Up;
        sprite =new Sprite(attuale.getKeyFrame(1.0F));
        sprite.setSize(Menu.resize,Menu.resize);
    }

    @Override
    Proiettile Spara() {

        Proiettile p=new Elettropalla(x,y,direzione,bulletsize,bulletsize);
        return p;
    }

}
