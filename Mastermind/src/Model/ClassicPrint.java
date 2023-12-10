package Model;

import java.awt.*;

public class ClassicPrint implements JeuPrintStrategy{
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
        for(int j = 0; j<faux; j++){
            indice[j] = Color.black;
        }
        for (int k=faux;k<vrais;k++){
            indice[k] = Color.white;
        }

        for (Color color : indice
             ) {
            System.out.print(color);
        }
        System.out.println();
    }
}
