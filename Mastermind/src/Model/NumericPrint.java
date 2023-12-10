package Model;

import java.awt.*;

public class NumericPrint implements JeuPrintStrategy{
    @Override
    public void affichIndices(Manche manche, Color[] tentative) {
        Color[] combi = manche.getCombinaisonSecrete();
        Color[] indice = new Color[combi.length];
        int vrais = 0;
        int faux = 0;

        for(int i=0; i<combi.length; i++){
            if (combi[i] == tentative[i]){
                vrais++;
            }
            else{
                faux++;
            }
        }

        System.out.println("Vous avez " + vrais + "pions bien placés et " + faux + "pions mal placés");
    }
}
