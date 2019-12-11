package wargame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FenetreJeu implements IConfig {
    //public static JFrame f;
    public static WarFrame f;
    private PanneauJeu p;
    private paneauInformation info;
    private PanneauMenu menu;
    private CreationMap map;
    public SettingsControl Settings;



    public FenetreJeu() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                Settings=new SettingsControl();
                /*** LA FRAME ***/
                //f = new JFrame("wargame");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                /*** PANNEAU JEU ***/
                p = new PanneauJeu();
                //informationsSoldats();

                /*** PANNEAU INFO ***/
                info = new paneauInformation();

                /*** PANNEAU MENU ***/
                menu = new PanneauMenu();

                /** CREAION MAP **/
                map =new CreationMap();
                map.setLayout(null);

                /*** RAJOUT DE TOUT DANS LA FRAME ***/

                f.add(map, BorderLayout.CENTER);
               // f.getContentPane().add(info, BorderLayout.NORTH);
                //f.getContentPane().add(menu, BorderLayout.EAST);
                f.pack();
                f.setVisible(true);
            }
        });
    }

    //pour load une map
    public FenetreJeu(String nomFichier,String dossier) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                Settings=new SettingsControl();
                /*** LA FRAME ***/
                //f = new JFrame("wargame");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                /*** PANNEAU JEU ***/
                p = new PanneauJeu(nomFichier,dossier);
                informationsSoldats();

                /*** PANNEAU INFO ***/
                info = new paneauInformation();

                /*** PANNEAU MENU ***/
                menu = new PanneauMenu();

                /** CREAION MAP **/
                map =new CreationMap();

                /*** RAJOUT DE TOUT DANS LA FRAME ***/

                f.add(p, null);
                f.getContentPane().add(info, BorderLayout.NORTH);
                // f.getContentPane().add(menu, BorderLayout.EAST);
                f.pack();
                f.setVisible(true);
            }
        });
    }


    public void informationsSoldats() {
        p.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                double constante = 1.154;
                int x = e.getX() / (SettingsControl.getNB_PIX_CASE() + (SettingsControl.getNB_PIX_CASE() / 2));
                int y = (int) (e.getY() / (SettingsControl.getNB_PIX_CASE() / constante / 2));
                Position pos = new Position(x, y);
                if (pos.estValide()) {
                    if (p.carte.getElement(pos) instanceof Soldat) {
                        info.setMonLabel(((Soldat) p.carte.getElement(pos)).getType() + " ( " + ((Soldat) p.carte.getElement(pos)).getPoints() + "/"
                                + ((Soldat) p.carte.getElement(pos)).getPointsMax() + "HP, Range : " + ((Soldat) p.carte.getElement(pos)).getTir() +
                                ", Damage : " + ((Soldat) p.carte.getElement(pos)).getPuissance() + " )");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        //FenetreJeu f = new FenetreJeu("map_Soldats","Maps");

       SettingsControl Settings=new SettingsControl();
       Music ymca = new Music();
                WarFrame f = new WarFrame();
                f.pack();
                f.setVisible(true);
    }

}
