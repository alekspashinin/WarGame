package wargame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class PanneauJeu extends JPanel implements IConfig {

    public Carte carte;
    public MouvementHero mvHero;
    public static JButton finTour;
    public static JButton MenuTour;
    
    //private javax.swing.JPanel jPanelHumDef;
    


    public PanneauJeu() {

        
        setPreferredSize(new Dimension(950, SettingsControl.getHEIGHT_PAGE()));
        //setBackground(COULEUR_EAU);
        carte = new Carte();
        carte.carteAlea();
        boutonFinTour();
        add(finTour, BorderLayout.PAGE_END);


        mouvHeros();
        //end to mouv heros by making ActionMouv bool or by taking mouvhero out od panneaujeu
    }

    public PanneauJeu(String nomFichier,String dossier) {

        setPreferredSize(new Dimension(SettingsControl.getWIDTH_PAGE(), SettingsControl.getHEIGHT_PAGE()));
        setBackground(COULEUR_EAU);
        carte = new Carte(nomFichier,dossier);
        boutonFinTour();
        add(finTour, BorderLayout.SOUTH);


        mouvHeros();
        //end to mouv heros by making ActionMouv bool or by taking mouvhero out od panneaujeu
    }


    public void mouvHeros() {
        mvHero = new MouvementHero();
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                Position positionSourie = new Position(e.getX(), e.getY());
                mvHero.ActionMouvementHeros(positionSourie, carte);
                repaint();
                revalidate();


            }
        });
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        carte.toutDessiner(g);
        
    }

    
    public void boutonFinTour() {
        finTour = new JButton("FIN DU TOUR");
        //finTour.setLayout(null);
        finTour.setBounds(500,500,240,69);
        
        finTour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                finTour.setVisible(false);

                //tour des Monstres
                carte.actionMonstres1();

                //redonne le droit aux heros d'effectuer une action
                carte.remetreTourHeroZero();
                finTour.setVisible(true);
                repaint();
            }
        });
    }
    
    
    
    private void finTourMouseEntered(java.awt.event.MouseEvent evt) {                                        
        finTour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/tourlight.png")));
        Sound pig = new Sound();
    }                                       

    private void finTourMouseExited(java.awt.event.MouseEvent evt) {                                       
        finTour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/tour.png")));
    }                                      

    
    
}
