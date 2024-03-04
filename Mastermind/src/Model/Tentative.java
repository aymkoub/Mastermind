package Model;

import java.awt.*;

public class Tentative {
    private Manche manche;
    private Color[] combinaisonTentee = new Color[4];
    private Color[] indicesTentative = new Color[4];
    private int nbAbs = 0;
    private int nbFaux = 0;
    private int nbVrais = 0;

    public Tentative(Manche manche){
        this.manche = manche;
    }

    public Manche getManche() {
        return manche;
    }

    public Color[] getCombinaisonTentee() {
        return combinaisonTentee;
    }

    public Color[] getIndicesTentative() {
        return indicesTentative;
    }

    public int getNbAbs() {
        return nbAbs;
    }

    public int getNbFaux() {
        return nbFaux;
    }

    public int getNbVrais() {
        return nbVrais;
    }

    public void setCombinaisonTentee(Color[] combinaisonTentee) {
        this.combinaisonTentee = combinaisonTentee;
    }

    public void setIndicesTentative(Color[] indicesTentative) {
        this.indicesTentative = indicesTentative;
    }

    public void setNbAbs(int nbAbs) {
        this.nbAbs = nbAbs;
    }

    public void setNbFaux(int nbFaux) {
        this.nbFaux = nbFaux;
    }

    public void setNbVrais(int nbVrais) {
        this.nbVrais = nbVrais;
    }
}
