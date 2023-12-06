package Model;

import java.awt.*;
import java.util.ArrayList;

public class Manche {
    private final Color[] combinaisonSecrete = new Color[4];
    private int nbTentativesRestantes;
    private int score;

    private ArrayList<MancheObserver> mancheObservers = new ArrayList<>();

    public Color[] getCombinaisonSecrete() {
        return combinaisonSecrete;
    }

    public void setCombinaisonSecrete(Color[] combinaison) {
        for (int i = 0; i< combinaison.length; i++){
            this.combinaisonSecrete[i] = combinaison[i];
        }
    }

    public int getNbTentativesRestantes() {
        return nbTentativesRestantes;
    }

    public void addObserver(MancheObserver obs){
        mancheObservers.add(obs);
    }

    public void notifyObserver(){
        for (MancheObserver obs : mancheObservers) {
            obs.Update();
        }
    }
}
