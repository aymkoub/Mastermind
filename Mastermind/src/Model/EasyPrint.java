package Model;

import java.awt.*;
import java.util.Arrays;

public class EasyPrint implements JeuPrintStrategy{

    @Override
    public void genererIndices(Manche manche, Tentative tentative){
        Color[] combi = manche.getCombinaisonSecrete();
        Color[] indice = new Color[combi.length];
        int vrais = 0;
        int faux = 0;
        int abs = 0;
        for(int i=0; i<combi.length; i++){
            if (combi[i] == tentative.getCombinaisonTentee()[i]){
                indice[i] = Color.black;
                vrais++;
            }
            else if (Arrays.asList(combi).contains(tentative.getCombinaisonTentee()[i])){
                indice[i] = Color.white;
                faux++;
            }
            else {
                indice[i] = Color.red;
                abs++;
            }
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
                System.out.println("Blanc - ");
            }
            else {
                System.out.println("Rouge - ");
            }
        }
        System.out.println();
    }
}
