package Model;

import java.awt.*;

public interface JeuPrintStrategy {
    public void genererIndices(Manche manche, Tentative tentative);
    public void affichIndices(Tentative tentative);
}
