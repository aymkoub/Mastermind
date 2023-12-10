package Model;

public class Jeu {
    private int nbManches = 3;
    private int nbPionsCombi = 4;
    private int nbPionsTotal = 8;
    private int nbTentatives = 10;
    private int score = 0;

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

    public void setScore(int score)
    {
        this.score += score;
    }
}
