import Controller.JeuController;
import Model.Manche;
import View.JeuTextManageur;
import View.JeuWindow;
import Model.Jeu;
public class MasterMind {
    public static void main(String[] args) {
        Manche jeu = new Manche();
        JeuController jeuController = new JeuController(jeu);
        JeuWindow window = new JeuWindow(jeu, jeuController);
        JeuTextManageur text = new JeuTextManageur(jeu, jeuController);


    }
}
