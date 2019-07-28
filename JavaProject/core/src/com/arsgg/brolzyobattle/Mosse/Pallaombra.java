package com.arsgg.brolzyobattle.Mosse;
import com.arsgg.brolzyobattle.Pokemon.Mostro;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.arsgg.brolzyobattle.*;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Pallaombra extends Proiettile{


   public Pallaombra(int x, int y, Mostro.Direction direzione, float wi, float he){
       super( x,  y, direzione, wi, he);


       velocita=5;
       gif=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Mosse/pallaombra.gif").read());
       sprite=new Sprite(gif.getKeyFrame(1.0F));
       sprite.setPosition(this.x,this.y);

   }


}
