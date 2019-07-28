package com.arsgg.brolzyobattle;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class Controlli implements InputProcessor {
    public static int up=0;
    public static int down=1;
    public static int left=2;
    public static int right=3;
    public static int space=4;
    boolean[] StatoTasti;
    private int stato;


    Controlli(int i){StatoTasti=new boolean[5]; stato=i;Azzera();}
    private void Azzera(){
        for(int i=0; i<5;i++)
            StatoTasti[i]=false;
    }
    @Override
    public boolean keyDown(int keycode) {
        if(stato==0) {
            if (keycode== Keys.UP) StatoTasti[up] = true;
            if (keycode== Keys.DOWN) StatoTasti[down] = true;
            if (keycode == Keys.LEFT) StatoTasti[left] = true;
            if (keycode == Keys.RIGHT) StatoTasti[right] = true;
        }

        else if(stato==1){
            if (keycode == Keys.W) StatoTasti[up] = true;
            if (keycode == Keys.S) StatoTasti[down] = true;
            if (keycode == Keys.A) StatoTasti[left] = true;
            if (keycode == Keys.D) StatoTasti[right] = true;
        }
        return false;
    }
    @Override
    public boolean keyUp(int keycode) {
        if(stato==0) {
            if (keycode == Keys.N) StatoTasti[space] = true;
            if (keycode == Keys.UP) StatoTasti[up] = false;
            if (keycode == Keys.DOWN) StatoTasti[down] = false;
            if (keycode == Keys.LEFT) StatoTasti[left] = false;
            if (keycode == Keys.RIGHT) StatoTasti[right] = false;
        }
        else if(stato==1) {
            if (keycode == Keys.SHIFT_LEFT) StatoTasti[space] = true;
            if (keycode == Keys.W) StatoTasti[up] = false;
            if (keycode == Keys.S) StatoTasti[down] = false;
            if (keycode== Keys.A) StatoTasti[left] = false;
            if (keycode == Keys.D) StatoTasti[right] = false;
        }
        return false;

    }
    @Override
    public boolean keyTyped(char character) {
        return false;
    }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }
    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
