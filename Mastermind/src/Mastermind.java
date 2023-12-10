import Controller.JeuController;
import Model.Jeu;
import View.JeuTextManageur;
import View.JeuWindow;

public class Mastermind {
    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        JeuController jeuController = new JeuController(jeu);
        JeuWindow window = new JeuWindow(jeu, jeuController);
        JeuTextManageur text = new JeuTextManageur(jeu, jeuController);
    }
}