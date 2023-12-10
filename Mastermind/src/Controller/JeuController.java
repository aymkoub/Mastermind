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
        for(int i = 0; i < 4; i++)
        {
            Manche manche = new Manche();
            MancheController mancheController = new MancheController(manche);
        }
    }
}
