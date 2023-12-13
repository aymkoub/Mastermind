package Controller;


import Model.Jeu;
import Model.Manche;

import java.awt.*;
import java.util.Random;

public class JeuController {
    private Jeu jeu;

    public JeuController(Jeu jeu1)
    {
        this.jeu = jeu1;
    }

    public void run()
    {
        for(int i = 0; i < jeu.getNbManches(); i++)
        {
            Manche manche = new Manche(this.jeu);
            MancheController mancheController = new MancheController(manche);
        }
    }

    public void setNbManches(int nbManches) {
        this.jeu.setNbManches( nbManches);
    }

    public void setNbPionsCombi(int nbPionsCombi) {
        this.jeu.setNbPionsCombi(nbPionsCombi);
    }

    public void setNbPionsTotal(int nbPionsTotal) {
        this.jeu.setNbPionsTotal( nbPionsTotal);
    }

    public void setNbTentatives(int nbTentatives) {
        this.jeu.setNbTentatives(nbTentatives);
    }

    public void setModeJeu(String md){this.jeu.setModeJeu( md);}
}
