package View;

import Controller.JeuController;
import Model.Jeu;
import Model.JeuObserver;
import Model.Manche;

import javax.swing.*;

public class JeuWindow extends JFrame implements Model.JeuObserver  {
    private Manche jeu;
    private JeuController controller;
    public JeuWindow(Manche jeu1, JeuController ctrl)
    {
        this.jeu = jeu1;
        this.controller = ctrl;
    }

    @Override
    public void Update() {

    }
}
