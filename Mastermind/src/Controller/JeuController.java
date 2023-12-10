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
}
