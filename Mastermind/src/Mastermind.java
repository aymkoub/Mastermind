import Controller.JeuController;
import Controller.MancheController;
import Model.Jeu;
import Model.Manche;
import View.JeuTextManageur;

import java.awt.*;

public class Mastermind {
    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        JeuController jeuController = new JeuController(jeu);
        JeuWindow window = new JeuWindow(jeu, jeuController);
        jeu.addJeuObserver(window);

        for(int i = 0; i < jeu.getNbManches(); i++)
        {
            // Création du modèle de la manche, du controller
            // Et génération de la combinaison secrète
            Manche manche = new Manche(jeu);
            MancheController mancheController = new MancheController(manche);

            mancheController.genererCombinaisonSecrete(manche);

            // Série de tentatives
            for (int k= manche.getNbTentativesRestantes(); k>0; k--){
                System.out.println("Il vous reste " + k + " tentatives.");

                Color[] tentative = new Color[jeu.getNbPionsCombi()];
                String[] tentext = new String[jeu.getNbPionsCombi()];

                // L'utilisateur choisit les couleurs de la tentative
                text.afficheCouleursText(jeu.getCouleursText());
                for (int j=0; j<jeu.getNbPionsCombi(); j++){
                    text.choisirCouleur(jeu.getCouleursPions(), tentative, tentext, j);
                }
                for (int m=0; m< tentext.length; m++){
                    System.out.print(tentext[m] + " - ");
                }
                System.out.println();

                //Vérification de la tentative et génération des indices si nécessaire
                if (mancheController.verifCombinaison(tentative)){
                    System.out.println("Combinaison trouvée ! Vous avez gagné la manche");
                }
                else{
                    mancheController.genererIndices(jeu.getContexte(), tentative);
                }
            }
        }
    }
}