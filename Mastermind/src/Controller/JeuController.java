package Controller;

import Model.Jeu;
import Model.Manche;

import java.awt.*;
import java.util.Random;

public class JeuController {
    private Manche jeu;
    public JeuController(Manche jeu1)
    {
        this.jeu = jeu1;
    }
    public void genererCombinaisonSecrete(Manche jeu){
        Color[] couleursPions = {Color.red, Color.pink, Color.yellow, Color.green, Color.orange, Color.blue,Color.magenta,Color.cyan};
        Color[] combinaison = new Color[4];
        Random rand = new Random();
        for (int i=0; i<4;i++){
            combinaison[i] = couleursPions[rand.nextInt(couleursPions.length)];
        }
        jeu.setCombinaisonSecrete(combinaison);
    }

    public boolean verifCombinaison(Color[] tentative)
    {
        boolean test = true;
        Color[] combi = jeu.getCombinaisonSecrete();
        for(int i = 0; i < tentative.length; i++)
        {
            if(tentative[i] != combi[i])
            {
                test = false;
            }
        }
        return test;
    }

    public void run()
    {
        Color[] tentative = new Color[4];
        while(!verifCombinaison(tentative) || jeu.getTentativeRestant() > 0)
        {
            
        }
    }
}
