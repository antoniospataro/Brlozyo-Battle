package com.arsgg.brolzyobattle;

import com.arsgg.brolzyobattle.Pokemon.Mostro;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

class LifeBar {

    private Texture barra;
    private Texture gui;
    private int x;
    private int y;
    LifeBar(boolean sinistra ){

        barra=new Texture("life/barravita.png");
        gui=new Texture("life/contenitorevita.png");
        y=430;
        if(sinistra) x=41;
        else
              x=381;
    }

    void stampaVita(Batch batch, Mostro mostro){
        if(mostro.getHp()<=0)return;
        int srcX=0;
        int srcY=0;
        float percentualevita=((float)mostro.getHp()/(float)mostro.getHpMax())*100;

        float wid=(250F*percentualevita)/100;
        int srcWidth=(int)wid;
        int srcHeight=20;
        batch.draw(gui,x,y);
        batch.draw(barra,x+8,y,srcX+10,srcY,srcWidth-10,srcHeight);
    }
    void dispose(){

        gui.dispose();
        barra.dispose();
    }
}
