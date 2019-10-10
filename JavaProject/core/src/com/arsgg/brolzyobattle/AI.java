package com.arsgg.brolzyobattle;

import com.arsgg.brolzyobattle.Pokemon.Mostro;

import java.util.Random;

public class AI{
    private int gap=30;
    private int spariDaFare;
    private int spariAttuali=0;
    public static int up=0;
    public static int down=1;
    public static int left=2;
    public static int right=3;
    private static int space=4;
    boolean[] statoTasti;
    private int ultimorand=0;
    private int timer=0;
    private int tempoprossimaazione=0;
    private Mostro me;
    private Mostro avversario;

    private Random r;

    AI() {

        statoTasti=new boolean[5];
        statoTasti[right]=true;
        r = new Random();

    }
    private void azzera(){
        for(int i=0;i<5;i++)
            statoTasti[i]=false;
    }
    void aggiorna(){
        if(ultimorand==10 && statoTasti[space]){statoTasti[space]=false;}
        else  if(ultimorand==10 && !statoTasti[space]){
            versoAvversario();
            statoTasti[space]=true;
            spariAttuali+=1;
            if(spariAttuali>=spariDaFare)
                    ultimorand=11;
        }

        if(completamenteFermo() && (r.nextInt(10)<4)) versoAvversario();


        if(timer>=tempoprossimaazione){
            timer=0;
            tempoprossimaazione=r.nextInt(40)+10;

            ultimorand=r.nextInt(26);

            if(ultimorand<=10)  ultimorand=10;
            if(ultimorand==10){versoAvversario(); spariDaFare=r.nextInt(3)+1; }

            else  if(ultimorand>=11 && ultimorand<=19) versoAvversario();
            else if(ultimorand>=20 && ultimorand<=25) cambiaDirezione();
            else {azzera(); tempoprossimaazione=r.nextInt(22);}

            if(Battle.p!=null) versoPozione();
            if(ultimorand!=10) spariAttuali=0;

        }


        if(controlloVicinanza());
        else
            evitareBordi();
        timer++;
    }
    void setGiocatori(){
        me=Battle.player2;
        avversario=Battle.player1;
    }
    private void versoAvversario(){

        azzera();

        if(me.getX()-avversario.getX()<-gap)
            statoTasti[right]=true;
        else if(me.getX()-avversario.getX()>gap)
            statoTasti[left]=true;

        if(me.getY()-avversario.getY()<-gap)
            statoTasti[up]=true;
        else if(me.getY()-avversario.getY()>gap)
            statoTasti[down]=true;
    }
    private void cambiaDirezione(){

       int qualecambiare=r.nextInt(3);
       if(qualecambiare==0){
           statoTasti[right]=!statoTasti[right];
           statoTasti[left]=!statoTasti[left];
       }

       if(qualecambiare==1){
           statoTasti[down]=!statoTasti[down];
           statoTasti[up]=!statoTasti[up];
       }

       if(qualecambiare==2){
           statoTasti[right]=!statoTasti[right];
           statoTasti[left]=!statoTasti[left];
           statoTasti[down]=!statoTasti[down];
           statoTasti[up]=!statoTasti[up];
       }


    }

    private boolean controlloVicinanza(){
        if(ultimorand>=11 && ultimorand<=19){
            int deltaX=me.getX()-avversario.getX();
            if(deltaX<0)
                deltaX=-deltaX;
            int deltaY=me.getY()-avversario.getY();
            if(deltaY<0)
                deltaY=-deltaY;

            if(deltaX<gap && deltaY<gap) {

                allontanati();
                return true;
            }
            }
        return false;

    }

    private void versoPozione(){
        int vado=r.nextInt(40);
        if(vado<25) {
            if(me.getX()-Battle.p.getX()<-gap)
                statoTasti[right]=true;
            else if(me.getX()-Battle.p.getX()>gap)
                statoTasti[left]=true;

            if(me.getY()-Battle.p.getY()<-gap)
                statoTasti[up]=true;
            else if(me.getY()-Battle.p.getY()>gap)
                statoTasti[down]=true;

        }
    }

    private boolean completamenteFermo(){
        for(int i=0;i<4;i++)
            if(statoTasti[i]) return  false;

        return true;
    }

    private void evitareBordi(){
        if(statoTasti[down] && me.getY()-20<=0 ){statoTasti[down]=false; statoTasti[up]=true;   }
        if(statoTasti[up] && me.getY()+20>=480){statoTasti[up]=false; statoTasti[down]=true;   }

        if(statoTasti[left] && me.getX()-20<=0 ){statoTasti[left]=false; statoTasti[right]=true;   }
        if(statoTasti[right] && me.getX()+20>=640){statoTasti[right]=false; statoTasti[left]=true;   }


    }

    private void allontanati(){

        if(me.getX()<avversario.getX())
        {
            statoTasti[left]=true;
            statoTasti[right]=false;
        }
        else
        {
            statoTasti[right]=true;
            statoTasti[left]=false;
        }

        if(me.getY()>avversario.getY())
        {
            statoTasti[up]=true;
            statoTasti[down]=false;
        }
        else 
        {
            statoTasti[down]=true;
            statoTasti[up]=false;
        }


    }

}
