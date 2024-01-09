package View;

import Controller.JeuController;
import Model.Jeu;
import Model.Tentative;

import java.awt.*;
import java.util.Scanner;

public class JeuTextManageur implements Model.MancheObserver{
    private Jeu jeu;
    private JeuController ctrl;
    public JeuTextManageur(Jeu j, JeuController jc)
    {
        this.jeu = j;
        this.ctrl = jc;
    }

    public void afficheCouleursText(String[] couleursDispo){
        for (int i=0; i<couleursDispo.length; i++){
            System.out.println(i + " : " + couleursDispo[i]);
        }
    }
    public void choisirCouleur(Color[] couleursDispo, Tentative tentative, String[] tentaText, int index){
        System.out.println("Saisir le numéro de la couleur choisie :");
        Scanner sc = new Scanner(System.in);
        int point = sc.nextInt();
        Color choix = couleursDispo[point];
        tentative.getCombinaisonTentee()[index] = choix;
        tentaText[index] = jeu.getCouleursText()[point];

    }
    @Override
    public void Update() {

    }
}
