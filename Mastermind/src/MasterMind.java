import Controller.JeuController;
import View.JeuTextManageur;
import View.JeuWindow;
import Model.Jeu;
public class MasterMind {
    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        JeuController jeuController = new JeuController(jeu);
        JeuWindow window = new JeuWindow(jeu, jeuController);
        JeuTextManageur text = new JeuTextManageur();


    }
}
