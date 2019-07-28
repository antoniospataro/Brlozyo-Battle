package com.arsgg.brolzyobattle.Mosse;

import com.arsgg.brolzyobattle.Pokemon.Mostro;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.arsgg.brolzyobattle.*;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PsicoOnda extends Proiettile{


    public PsicoOnda(int x, int y, Mostro.Direction direzione, float wi, float he){
        super( x,  y, direzione, wi, he);
        setGif(direzione);
        velocita=5;
        sprite=new Sprite(gif.getKeyFrame(1.0F));
        sprite.setPosition(this.x,this.y);

    }

    void setGif(Mostro.Direction direzione){
        if(direzione== Mostro.Direction.UP)
            gif=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Mosse/psicoonda/Up.gif").read());
        if(direzione== Mostro.Direction.UpLeft)
            gif=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Mosse/psicoonda/UpLeft.gif").read());
        if(direzione== Mostro.Direction.UpRight)
            gif=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Mosse/psicoonda/UpRight.gif").read());
        if(direzione== Mostro.Direction.Down)
            gif=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Mosse/psicoonda/Down.gif").read());
        if(direzione== Mostro.Direction.DownLeft)
            gif=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Mosse/psicoonda/DownLeft.gif").read());
        if(direzione== Mostro.Direction.DownRight)
            gif=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Mosse/psicoonda/DownRight.gif").read());
        if(direzione== Mostro.Direction.Left)
            gif=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Mosse/psicoonda/Left.gif").read());
        if(direzione== Mostro.Direction.Right)
            gif=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Mosse/psicoonda/Right.gif").read());
    }

}