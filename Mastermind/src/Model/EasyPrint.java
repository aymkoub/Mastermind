package Model;

import java.awt.*;

public class EasyPrint implements JeuPrintStrategy{
    @Override
    public void affichIndices(Manche manche, Color[] tentative) {
        Color[] combi = manche.getCombinaisonSecrete();
        Color[] indice = new Color[combi.length];

        for(int i=0; i<combi.length; i++){
            if (combi[i] == tentative[i]){
                indice[i] = Color.black;
            }
            else{
                indice[i] = Color.white;
            }
        }

        for (Color color : indice
        ) {
            System.out.print(color);
        }
        System.out.println();
    }
}
