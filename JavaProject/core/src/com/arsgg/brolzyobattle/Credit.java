package com.arsgg.brolzyobattle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

class Credit {

    private BitmapFont font;
    private Texture background;
    Music music;

    Credit() {
        inizialize();
    }

    void inizialize(){
        font = new BitmapFont();
        background= new Texture("Menu/BackgroundMenu.png");
        font.setColor(Color.BLACK);
        music= Gdx.audio.newMusic(Gdx.files.internal("music/credits.mp3"));
        music.setLooping(true);
    }

    void draw(Batch batch){
        if(!music.isPlaying())
            music.play();
        batch.begin();
        batch.draw(background,0,0);
        font.draw(batch, "Created by Giuseppe Grottini and Antonio Spataro for graphical interfaces and event programming\n"+"Students in CS, UNICAL\n",1 , 370);
        font.draw(batch,"(Nintendo, please, don't report us!)",580/2-100,480/2);
        font.draw(batch, "Press G(rottini) for his github link or \n"+"Press S(pataro) for his github link",580/2-100,480/2-100);
        font.draw(batch,"All pokemon texture right reserved to Pokémon Mystery Dungeon: Explorers of Sky\n"+"map creation with Tiled and free Texture\n"+"Songs taked from Pokemon, Octopath Traveller, Final Fantasy,\nHaikyuu the anime and The legend of Zelda: Ocarina of time",1,480/2-150);
        batch.end();
        if(Gdx.input.isKeyJustPressed(Input.Keys.C) ||Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)||Gdx.input.isKeyJustPressed(Input.Keys.DEL)){
            MyGdxGame.isMenuMulti=true;
            MyGdxGame.isCredit=false;
            MyGdxGame.isMenu=false;
            music.stop();
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.G))
            Gdx.net.openURI("https://github.com/IlGrotta");
        else if(Gdx.input.isKeyJustPressed(Input.Keys.S))
            Gdx.net.openURI("https://github.com/antoniorocco");
    }
    void dispose(){
        background.dispose();
        font.dispose();
    }
}
