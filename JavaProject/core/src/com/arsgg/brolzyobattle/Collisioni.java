package com.arsgg.brolzyobattle;


import com.arsgg.brolzyobattle.Mosse.Proiettile;
import com.arsgg.brolzyobattle.Pokemon.Mostro;

import java.util.ArrayList;
import java.util.Random;

class Collisioni {
    private ArrayList<Proiettile> proiettili1;
    private ArrayList<Proiettile> proiettili2;
    private Mostro player1;
    private Mostro player2;
    Collisioni(Battle battle) {
        this.player1 = Battle.player1;
        this.player2 = Battle.player2;
        this.proiettili1 = battle.proiettili1;
        this.proiettili2 = battle.proiettili2;

    }
    void controlliCollisioni() {
        for(int i=0;i<proiettili1.size();i++) {
            if(proiettili1.get(i).getDisegno().getX()<-80 ||proiettili1.get(i).getDisegno().getX()>750
                ||proiettili1.get(i).getDisegno().getY()<-80||proiettili1.get(i).getDisegno().getY()>650)
            {
                proiettili1.remove(i);
                i--;
            }


            if(i>=0)
            if (proiettili1.get(i).rettangolo.overlaps(player2.rettangolo)) {
                proiettili1.remove(i);
                i--;
                Battle.player2.setHp(Battle.player2.getHp() - Battle.player1.getForza());
                Battle.rand = new Random();
                if (Battle.rand.nextInt(8) == 2 && Battle.p == null)
                    Battle.p = new Item();
            }

        }

        for(int i=0;i<proiettili2.size();i++) {
            if(proiettili2.get(i).getDisegno().getX()<-80 ||proiettili2.get(i).getDisegno().getX()>750
                    ||proiettili2.get(i).getDisegno().getY()<-80||proiettili2.get(i).getDisegno().getY()>650)
            {
                proiettili2.remove(i);
                i--;
            }
            if(i>=0)
            if (proiettili2.get(i).rettangolo.overlaps(player1.rettangolo)) {
                proiettili2.remove(i);
                i--;
                Battle.player1.setHp(Battle.player1.getHp() - Battle.player2.getForza());
                Battle.rand = new Random();
                if (Battle.rand.nextInt(8) == 2 && Battle.p == null)
                    Battle.p = new Item();
            }
        }

    }
    void potionCollisioni(){
        if(Battle.p==null)
            return;
        if(Battle.p.rettangolo.overlaps(player1.rettangolo)){
            Battle.p.upgradeMostro(player1);  Battle.p=null;}
        else if(Battle.p.rettangolo.overlaps(player2.rettangolo)){
            Battle.p.upgradeMostro(player2);  Battle.p=null;}

    }

}