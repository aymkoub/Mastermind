package Model;

import java.awt.*;
import java.util.ArrayList;

public class Jeu {
    private Color[] couleursPions = {Color.red, Color.pink, Color.yellow, Color.green, Color.orange, Color.blue,Color.magenta,Color.cyan};
    private String[] couleursText = {"Rouge","Rose","Jaune","Vert","Orange","Bleu","Violet","Cyan"};
    private int nbManches = 3;
    private int nbPionsCombi = 4;
    private int nbPionsTotal = 8;
    private int nbTentatives = 10;
    private int score = 0;

    private JeuPrintStrategy contexte = new ClassicPrint();
    private ArrayList<JeuObserver> jeuObservers = new ArrayList<>();

    public JeuPrintStrategy getContexte() {
        return contexte;
    }
    public Color[] getCouleursPions() {
        return couleursPions;
    }
    public String[] getCouleursText(){
        return this.couleursText;
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

    public void setContexte(JeuPrintStrategy contexte) {
        this.contexte = contexte;
    }
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

    public void addJeuObserver(JeuObserver obs){
        jeuObservers.add(obs);
    }

    public void notifyJeuObserver() {
        for (JeuObserver obs : jeuObservers) {
            obs.Update();
        }
    }
}
