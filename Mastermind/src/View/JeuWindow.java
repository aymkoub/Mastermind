package View;

import Controller.JeuController;
import Controller.MancheController;
import Model.*;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Objects;

public class JeuWindow extends JFrame implements Model.JeuObserver  {
    private Jeu jeu;
    private final JeuController controller;
    public Color couleurTemp;
    private int nbTentativeEffectuer = 0;
    private int nbMancheJouer = 0;
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
        // Placement des boutons sur l'interface graphique

        this.getContentPane().removeAll();
        this.validate();
        this.repaint();
        setSize(600, 600);

        // Bouton Start qui appelle la méthode game() une fois cliqué
        JButton start = new JButton("Start");
        start.addActionListener( actionEvent -> game());
        start.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Bouton Option qui appelle la méthode option() une fois cliqué
        JButton option = new JButton("Options");
        option.addActionListener(actionEvent -> Option());
        option.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Bouton Quitter qui ferme la fenêtre une fois cliqué
        JButton quitter = new JButton("Quitter le Jeu");
        quitter.addActionListener(actionEvent -> System.exit(0));
        quitter.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel mastermind = new JLabel("MASTERMIND");
        JPanel panel = new JPanel();
        panel.setLayout( new GridBagLayout() );
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(mastermind, constraints);
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        panel.add(start, constraints);
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        panel.add(option, constraints);
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        panel.add(quitter, constraints);
        setContentPane(panel);
    }

    public void Option()
    {
        // Ouvre la fenêtre des options de la partie

        setSize(700,700);
        this.getContentPane().removeAll();
        this.validate();
        this.repaint();

        JLabel nbMan = new JLabel("Nombre de manches");
        String[] nbManche = {"1","2","3", "4", "5"};
        JComboBox nbMancheCB = new JComboBox(nbManche);
        nbMancheCB.setSelectedIndex(2);

        JLabel nbPion = new JLabel("Nombre de pions disponibles ");
        String[] nbPionsDispo = {"4","5","6","7","8"};
        JComboBox nbPionsDispoCB = new JComboBox(nbPionsDispo);
        nbPionsDispoCB.setSelectedIndex(4);

        JLabel nbPionsCombi = new JLabel("Nombre de pions d'une combinaison");
        String[] nbPionsCombiList = {"2","3","4","5","6"};
        JComboBox nbPionsCombiCB = new JComboBox(nbPionsCombiList);
        nbPionsCombiCB.setSelectedIndex(2);

        JLabel nbTentative = new JLabel("Nombre de tentatives");
        String[] nbTentativeList = {"2","3","4","5","6","7","8","9","10","11","12"};
        JComboBox nbTentativeCB = new JComboBox(nbTentativeList);
        nbTentativeCB.setSelectedIndex(8);

        JLabel mdAffichage = new JLabel("Mode d'affichage des indices");
        String[] mdAffichageList = {"Classique", "Facile", "Numérique"};
        JComboBox mdAffichageCB = new JComboBox(mdAffichageList);
        mdAffichageCB.setSelectedIndex(0);

        JLabel bouton = new JLabel();

        JButton enregister = new JButton("Enregistrer");
        enregister.addActionListener(actionEvent -> {
            controller.setNbManches(Integer.parseInt((String) Objects.requireNonNull(nbMancheCB.getSelectedItem())));
            controller.setNbPionsTotal(Integer.parseInt((String) Objects.requireNonNull(nbPionsDispoCB.getSelectedItem())));
            controller.setNbPionsCombi(Integer.parseInt((String) Objects.requireNonNull(nbPionsCombiCB.getSelectedItem())));
            controller.setNbTentatives(Integer.parseInt((String) Objects.requireNonNull(nbTentativeCB.getSelectedItem())));
            controller.setModeJeu((String)Objects.requireNonNull( mdAffichageCB.getSelectedItem()));
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
    private Manche manche;
    private MancheController mancheController;
    public void game()
    {
        //Lance la partie

        this.manche = new Manche(jeu);
        this.nbMancheJouer++;
        this.mancheController = new MancheController(manche);
        this.mancheController.genererCombinaisonSecrete(manche);
        couleurTemp = Color.white;
        Color[] couleur = jeu.getCouleursPions();

        this.getContentPane().removeAll();
        this.validate();
        this.repaint();
        setSize(600, 1000);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));
        for(int i = 0; i < jeu.getNbTentatives(); i++)
        {
            JPanel panel2 = new JPanel();
            panel2.setLayout(new FlowLayout());

            for(int j = 0; j < jeu.getNbPionsCombi(); j++)
            {
                JLabel boul = new JLabel();
                boul.setPreferredSize(new Dimension(50, 50));
                boul.setBackground(Color.white);
                Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
                boul.setBorder(border);
                boul.setCursor(new Cursor(Cursor.HAND_CURSOR));
                int finalI = i;
                boul.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(nbTentativeEffectuer+1 == jeu.getNbTentatives()-finalI) {
                            boul.setBackground(couleurTemp);
                            boul.setOpaque(true);
                        }
                    }
                });
                panel2.add(boul);

            }
            if(jeu.getModeJeu().equals("Classique") || jeu.getModeJeu().equals("Facile")) {
                for (int k = 0; k < jeu.getNbPionsCombi(); k++) {
                    JLabel indice = new JLabel();
                    indice.setPreferredSize(new Dimension(25, 25));
                    indice.setBackground(Color.white);
                    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
                    indice.setBorder(border);
                    panel2.add(indice);
                }
            }
            else
            {
                JLabel indice = new JLabel("0");
                indice.setPreferredSize(new Dimension(25,25));
                panel2.add(indice);
                JLabel indice2 = new JLabel("0");
                indice2.setPreferredSize(new Dimension(25,25));
                panel2.add(indice2);
            }
            panel.add(panel2);
            //panel1.add(panel2);


        }
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        for(int m = 0; m < jeu.getNbPionsTotal(); m++)
        {
            JLabel boul = new JLabel();
            boul.setPreferredSize(new Dimension(50, 50));
            boul.setOpaque(true);
            boul.setBackground(couleur[m]);
            Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
            boul.setBorder(border);
            boul.setCursor(new Cursor(Cursor.HAND_CURSOR));
            boul.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    couleurTemp = boul.getBackground();
                }
            });
            panel2.add(boul);
        }
        panel.add(panel2);
        JButton btn = new JButton("Valider Tentative");
        btn.addActionListener( actionEvent -> ValiderTentative(panel));

        JButton btnStop = new JButton("Arreter la manche");
        btnStop.addActionListener(actionEvent -> StopManche());

        panel.add(btn);
        panel.add(btnStop);
        setContentPane(panel);
        setVisible(true);


    }

    public void ValiderTentative(Container Mainpanel)  {

        this.nbTentativeEffectuer++;
        int index = jeu.getNbTentatives() - this.nbTentativeEffectuer;
        Component[] components = Mainpanel.getComponents();
        JPanel panelTentative;
        if (index >= 0 && index < components.length && components[index] instanceof JPanel) {
            panelTentative =  (JPanel) components[index];
        }
        else
        {
            panelTentative = new JPanel();
        }
        //on récupère les labels (boules) du panel de la tentative
        ArrayList<JLabel> labelList = new ArrayList<>();
        Component[] components2 = panelTentative.getComponents();
        for(int i = 0; i < jeu.getNbPionsCombi(); i++)
        {
            Component cpn = components2[i];
            if(cpn instanceof JLabel)
            {

                labelList.add((JLabel) cpn);
            }
        }
        Tentative ttt = new Tentative(manche);
        Color[] combiTente = new Color[jeu.getNbPionsCombi()];
        for(int j = 0; j < labelList.size(); j++)
        {
            combiTente[j] = labelList.get(j).getBackground();

        }

        ttt.setCombinaisonTentee(combiTente);
        if(mancheController.verifCombinaison(ttt) || nbTentativeEffectuer >= jeu.getNbTentatives())
        {
            //On genere les indices pour le calcule de score
            if (jeu.getModeJeu().equals("Classique")) {
                mancheController.genererIndices(new ClassicPrint(), ttt);
            } else if (jeu.getModeJeu().equals("Facile")) {
                mancheController.genererIndices(new EasyPrint(), ttt);
            }
            else
            {
                mancheController.genererIndices(new ClassicPrint(), ttt);
            }

            if(this.nbMancheJouer < jeu.getNbManches())
            {
                this.mancheController.calculerScoreManche(ttt);
                controller.setScore(manche.getScore());
                nbTentativeEffectuer = 0;
                FinMache();
            }
            else
            {
                this.mancheController.calculerScoreManche(ttt);
                controller.setScore(manche.getScore());
                FinMache();
            }
        }
        else
        {
            if(jeu.getModeJeu().equals("Classique") || jeu.getModeJeu().equals("Facile")) {
                if (jeu.getModeJeu().equals("Classique")) {
                    mancheController.genererIndices(new ClassicPrint(), ttt);
                } else if (jeu.getModeJeu().equals("Facile")) {
                    mancheController.genererIndices(new EasyPrint(), ttt);
                }
                ArrayList<JLabel> labelIndiceList = new ArrayList<>();
                for (int i = jeu.getNbPionsCombi(); i < components2.length; i++) {
                    Component cpn = components2[i];
                    if (cpn instanceof JLabel) {
                        labelIndiceList.add((JLabel) cpn);
                    }
                }
                for (int k = 0; k < jeu.getNbPionsCombi(); k++) {
                    labelIndiceList.get(k).setBackground(ttt.getIndicesTentative()[k]);
                    labelIndiceList.get(k).setOpaque(true);
                }
            }
            else
            {
                mancheController.genererIndices(new ClassicPrint(), ttt);
                int trouve = 0;
                int malPlacer = 0;
                for(int j = 0; j < ttt.getIndicesTentative().length; j++)
                {
                    if(ttt.getIndicesTentative()[j].equals(Color.BLACK))
                    {
                        trouve++;
                    } else if (ttt.getIndicesTentative()[j].equals(Color.white)) {
                        malPlacer++;

                    }
                }
                ArrayList<JLabel> labelIndiceList = new ArrayList<>();
                for (int i = jeu.getNbPionsCombi(); i < components2.length; i++) {
                    Component cpn = components2[i];
                    if (cpn instanceof JLabel) {
                        labelIndiceList.add((JLabel) cpn);
                    }
                }
                labelIndiceList.get(0).setText(String.valueOf(trouve));
                labelIndiceList.get(1).setText(String.valueOf(malPlacer));
            }
        }
    }

    public void StopManche()
    {
        if(nbMancheJouer < jeu.getNbManches())
        {
            nbTentativeEffectuer = 0;
            FinMache();
        }
        else
        {
            FinMache();
        }
    }

    public void Fin()
    {
        // Affiche la fenêtre de fin avec le résultat de la partie

        setSize(700,700);
        this.getContentPane().removeAll();
        this.validate();
        this.repaint();
        //score max pouvant etre obtenu dans une manche * le nb de manche soit le score parfait pour une partie
        int scoreParfait = (jeu.getNbPionsCombi() * 3) * jeu.getNbManches();
        JPanel panel = new JPanel();
        panel.setLayout( new GridLayout(0,1) );
        JLabel Titre = new JLabel();
        Titre.setPreferredSize(new Dimension(250, 50));
        if(jeu.getScore() >= (scoreParfait / 2))
        {
            Titre.setText("Victoire");
        }
        else
        {
            Titre.setText("Perdu");
        }

        JLabel Score = new JLabel("Votre score : "+jeu.getScore());
        panel.add(Score);
        panel.add(Titre);
        JButton Menu = new JButton("Menu");
        Menu.addActionListener(ActiveEvent -> relancer());
        Menu.setPreferredSize(new Dimension( 300,150));
        panel.add(Menu);
        setContentPane(panel);
        setVisible(true);
    }

    public void relancer()
    {
        nbMancheJouer = 0;
        nbTentativeEffectuer = 0;
        Menu();

    }

    public void FinMache()
    {
        // Affiche la combinaison secrète et le nombre de points gagnés à l'issue de la manche

        setSize(700,700);
        this.getContentPane().removeAll();
        this.validate();
        this.repaint();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));
        JLabel lbl = new JLabel("La combinaison était");
        panel.add(lbl);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        for (int i = 0; i < jeu.getNbPionsCombi(); i++) {
            JLabel indice = new JLabel();
            indice.setPreferredSize(new Dimension(50, 50));
            indice.setBackground(manche.getCombinaisonSecrete()[i]);
            Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
            indice.setBorder(border);
            indice.setOpaque(true);
            panel1.add(indice);
        }
        panel.add(panel1);
        JLabel lbl2 = new JLabel("Votre score sur cette manche est " + manche.getScore() );
        panel.add(lbl2);

        JButton btn = new JButton("Suivant");
        btn.addActionListener(actionEvent -> {
        if(this.nbMancheJouer < jeu.getNbManches())
        {
            game();
        }
        else {
            Fin();
        }}
        );
        panel.add(btn);
        setContentPane(panel);
        setVisible(true);
    }
    @Override
    public void Update() {

    }
}
