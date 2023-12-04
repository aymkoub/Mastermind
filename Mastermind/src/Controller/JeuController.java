package Controller;

import Model.Jeu;

import java.awt.*;
import java.util.Random;

public class JeuController {
    public void genererCombinaisonSecrete(Jeu jeu){
        Color[] couleursPions = {Color.red, Color.pink, Color.yellow, Color.green, Color.orange, Color.blue,Color.magenta,Color.cyan};
        Color[] combinaison = new Color[4];
        Random rand = new Random();
        for (int i=0; i<4;i++){
            combinaison[i] = couleursPions[rand.nextInt(couleursPions.length)];
        }
        jeu.setCombinaisonSecrete(combinaison);
    }

}
