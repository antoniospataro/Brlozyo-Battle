package com.arsgg.brolzyobattle.Pokemon;

import com.arsgg.brolzyobattle.GifDecoder;
import com.arsgg.brolzyobattle.Menu;
import com.arsgg.brolzyobattle.Mosse.PsicoOnda;
import com.arsgg.brolzyobattle.Mosse.Proiettile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Mewtwo extends Mostro {

    public Mewtwo(boolean[] statoTasti) {
        super(statoTasti);
        bulletsize=90;
        velocita=4;
        forza=30;
        hpMax=140;
        hp=hpMax;

        Up=         GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("mewtwo/Up.gif").read());
        UpLeft=     GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("mewtwo/UpLeft.gif").read());
        UpRight=    GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("mewtwo/UpRight.gif").read());
        Down=       GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("mewtwo/Down.gif").read());
        DownRight=  GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("mewtwo/DownRight.gif").read());
        DownLeft=   GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("mewtwo/DownLeft.gif").read());
        Right=      GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("mewtwo/Right.gif").read());
        Left=       GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP_PINGPONG, Gdx.files.internal("mewtwo/Left.gif").read());


        AttUp=         GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("mewtwo/Attacco/Up.gif").read());
        AttUpLeft=     GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("mewtwo/Attacco/UpLeft.gif").read());
        AttUpRight=    GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("mewtwo/Attacco/UpRight.gif").read());
        AttDown=       GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("mewtwo/Attacco/Down.gif").read());
        AttDownRight=  GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("mewtwo/Attacco/DownRight.gif").read());
        AttDownLeft=   GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("mewtwo/Attacco/DownLeft.gif").read());
        AttRight=      GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("mewtwo/Attacco/Right.gif").read());
        AttLeft=       GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("mewtwo/Attacco/Left.gif").read());



        attuale=Up;
        sprite =new Sprite(attuale.getKeyFrame(1.0F));
        sprite.setSize(Menu.resize,Menu.resize);
    }

    @Override
    Proiettile Spara() {
        return new PsicoOnda(x-20,y-20,direzione,bulletsize,bulletsize);
    }
}
