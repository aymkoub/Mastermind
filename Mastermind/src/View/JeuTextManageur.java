package View;

import Controller.JeuController;
import Model.Jeu;
import Model.Manche;

public class JeuTextManageur implements Model.MancheObserver{
    private Manche manche;
    private JeuController ctrl;
    public JeuTextManageur(Manche mc, JeuController jc)
    {
        this.manche = mc;
        this.ctrl = jc;
    }

    @Override
    public void Update() {

    }
}
