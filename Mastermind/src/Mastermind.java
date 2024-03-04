import Controller.JeuController;
import Controller.MancheController;
import Model.Jeu;
import Model.Manche;
import Model.Tentative;
import View.JeuTextManageur;
import View.JeuWindow;

import java.awt.*;

public class Mastermind {
    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        JeuController jeuController = new JeuController(jeu);
        JeuWindow window = new JeuWindow(jeu, jeuController);
    }
}