package com.arsgg.brolzyobattle;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {

	private SpriteBatch batch;
	private float time;
	private Menu menu;
	private Multiplayer multiplayer;
	private Battle battle;
	private Winner winner;
	private Map map;
	private Credit credit;
	static  int nMap=1;
	public static int width=640;
	public static int height=480;
	static boolean isMenuMulti=true;
	static boolean isMenu=false;
	static boolean isCredit=false;
	static boolean isMap=false;
	static boolean isBattle=false;
	static boolean isSingleplayer=false;
	static boolean isMusic=false;
	static boolean isAmpharosP1=false;
	static boolean isAmpharosP2=false;
	static boolean isMewtwoP1=false;
	static boolean isMewtwoP2=false;
	static boolean isChariP1=false;
	static boolean isChariP2=false;
	static boolean isGengarP1=false;
	static boolean isGengarP2=false;
	static boolean isWinnerP1=false;
	static boolean isWinnerP2=false;

	@Override
	public void create () {
		menu=null;
		battle=null;
		map=null;
		batch = new SpriteBatch();
		multiplayer=new Multiplayer();
		multiplayer.inizialize();
		winner=null;
		credit= new Credit();
		credit.inizialize();
	}

	@Override
	public void render () {
		time += Gdx.graphics.getDeltaTime();
		if(!isBattle&&battle!=null){battle.dispose();battle=null;}
		if(!isMenu&&menu!=null){menu.remove();menu=null;}
		if(!isMap&&map!=null){map.remove();map=null;}
		if((!isWinnerP2&&!isWinnerP1)&&winner!=null){winner.dispose();winner=null;}

		if(isCredit){credit.draw(batch);}
		else if(isMenuMulti){multiplayer.draw(batch,time);}
		else if(isMenu){if(menu==null){	menu = new Menu();} menu.draw(batch,time);}
		else if(isMap){if(map==null){ map = new Map();} map.draw(batch,time);}
		else if(isBattle){
			if(battle==null)
			{ battle= new Battle(); }
			battle.music();
			battle.draw(batch,time);}
		else if(isWinnerP1||isWinnerP2){
				if(winner==null){winner=new Winner();}winner.draw(batch);
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		credit.dispose();
		if(battle!=null)battle.dispose();
		if(menu!=null)menu.remove();
		if(map!=null)map.remove();
		if(winner!=null)winner.dispose();
		multiplayer.remove();
	}

}

