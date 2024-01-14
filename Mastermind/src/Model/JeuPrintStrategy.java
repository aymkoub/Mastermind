package Model;

import java.awt.*;

public interface JeuPrintStrategy {
    public void genererIndices(Manche manche, Tentative tentative);

    //Utiliser seulement pour la partie textuelle du Mastermind
    public void affichIndices(Tentative tentative);
}
