package Model;

import java.awt.*;
import java.util.ArrayList;


public class Manche {
    private Jeu partie;
    private final Color[] combinaisonSecrete = new Color[4];
    private int nbTentativesRestantes;
    private int score;

    private ArrayList<MancheObserver> mancheObservers = new ArrayList<>();

    public Manche(Jeu partie){
        this.partie = partie;
        nbTentativesRestantes = partie.getNbTentatives();
    }

    public Jeu getPartie() {
        return this.partie;
    }

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

    public void setNbTentativesRestantes(int nbTentativesRestantes) {
        this.nbTentativesRestantes = nbTentativesRestantes;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
