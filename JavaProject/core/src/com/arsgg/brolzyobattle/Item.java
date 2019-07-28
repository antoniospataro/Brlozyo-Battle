package com.arsgg.brolzyobattle;

import com.arsgg.brolzyobattle.Pokemon.Mostro;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

class Item {
    private Sprite sprite;
    Rectangle rettangolo;
    private int value;

    Item(){
        rettangolo= new Rectangle();
        value=new Random().nextInt(4);
        value+=1;
        if(value==1)
            sprite= new Sprite(new Texture("Items/apple.png"));
        else if(value==2)
            sprite= new Sprite(new Texture("Items/apple2.png"));
        else if(value==3)
            sprite= new Sprite(new Texture("Items/steroid.png"));
        else if(value==4)
            sprite= new Sprite(new Texture("Items/ring.png"));

        if (sprite != null) {
            sprite.setX(new Random().nextInt(580));
            sprite.setY(new Random().nextInt(420));
            rettangolo.set(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
        }

    }

    void setSprite(Texture r){
        sprite= new Sprite(r);
    }
    void upgradeMostro(Mostro player){
        if(value==1)
            player.setHp(player.getHp()+(player.getHpMax()/4));
        if(value==2)
            player.setHp(player.getHp()+(player.getHpMax()/2));
        if(value==3)
            player.setForza(player.getForza()+2);
        if(value==4)
            player.setBulletsize(player.getBulletsize()+35);
        if(player.getHp()>player.getHpMax())
            player.setHp(player.getHpMax());
    }
    int getX(){return (int)sprite.getX();}
    int getY(){return (int)sprite.getY();}
    void drawItem(Batch batch){sprite.draw(batch);}
}
