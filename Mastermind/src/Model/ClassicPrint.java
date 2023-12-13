package Model;

import java.util.Arrays;
import java.awt.*;

public class ClassicPrint implements JeuPrintStrategy{
    @Override
    public void affichIndices(Manche manche, Color[] tentative) {
        Color[] combi = manche.getCombinaisonSecrete();
        String[] indice = new String[combi.length];
        int vrais = 0;
        int faux = 0;
        int abs = 0;
        for(int i=0; i<combi.length; i++){
            if (Arrays.asList(combi).contains(tentative[i])){
                abs++;
            }
            else if (combi[i] == tentative[i]){
                vrais++;
            }
            else{
                faux++;
            }
        }
        for(int j = 0; j<faux; j++){
            indice[j] = "Blanc";
        }
        for (int k=faux;k<faux+vrais;k++){
            indice[k] = "Noir";
        }

        for (String color : indice
             ) {
            System.out.print(color+" - ");
        }
        System.out.println();
    }
}
