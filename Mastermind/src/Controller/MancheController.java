package Controller;

import Model.Manche;

import java.awt.*;
import java.util.Random;

public class MancheController {
    private Manche manche;
    public MancheController(Manche manche1)
    {
        this.manche = manche1;
    }
    public void genererCombinaisonSecrete(Manche manche){
        Color[] couleursPions = {Color.red, Color.pink, Color.yellow, Color.green, Color.orange, Color.blue,Color.magenta,Color.cyan};
        Color[] combinaison = new Color[4];
        Random rand = new Random();
        for (int i=0; i<4;i++){
            combinaison[i] = couleursPions[rand.nextInt(couleursPions.length)];
        }
        manche.setCombinaisonSecrete(combinaison);
    }

    public boolean verifCombinaison(Color[] tentative)
    {
        boolean test = true;
        Color[] combi = manche.getCombinaisonSecrete();
        for(int i = 0; i < tentative.length; i++)
        {
            if(tentative[i] != combi[i])
            {
                test = false;
            }
        }
        return test;
    }

    public int calculScoreManche()
    {
        int score = 0;
        return score;
    }
}
