package com.arsgg.brolzyobattle.Pokemon;

import com.arsgg.brolzyobattle.Controlli;
import com.arsgg.brolzyobattle.MyGdxGame;
import com.arsgg.brolzyobattle.Mosse.Proiettile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Rectangle;


 abstract public class Mostro {
    public Rectangle rettangolo;
    int bulletsize;
    private boolean[] statoTasti;
    private boolean attaccando=false;
    public enum Direction{ UP,UpLeft,UpRight,Down,DownLeft,DownRight,Left,Right}
    private float cont=0;
    protected  Sprite sprite;
    public void setX(int x) {
         this.x = x;
     }
    public void setY(int y) {
         this.y = y;
     }
    protected  float velocita;
    protected  int x;
    protected int y;
    protected Direction direzione;
    int hp;
    int hpMax;
    int forza;

     Animation<TextureRegion> Up;
     Animation<TextureRegion> UpLeft;
     Animation<TextureRegion> UpRight;
     Animation<TextureRegion> Down;
     Animation<TextureRegion> DownRight;
     Animation<TextureRegion> DownLeft;
     Animation<TextureRegion> Right;
     Animation<TextureRegion> Left;
     Animation<TextureRegion> AttUp;
     Animation<TextureRegion> AttUpLeft;
     Animation<TextureRegion> AttUpRight;
     Animation<TextureRegion> AttDown;
     Animation<TextureRegion> AttDownRight;
     Animation<TextureRegion> AttDownLeft;
     Animation<TextureRegion> AttRight;
     Animation<TextureRegion> AttLeft;
     Animation<TextureRegion> attuale;


    Mostro( boolean[] statoTasti ){
        rettangolo=new Rectangle();
        this.statoTasti=statoTasti;
        direzione=Direction.Down;
    }
    public int getX() {
         return x;
     }
    public int getY() {
         return y;
     }

    public int getHpMax() {
         return hpMax;
     }
    private void aggiorna(boolean[] statoTasti){

        if(statoTasti[Controlli.up] && statoTasti[Controlli.left] && !statoTasti[Controlli.right]&& !statoTasti[Controlli.down] ) { direzione=Direction.UpLeft;    }
        else if(statoTasti[Controlli.up]&& statoTasti[Controlli.right]&& !statoTasti[Controlli.left]&& !statoTasti[Controlli.down]) {direzione=Direction.UpRight;   }
        else if(statoTasti[Controlli.down] && statoTasti[Controlli.left]&& !statoTasti[Controlli.right]&& !statoTasti[Controlli.up] ){direzione=Direction.DownLeft;  }
        else if(statoTasti[Controlli.down] && statoTasti[Controlli.right]&& !statoTasti[Controlli.up]&& !statoTasti[Controlli.left])  {direzione=Direction.DownRight; }
        else if(statoTasti[Controlli.up] && !statoTasti[Controlli.left] &&!statoTasti[Controlli.right]&&!statoTasti[Controlli.down]){direzione=Direction.UP; }
        else if(statoTasti[Controlli.down]&& !statoTasti[Controlli.right]&& !statoTasti[Controlli.left]&& !statoTasti[Controlli.up]){direzione=Direction.Down; }
        else if(statoTasti[Controlli.left]&& !statoTasti[Controlli.up]&& !statoTasti[Controlli.down]&& !statoTasti[Controlli.right]){direzione=Direction.Left; }
        else if(statoTasti[Controlli.right]&& !statoTasti[Controlli.up]&& !statoTasti[Controlli.down]&& !statoTasti[Controlli.left]){direzione=Direction.Right; }


        if(direzione==Direction.UP||direzione==Direction.UpLeft||direzione==Direction.UpRight)
         if(statoTasti[Controlli.up]&& MyGdxGame.height-40>y){
             y+=velocita;
         }

         if(direzione==Direction.Down||direzione==Direction.DownLeft||direzione==Direction.DownRight)
             if(statoTasti[Controlli.down]&&y>10){
             y-=velocita;
            }

         if(direzione==Direction.Left||direzione==Direction.UpLeft||direzione==Direction.DownLeft)
         if(statoTasti[Controlli.left]&&x>10){

             x-=velocita;
         }

         if(direzione==Direction.Right||direzione==Direction.UpRight||direzione==Direction.DownRight)
             if(statoTasti[Controlli.right]&&x<MyGdxGame.width-40){
             x+=velocita;
         }

        setAttuale();

    }
    public Sprite getAttuale(){
        return sprite;
    }
    private void setAttualeAttacco() {
        if(direzione==Direction.UP) attuale=AttUp;
        if(direzione==Direction.UpLeft) attuale=AttUpLeft;
        if(direzione==Direction.UpRight) attuale=AttUpRight;
        if(direzione==Direction.Down) attuale=AttDown;
        if(direzione==Direction.DownLeft) attuale=AttDownLeft;
        if(direzione==Direction.DownRight) attuale=AttDownRight;
        if(direzione==Direction.Left) attuale=AttLeft;
        if(direzione==Direction.Right) attuale=AttRight;

        }
    private void setAttuale() {
        if(direzione==Direction.UP) attuale=Up;
        if(direzione==Direction.UpLeft) attuale=UpLeft;
        if(direzione==Direction.UpRight) attuale=UpRight;
        if(direzione==Direction.Down) attuale=Down;
        if(direzione==Direction.DownLeft) attuale=DownLeft;
        if(direzione==Direction.DownRight) attuale=DownRight;
        if(direzione==Direction.Left) attuale=Left;
        if(direzione==Direction.Right) attuale=Right;

    }
    private void aggiornaRettangolo(){
        rettangolo.set(x,y, sprite.getWidth(), sprite.getHeight());
    }

    public int getForza() {
         return forza;
     }
    public void setForza(int forza) {
         this.forza = forza;
     }
    public Proiettile aggiornamento(float elapsed) {
         Proiettile p=null;
         cont+= Gdx.graphics.getDeltaTime();
         if(attaccando&& attuale.isAnimationFinished(cont))
         {   p=Spara();
             attaccando=false;
             cont=0F;
         }

         if(statoTasti[Controlli.space]&& !attaccando){
             statoTasti[Controlli.space]=false;
             setAttualeAttacco();
             attaccando=true;
             cont=0F;
         }

         else statoTasti[Controlli.space]=false;

         if(attaccando)  sprite.setRegion(attuale.getKeyFrame(cont));
         if(!attaccando) {
             aggiorna(statoTasti);
             sprite.setRegion(attuale.getKeyFrame(elapsed));
         }
         sprite.setPosition(x, y);
         aggiornaRettangolo();

         return p;
     }

     public int getBulletsize() {
         return bulletsize;
     }

     public void setBulletsize(int bulletsize) {
         this.bulletsize = bulletsize;
     }

     abstract  Proiettile Spara();
    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }


 }
