package com.arsgg.brolzyobattle.Mosse;

import com.arsgg.brolzyobattle.GifDecoder;
import com.arsgg.brolzyobattle.Pokemon.Mostro;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Turbofuoco extends Proiettile {
    public Turbofuoco(int x, int y, Mostro.Direction direzione,float wi,float he){
        super(x,  y, direzione, wi, he);

        velocita=5;
        gif= GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Mosse/turbofuoco.gif").read());
        sprite=new Sprite(gif.getKeyFrame(1.0F));
        sprite.setPosition(this.x,this.y);

    }



}
