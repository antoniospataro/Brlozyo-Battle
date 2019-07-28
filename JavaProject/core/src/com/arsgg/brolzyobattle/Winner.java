package com.arsgg.brolzyobattle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

class Winner {

    private Texture winnerp1;
    private Texture winnerp2;
    private Texture back;
    private Music music;

    Winner() {
        inizialize();
    }

    private void inizialize(){
        if(MyGdxGame.nMap==1)
            back=new Texture("Background/map1.png");
        else if(MyGdxGame.nMap==2)
            back=new Texture("Background/map2.png");
        else if(MyGdxGame.nMap==3)
            back=new Texture("Background/map3.png");
        if(!MyGdxGame.isSingleplayer||MyGdxGame.isWinnerP1){
            music= Gdx.audio.newMusic(Gdx.files.internal("music/victory.mp3"));
            music.setLooping(true);
            music.setVolume(0.5f); }

        if(!MyGdxGame.isSingleplayer){
            winnerp1=new Texture("GameOver/P1Wins.png");
            winnerp2=new Texture("GameOver/P2Wins.png");}
        else{
            if(MyGdxGame.isWinnerP1)
                music= Gdx.audio.newMusic(Gdx.files.internal("music/victory.mp3"));
            else{
                music = Gdx.audio.newMusic(Gdx.files.internal("music/gameOver.mp3"));
                music.setLooping(false);
            }
            winnerp1=new Texture("GameOver/Winner.png");
            winnerp2=new Texture("GameOver/GameOver.png");
        }
        music();
    }

    private void music(){music.play();}

    void draw(Batch batch){

        batch.begin();

        batch.draw(back,0,0);
        if(MyGdxGame.isWinnerP1&&!MyGdxGame.isSingleplayer)
            batch.draw(winnerp1,MyGdxGame.width/2-230,MyGdxGame.height/2);
        if(MyGdxGame.isWinnerP1&&MyGdxGame.isSingleplayer)
            batch.draw(winnerp1,MyGdxGame.width/2-210,MyGdxGame.height/2);
        else if(MyGdxGame.isWinnerP2){
                if(!MyGdxGame.isSingleplayer)
                    batch.draw(winnerp2, MyGdxGame.width / 2 - 230, MyGdxGame.height / 2);
                else
                    batch.draw(winnerp2, MyGdxGame.width / 2 - 315, MyGdxGame.height / 2);
        }
            batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)||Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            MyGdxGame.isWinnerP2=false;
            MyGdxGame.isWinnerP1=false;
            MyGdxGame.isMenuMulti=true;
            music.stop();
        }
    }

    void dispose(){
        winnerp1.dispose();
        winnerp2.dispose();
        back.dispose();
        music.dispose();
    }
}
