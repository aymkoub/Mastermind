package View;

import Controller.JeuController;
import Model.Jeu;


import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class JeuWindow extends JFrame implements Model.JeuObserver  {
    private final Jeu jeu;
    private final JeuController controller;
    public JeuWindow(Jeu jeu1, JeuController ctrl)
    {
        this.jeu = jeu1;
        this.controller = ctrl;

        setTitle("Mastermind");
        setSize(450, 1000);
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        Menu();
        setVisible(true);
    }

    public void Menu()
    {
        this.getContentPane().removeAll();
        this.validate();
        this.repaint();
        setSize(450, 1000);
        JButton start = new JButton("start");
        start.addActionListener( actionEvent -> controller.run());
        start.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton option = new JButton("Option");
        option.addActionListener(actionEvent -> Option());
        option.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton quitter = new JButton("Quitter le Jeu");
        quitter.addActionListener(actionEvent -> this.dispose());
        quitter.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panel = new JPanel();
        panel.setLayout( new BoxLayout(panel,BoxLayout.Y_AXIS) );
        panel.add(start);
        panel.add(option);
        panel.add(quitter);
        setContentPane(panel);
    }

    public void Option()
    {
        setSize(700,700);
        this.getContentPane().removeAll();
        this.validate();
        this.repaint();

        JLabel nbMan = new JLabel("Nombre de manche");
        String[] nbManche = {"3", "4", "5"};
        JComboBox nbMancheCB = new JComboBox(nbManche);
        nbMancheCB.setSelectedIndex(0);

        JLabel nbPion = new JLabel("Nombre de pions disponibles ");
        String[] nbPionsDispo = {"4","5","6","7","8"};
        JComboBox nbPionsDispoCB = new JComboBox(nbPionsDispo);
        nbPionsDispoCB.setSelectedIndex(4);

        JLabel nbPionsCombi = new JLabel("Nombre de pions d'une combinaison");
        String[] nbPionsCombiList = {"4","5","6"};
        JComboBox nbPionsCombiCB = new JComboBox(nbPionsCombiList);
        nbPionsCombiCB.setSelectedIndex(0);

        JLabel nbTentative = new JLabel("Nombre de tentatives");
        String[] nbTentativeList = {"10","11","12"};
        JComboBox nbTentativeCB = new JComboBox(nbTentativeList);
        nbTentativeCB.setSelectedIndex(0);

        JLabel mdAffichage = new JLabel("Mode d'affichage des indices");
        String[] mdAffichageList = {"facile","classique","numérique"};
        JComboBox mdAffichageCB = new JComboBox(mdAffichageList);
        mdAffichageCB.setSelectedIndex(0);

        JLabel bouton = new JLabel();

        JButton enregister = new JButton("Enregistrer");
        enregister.addActionListener(actionEvent -> {
            jeu.setNbManches(Integer.parseInt((String) Objects.requireNonNull(nbMancheCB.getSelectedItem())));
            jeu.setNbPionsTotal(Integer.parseInt((String) Objects.requireNonNull(nbPionsDispoCB.getSelectedItem())));
            jeu.setNbPionsCombi(Integer.parseInt((String) Objects.requireNonNull(nbPionsCombiCB.getSelectedItem())));
            jeu.setNbTentatives(Integer.parseInt((String) Objects.requireNonNull(nbTentativeCB.getSelectedItem())));
            jeu.setModeJeu((String)Objects.requireNonNull( mdAffichageCB.getSelectedItem()));
            Menu();
        });
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,2));
        panel.add(nbMan);
        panel.add(nbMancheCB);
        panel.add(nbPion);
        panel.add(nbPionsDispoCB);
        panel.add(nbPionsCombi);
        panel.add(nbPionsCombiCB);
        panel.add(nbTentative);
        panel.add(nbTentativeCB);
        panel.add(mdAffichage);
        panel.add(mdAffichageCB);
        panel.add(bouton);
        panel.add(enregister);
        setContentPane(panel);
        setVisible(true);
    }

    @Override
    public void Update() {

    }
}
