package com.arsgg.brolzyobattle.Mosse;


import com.arsgg.brolzyobattle.Pokemon.Mostro;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

abstract public class Proiettile {
    private float w;
    private float h;
    public Animation<TextureRegion> gif;
    protected Sprite sprite;
    public Rectangle rettangolo;
    protected Mostro.Direction direzione;
    protected int x;
    protected int y;
    protected int velocita;


     protected Proiettile(int x, int y, Mostro.Direction direzione,float wi,float he){

         this.w=wi;
         this.h=he;
         this.x=x;
         this.y=y;

         this.direzione=direzione;
         if(direzione== Mostro.Direction.UP||direzione== Mostro.Direction.UpLeft||direzione== Mostro.Direction.UpRight)
             {
                 this.y+=(w/2);
             }

         if(direzione== Mostro.Direction.Down||direzione== Mostro.Direction.DownLeft||direzione== Mostro.Direction.DownRight)
             {
                 this.y-=(w/2);
             }

         if(direzione== Mostro.Direction.Left||direzione== Mostro.Direction.UpLeft||direzione== Mostro.Direction.DownLeft)
             {

                 this.x-=(h/2);
             }

         if(direzione== Mostro.Direction.Right||direzione== Mostro.Direction.UpRight||direzione== Mostro.Direction.DownRight)
             {
                 this.x+=(h/2);
             }
         rettangolo=new Rectangle();
    }



    private void aggiornaRettangolo(){
         rettangolo.set(x,y,sprite.getWidth(),sprite.getHeight());
    }


      public void aggiorna(float elapsed) {
        if(direzione==Mostro.Direction.UP ||direzione==Mostro.Direction.UpLeft||direzione==Mostro.Direction.UpRight) y+=velocita;
        if(direzione==Mostro.Direction.Down ||direzione==Mostro.Direction.DownLeft||direzione==Mostro.Direction.DownRight) y-=velocita;
        if(direzione==Mostro.Direction.Left ||direzione==Mostro.Direction.UpLeft||direzione==Mostro.Direction.DownLeft) x-=velocita;
        if(direzione==Mostro.Direction.Right ||direzione==Mostro.Direction.UpRight||direzione==Mostro.Direction.DownRight) x+=velocita;
        sprite=new Sprite(gif.getKeyFrame(elapsed));

              sprite.setPosition(x,y);
              sprite.setSize(w, h);
              aggiornaRettangolo();



    }

    public Sprite getDisegno(){return sprite;}


}
