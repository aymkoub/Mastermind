package Model;

import java.awt.*;
import java.util.Arrays;

public class NumericPrint implements JeuPrintStrategy{

    @Override
    public void genererIndices(Manche manche, Tentative tentative) {
        Color[] combi = manche.getCombinaisonSecrete();
        Color[] indice = new Color[3];
        int vrais = 0;
        int faux = 0;
        int abs = 0;

        for(int i=0; i<combi.length; i++){
            if (combi[i] == tentative.getCombinaisonTentee()[i]){
                vrais++;
            }
            else if (Arrays.asList(combi).contains(tentative.getCombinaisonTentee()[i])){
                faux++;
            }
            else{
                abs++;
            }
        }
        for(int j = 0; j<vrais; j++){
            indice[j] = Color.black;
        }
        for (int k=vrais;k<faux+vrais;k++){
            indice[k] = Color.white;
        }
        for (int m=vrais+faux; m<faux+vrais+abs;m++){
            indice[m] = Color.red;
        }
        tentative.setNbAbs(abs);
        tentative.setNbFaux(faux);
        tentative.setNbVrais(vrais);
        tentative.setIndicesTentative(indice);
    }

    @Override
    public void affichIndices(Tentative tentative) {
        int vrais = tentative.getNbVrais();
        int faux = tentative.getNbFaux();
        int abs = tentative.getNbAbs();
        System.out.println("Vous avez " + vrais + "pions bien placés, " + faux + " pions mal placés " + abs + " pions absents !");
    }
}
