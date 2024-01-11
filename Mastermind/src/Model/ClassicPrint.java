package Model;

import java.util.Arrays;
import java.awt.*;

public class ClassicPrint implements JeuPrintStrategy{
    @Override
    public void genererIndices(Manche manche, Tentative tentative){
        Color[] combi = manche.getCombinaisonSecrete();
        Color[] indice = new Color[combi.length];

        int vrais = 0;
        int faux = 0;
        int abs = 0;
        for(int i=0; i<combi.length; i++){
            if (!Arrays.asList(combi).contains(tentative.getCombinaisonTentee()[i])){
                abs++;
            }
            else if (combi[i] == tentative.getCombinaisonTentee()[i]){
                vrais++;
            }
            else{
                faux++;
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
        for (Color color : tentative.getIndicesTentative()
             ) {
            if (color==Color.black){
                System.out.print("Noir - ");
            } else if (color==Color.white) {
                System.out.print("Blanc - ");
            }
            else {
                System.out.print("Rouge - ");
            }
        }
        System.out.println();
    }
}
