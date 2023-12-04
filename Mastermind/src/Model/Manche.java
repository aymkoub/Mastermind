package Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Manche {
    private int tentativeRestant;
    private Color[] combinaison;
    private Color[][] tentative;
    private List<JeuObserver> observers;
    public Manche()
    {
        this.tentativeRestant = 10;
        this.observers = new ArrayList<>();
    }

    public Color[] getCombinaisonSecrete()
    {
        return this.combinaison;
    }

    public void setCombinaisonSecrete(Color[] combi)
    {
        this.combinaison = combi;
    }

    public int getTentativeRestant()
    {
        return this.tentativeRestant;
    }

    public Color[][] getTentative()
    {
        return this.tentative;
    }

    public void addObserver(JeuObserver obs)
    {
        this.observers.add(obs);
    }   

    protected void notifyObserver() {
        for ( JeuObserver observer : observers ) {
            observer.Update();
        }
    }

    public void NextTentative()
    {

    }

}
