package Model;

import java.awt.*;
import java.util.ArrayList;

public class Jeu {
    private Color[] couleursPions = {Color.red, Color.pink, Color.yellow, Color.green, Color.orange, Color.blue,Color.magenta,Color.cyan};
    private int nbManches = 3;
    private int nbPionsCombi = 4;
    private int nbPionsTotal = 8;
    private int nbTentatives = 10;
    private int score = 0;
    private String modeJeu = "facile";

    private ArrayList<JeuObserver> jeuObservers = new ArrayList<>();

    public Color[] getCouleursPions() {
        return couleursPions;
    }
    public int getNbManches() {
        return nbManches;
    }
    public int getNbPionsCombi() {
        return nbPionsCombi;
    }
    public int getNbPionsTotal() {
        return nbPionsTotal;
    }
    public int getNbTentatives() {
        return nbTentatives;
    }
    public int getScore() {
        return score;
    }
    public String getModeJeu() {return modeJeu;}
    public void setNbManches(int nbManches) {
        this.nbManches = nbManches;
    }

    public void setNbPionsCombi(int nbPionsCombi) {
        this.nbPionsCombi = nbPionsCombi;
    }

    public void setNbPionsTotal(int nbPionsTotal) {
        this.nbPionsTotal = nbPionsTotal;
    }

    public void setNbTentatives(int nbTentatives) {
        this.nbTentatives = nbTentatives;
    }
    public void setScore(int score){this.score += score;}
    public void setModeJeu(String md){modeJeu = md;}

    public void addJeuObserver(JeuObserver obs){
        jeuObservers.add(obs);
    }

    public void notifyJeuObserver() {
        for (JeuObserver obs : jeuObservers) {
            obs.Update();
        }
    }
}
