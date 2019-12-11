package wargame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static wargame.IConfig.*;

/**
 * Cette classe, extension du Jpanel impl�mente la cr�ation d'une carte par l'utilisateur.
 * <p>
 * Elle est constitu� d'une carte et de tout les boutons d'ajout.
 * Il existe �galement l'option d'extraction d'une carte vers un fichier.
 *
 * @author Soupilas Dimitrios
 * @author Pashinin Aleksei
 */
public class CreationMap extends JPanel {

    public Carte c;

    private JLabel panel;
    //boutons Monstres
    public JButton AjGoblin;
    public JButton AjTroll;
    public JButton AjOrc;
    //boutons Heros
    public JButton AjHumain;
    public JButton AjNain;
    public JButton AjElf;
    public JButton AjHobbit;
    //boutons obstacles
    public JButton AjRocher;
    public JButton AjSea;
    public JButton AjForet;
    //bouton effacer
    public JButton Effacer;
    //bouton extract
    public JButton Extract;
    private javax.swing.JLabel jLabel1;
    public JButton Return;


    public int ajout = 0;
    public int option;
    //private javax.swing.JPanel jPanelMain;

    /**
     * Ce constructeur cr�e une carte "vierge" et initialise tous les Boutons d'ajout.
     */

    public CreationMap() {
        panel = new JLabel();
        //panel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/game-dark.jpg")));
        setPreferredSize(new Dimension(SettingsControl.getWIDTH_PAGE(), SettingsControl.getHEIGHT_PAGE()));
        panel.setBounds(0, 0, 1365, 768);
        //panel = new JLabel();
        //jLabel1 = new javax.swing.JLabel();
        //jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/game-dark.jpg"))); // NOI18N
        //jLabel1.setText("jLabel1");
        //panel.add(jLabel1);
        //jLabel1.setBounds(0, 0, 1365, 768);
        //creation d'une carte vide
        //ImageIcon background = new ImageIcon("/wargame/Images/hobbit.png");
        
        c = new Carte();
        //panel = new JLabel();
        
        //ajout des boutons heros
        BouttonAjHobbit();
        AjHobbit.setBounds(35, 350, 80, 80);
        AjHobbit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/hobbit.png")));
        panel.add(AjHobbit);


        BouttonAjHumain();
        AjHumain.setBounds(125, 350, 80, 80);
        AjHumain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/knight.png")));
        panel.add(AjHumain);


        BouttonAjElf();
        AjElf.setBounds(215, 350, 80, 80);
        AjElf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/elf.png")));
        panel.add(AjElf);


        BouttonAjNain();
        AjNain.setBounds(35, 440, 80, 80);
        AjNain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/dwarf.png")));
        panel.add(AjNain);


        //ajout des boutons heros
        BouttonAjGoblin();
        AjGoblin.setBounds(125, 440, 80, 80);
        AjGoblin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/goblin.png")));
        panel.add(AjGoblin);


        BouttonAjOrc();
        AjOrc.setBounds(215, 440, 80, 80);
        AjOrc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/orc.png")));
        panel.add(AjOrc);


        BouttonAjTroll();
        AjTroll.setBounds(35, 530, 80, 80);
        AjTroll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/troll.png")));
        panel.add(AjTroll);
        
        //ajout des obstacles
        BouttonAjRocher();
        AjRocher.setBounds(125, 530, 80, 80);
        AjRocher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/roche.png")));
        panel.add(AjRocher);
        
        
        BouttonAjSea();
        AjSea.setBounds(215, 530, 80, 80);
        AjSea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/leau.png")));
        panel.add(AjSea);
        
        
        BouttonAjForet();
        AjForet.setBounds(35, 620, 80, 80);
        AjForet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/foret.png")));
        panel.add(AjForet);
        
        
        //effacer
        BouttonEffacer();
        Effacer.setBounds(125, 620, 80, 80);
        Effacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/delete.png")));
        panel.add(Effacer);

        
        BouttonExtract();
        Extract.setBounds(215, 620, 80, 80);
        Extract.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/save.png")));
        panel.add(Extract);
        
        BouttonReturn();
        Return.setBounds(25, 700, 279, 37);
        Return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/returntom.png")));
        panel.add(Return);
        
        panel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/colon.png")));
        add(panel);
        panel.setBounds(1050, 0, 310, 770);

        //jLabel1 = new javax.swing.JLabel();
        //jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/game-dark.jpg"))); // NOI18N
        //jLabel1.setText("jLabel1");
        //panel.add(jLabel1);
        //jLabel1.setBounds(0, 0, 1365, 768);
        //listener de sourie
        MouseAj();


    }



    /******** BOUTTONS HEROS ******/


    public void BouttonAjHumain() {
        AjHumain = new JButton();
        AjHumain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AjHumainMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                AjHumainMouseExited(evt);
            }

            private void AjHumainMouseEntered(java.awt.event.MouseEvent evt) {
                AjHumain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/knightlight.png")));
                Sound pig = new Sound();
            }

            private void AjHumainMouseExited(java.awt.event.MouseEvent evt) {
                AjHumain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/knight.png")));
            }
        });
        AjHumain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("AjHumain");
                ajout = 1;
                option = 1;

            }
        });
    }


    public void BouttonAjNain() {
        AjNain = new JButton();
        AjNain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AjNainMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                AjNainMouseExited(evt);
            }

            private void AjNainMouseEntered(java.awt.event.MouseEvent evt) {
                AjNain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/dwarflight.png")));
                Sound pig = new Sound();
            }

            private void AjNainMouseExited(java.awt.event.MouseEvent evt) {
                AjNain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/dwarf.png")));
            }
        });
        AjNain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // System.out.println("AjNain");
                ajout = 1;
                option = 2;

            }
        });
    }

    public void BouttonAjElf() {
        AjElf = new JButton();
        AjElf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AjElfMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                AjElfMouseExited(evt);
            }

            private void AjElfMouseEntered(java.awt.event.MouseEvent evt) {
                AjElf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/elflight.png")));
                Sound pig = new Sound();
            }

            private void AjElfMouseExited(java.awt.event.MouseEvent evt) {
                AjElf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/elf.png")));
            }
        });
        AjElf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("AjElf");
                ajout = 1;
                option = 3;
            }
        });
    }


    
    
    public void BouttonAjHobbit() {
        AjHobbit = new JButton();
        AjHobbit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AjHobbitMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                AjHobbitMouseExited(evt);
            }

            private void AjHobbitMouseEntered(java.awt.event.MouseEvent evt) {
                AjHobbit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/hobbitlight.png")));
                Sound pig = new Sound();
            }

            private void AjHobbitMouseExited(java.awt.event.MouseEvent evt) {
                AjHobbit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/hobbit.png")));
            }
        });
        AjHobbit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("AjHobbit");
                ajout = 1;
                option = 4;
            }
        });
    }
    
    public void BouttonReturn() {
        Return = new JButton();
        Return.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ReturnMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                ReturnMouseExited(evt);
            }

            private void ReturnMouseEntered(java.awt.event.MouseEvent evt) {
                Return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/returntomlight.png")));
                Sound pig = new Sound();
            }

            private void ReturnMouseExited(java.awt.event.MouseEvent evt) {
                Return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/returntom.png")));
            }
        });
        Return.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                        removeAll();
                        add(WarFrame.jPanelMain);
                        revalidate(); 
                        repaint();
            }
        });
    }

    /****** BOUTONS MONSTRES *****/

    public void BouttonAjTroll() {
        AjTroll = new JButton();
        AjTroll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AjTrollMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                AjTrollMouseExited(evt);
            }

            private void AjTrollMouseEntered(java.awt.event.MouseEvent evt) {
                AjTroll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/trolllight.png")));
                Sound pig = new Sound();
            }

            private void AjTrollMouseExited(java.awt.event.MouseEvent evt) {
                AjTroll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/troll.png")));
            }
        });
        AjTroll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("AjTroll");
                ajout = 1;
                option = 5;
            }
        });
    }

    public void BouttonAjOrc() {
        AjOrc = new JButton();
        AjOrc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AjOrcMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                AjOrcMouseExited(evt);
            }

            private void AjOrcMouseEntered(java.awt.event.MouseEvent evt) {
                AjOrc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/orclight.png")));
                Sound pig = new Sound();
            }

            private void AjOrcMouseExited(java.awt.event.MouseEvent evt) {
                AjOrc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/orc.png")));
            }
        });
        AjOrc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("AjOrc");
                ajout = 1;
                option = 6;
            }
        });
    }

    public void BouttonAjGoblin() {
        AjGoblin = new JButton();

        AjGoblin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AjGoblinMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                AjGoblinMouseExited(evt);
            }

            private void AjGoblinMouseEntered(java.awt.event.MouseEvent evt) {
                AjGoblin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/goblinlight.png")));
                Sound pig = new Sound();
            }

            private void AjGoblinMouseExited(java.awt.event.MouseEvent evt) {
                AjGoblin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/goblin.png")));
            }
        });
        AjGoblin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("AjGoblin");
                ajout = 1;
                option = 7;
            }
        });
    }

    /**
     * BOUTTONS OBSTACLES
     **/

    public void BouttonAjRocher() {
        AjRocher = new JButton();
        
        AjRocher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AjRocherMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AjRocherMouseExited(evt);
            }
            
            private void AjRocherMouseEntered(java.awt.event.MouseEvent evt) {                                       
        AjRocher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/rochelight.png")));
        Sound pig = new Sound();
    }                                      

    private void AjRocherMouseExited(java.awt.event.MouseEvent evt) {                                      
        AjRocher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/roche.png")));
    } 
        });
        AjRocher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // System.out.println("AjRocher");
                ajout = 1;
                option = 8;
            }
        });
    }

    public void BouttonAjSea() {
        AjSea = new JButton();
        AjSea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AjSeaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AjSeaMouseExited(evt);
            }
            
            private void AjSeaMouseEntered(java.awt.event.MouseEvent evt) {                                       
        AjSea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/leaulight.png")));
        Sound pig = new Sound();
    }                                      

    private void AjSeaMouseExited(java.awt.event.MouseEvent evt) {                                      
        AjSea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/leau.png")));
    } 
        });
        AjSea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("AjMer");
                ajout = 1;
                option = 9;
            }
        });
    }

    public void BouttonAjForet() {
        AjForet = new JButton();    
        AjForet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AjForetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AjForetMouseExited(evt);
            }
            
            private void AjForetMouseEntered(java.awt.event.MouseEvent evt) {                                       
        AjForet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/foretlight.png")));
        Sound pig = new Sound();
    }                                      

    private void AjForetMouseExited(java.awt.event.MouseEvent evt) {                                      
        AjForet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/foret.png")));
    } 
        });
        AjForet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("AjForet");
                ajout = 1;
                option = 10;
            }
        });
    }

    /**
     * BOUTTON EFFACER
     **/

    public void BouttonEffacer() {
        Effacer = new JButton();
        Effacer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EffacerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EffacerMouseExited(evt);
            }
            
            private void EffacerMouseEntered(java.awt.event.MouseEvent evt) {                                       
        Effacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/deletelight.png")));
        Sound pig = new Sound();
    }                                      

    private void EffacerMouseExited(java.awt.event.MouseEvent evt) {                                      
        Effacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/delete.png")));
    } 
        });
        Effacer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Effacer");
                ajout = 1;
                option = 11;
            }
        });
    }

    /**
     * M�thode de cr�ation du bouton d'extraction
     * <p>
     * Elle demandera � l'utilisateur le nom du fichier et le sauvegardera dans le dossier Maps.
     * Le fichier de la map sera sous le la forme map_X.txt,
     * X �tant le nom choisi par l'utilisateur.
     */
    public void BouttonExtract() {
        Extract = new JButton();
        
        Extract.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExtractMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExtractMouseExited(evt);
            }

            private void ExtractMouseEntered(java.awt.event.MouseEvent evt) {
                Extract.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/savelight.png")));
                Sound pig = new Sound();
            }

            private void ExtractMouseExited(java.awt.event.MouseEvent evt) {
                Extract.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/save.png")));
            }
        });
        Extract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String a = JOptionPane.showInputDialog(
                        null,
                        "Le nom de votre map : \n" + "Sera sauvegarde dans le dossier Maps\n",
                        "Map Name",
                        1
                );
                if (a == null || (a != null && ("".equals(a)))) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Vous avez pas choisi de nom\n",
                            "Opperation annulee\n",
                            0
                    );
                } else {
                    //System.out.println("Extract");
                    PrintWriter map = null;
                    try {
                        map = new PrintWriter("Maps/map_" + a + ".txt", "UTF-8");
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (UnsupportedEncodingException e1) {
                        e1.printStackTrace();
                    }
                    map.println(SettingsControl.getLARGEUR_CARTE());
                    map.println(SettingsControl.getHAUTEUR_CARTE());
                    for (int i = 0; i < SettingsControl.getLARGEUR_CARTE(); i++) {
                        for (int j = 0; j < SettingsControl.getHAUTEUR_CARTE(); j++) {

                            if (c.getElement(new Position(i, j)) instanceof Heros) {
                                //il s'agit d'un elf
                                if (((Heros) c.getElement(new Position(i, j))).getType() == "ELF") {
                                    map.println(10);
                                    map.println(((Soldat) c.getElement(new Position(i, j))).getPoints());
                                    //il s'agit d'un humain
                                } else if (((Heros) c.getElement(new Position(i, j))).getType() == "HUMAIN") {
                                    map.println(9);
                                    map.println(((Soldat) c.getElement(new Position(i, j))).getPoints());
                                    //il s'agit d'un hobit
                                } else if (((Heros) c.getElement(new Position(i, j))).getType() == "HOBBIT") {
                                    map.println(8);
                                    map.println(((Soldat) c.getElement(new Position(i, j))).getPoints());
                                    //il s'agit d'un nain
                                } else if (((Heros) c.getElement(new Position(i, j))).getType() == "NAIN") {
                                    map.println(7);
                                    map.println(((Soldat) c.getElement(new Position(i, j))).getPoints());
                                }

                            } else if (c.getElement(new Position(i, j)) instanceof Monstre) {

                                if (((Monstre) c.getElement(new Position(i, j))).getType() == "ORC") {
                                    // il s'agit d'un orc
                                    map.println(6);
                                    map.println(((Soldat) c.getElement(new Position(i, j))).getPoints());
                                } else if (((Monstre) c.getElement(new Position(i, j))).getType() == "GOBELIN") {
                                    // il s'agit d'un gobelin
                                    map.println(5);
                                    map.println(((Soldat) c.getElement(new Position(i, j))).getPoints());
                                } else if (((Monstre) c.getElement(new Position(i, j))).getType() == "TROLL") {
                                    // il s'agit d'un troll
                                    map.println(4);
                                    map.println(((Soldat) c.getElement(new Position(i, j))).getPoints());
                                }

                            } else if (c.getElement(new Position(i, j)) instanceof Obstacle) {
                                //il s'agit d'un obstacle
                                Color couleur = ((Obstacle) c.getElement(new Position(i, j))).getTYPE().getObstacle();
                                if (couleur == COULEUR_ROCHER) {
                                    //rocher
                                    map.println(3);
                                } else if (couleur == COULEUR_EAU) {
                                    //deau
                                    map.println(2);

                                } else if (couleur == COULEUR_FORET) {
                                    //foret
                                    map.println(1);
                                }
                            } else {
                                // il s'aggit d'une position vide
                                map.println(0);

                            }
                        }
                    }
                    map.close();
                    JOptionPane.showMessageDialog(
                            null,
                            "Extraction accompli\n",
                            "Merci\n",
                            1
                    );

                }
            }
        });

    }

    /**
     * Cette m�thode ajoute le bon Element dans la carte.
     * <p>
     * Elle verifiera la validit� du click. (voir class Carte m�thode trouvePositionHexagonal)
     * Ensuit ajoutera le bon �l�ment d�pendant du bouton qui a �t� click� le plus r�cemment.
     *
     * @param pos Position
     */

    public void ajouterMap(Position pos) {
        int x = pos.getX() / (SettingsControl.getNB_PIX_CASE() + (SettingsControl.getNB_PIX_CASE() / 2));
        int y = (int) (pos.getY() / (SettingsControl.getNB_PIX_CASE() / SettingsControl.getCONSTANTE() / 2));
        if (x == SettingsControl.getLARGEUR_CARTE())
            x--;
        if (y == SettingsControl.getHAUTEUR_CARTE())
            y--;
        Position p = new Position(x, y);
        if (p.estValide()) {
            /** liste contenant toutes les positions autour de notre position aproximative **/
            List<Position> posi = c.trouvePositionHexagonal(p);
            boolean b;
            for (Position po : posi) {
                if (c.getElement(po).dedans(pos)) {
                    System.out.println();
                    switch (option) {
                        case 1:
                            c.ajouterElement(new Heros(ISoldat.TypesH.HUMAIN, po));
                            break;
                        case 2:
                            c.ajouterElement(new Heros(ISoldat.TypesH.NAIN, po));
                            break;
                        case 3:
                            c.ajouterElement(new Heros(ISoldat.TypesH.ELF, po));
                            break;
                        case 4:
                            c.ajouterElement(new Heros(ISoldat.TypesH.HOBBIT, po));
                            break;
                        case 5:
                            c.ajouterElement(new Monstre(ISoldat.TypesM.TROLL, po));
                            break;
                        case 6:
                            c.ajouterElement(new Monstre(ISoldat.TypesM.ORC, po));
                            break;
                        case 7:
                            c.ajouterElement(new Monstre(ISoldat.TypesM.GOBELIN, po));
                            break;
                        case 8:
                            c.ajouterElement(new Obstacle(Obstacle.TypeObstacle.ROCHER, po));
                            break;
                        case 9:
                            c.ajouterElement(new Obstacle(Obstacle.TypeObstacle.EAU, po));
                            break;
                        case 10:
                            c.ajouterElement(new Obstacle(Obstacle.TypeObstacle.FORET, po));
                            break;
                        case 11:
                            c.ajouterElement(new Element(po));
                            break;
                        default:
                            System.out.println("ERRER D AJOUT");

                    }
                }
            }
            repaint();
        }
    }

    public void MouseAj() {
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (ajout == 1) {
                    Position pos = new Position(e.getX(), e.getY());
                    ajouterMap(pos);
                }

            }
        });
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        c.toutDessiner(g);
        
    }
}
