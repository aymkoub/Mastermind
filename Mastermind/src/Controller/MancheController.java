package Controller;

import Model.ClassicPrint;
import Model.JeuPrintStrategy;
import Model.Manche;
import Model.Tentative;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class MancheController {
    private Manche manche;
    public MancheController(Manche manche1)
    {
        this.manche = manche1;
    }
    public void genererCombinaisonSecrete(Manche manche){
        Color[] couleursPions = {Color.red, Color.pink, Color.yellow, Color.green, Color.orange, Color.blue,Color.magenta,Color.cyan};
        Color[] combinaison = new Color[manche.getPartie().getNbPionsCombi()];
        Random rand = new Random();
        for (int i=0; i< combinaison.length;i++){
            combinaison[i] = couleursPions[rand.nextInt(0,couleursPions.length)];
        }
        manche.setCombinaisonSecrete(combinaison);
    }

    public boolean verifCombinaison(Tentative tentative)
    {
        boolean test = true;
        Color[] combi = manche.getCombinaisonSecrete();
        for(int i = 0; test && i < combi.length; i++)
        {
            if(tentative.getCombinaisonTentee()[i] != combi[i])
            {
                test = false;
            }
        }
        return test;
    }

    public void genererIndices(JeuPrintStrategy contexte, Tentative tentative){
        contexte.genererIndices(this.manche, tentative);
        contexte.affichIndices(tentative);
    }


    public void calculerScoreManche(Tentative tentative)
    {
        int score = (tentative.getNbVrais()*3 + tentative.getNbAbs());


        // si on est en mode classique, on ajoute 4 points au score
        if (this.manche.getPartie().getContexte() instanceof ClassicPrint){
            score += 4;
        }

        this.manche.setScore(score);
    }
}
