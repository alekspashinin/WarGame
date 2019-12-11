package wargame;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.swing.*;

import static wargame.IConfig.*;

/**
 * Cette classe implemente la construction d'un menu principale de jeu et petite menu de jeu
 *
 *
 * @author Dimitrios Soupilas
 * @author Aleksei Pashinin
 */
public class WarFrame extends javax.swing.JFrame {

    /**
     * Creates new form WarFrame
     */
    
    private Timer timer;
    private int counter = 4;
    private int counter2 = 6;
    private int counter3 = 4;
    private int globalcounter = 0;
    private int delay = 1000;
    
    public WarFrame() {
        
        initComponents();
        CustomCursor();
        /**
         * Intro de jeu
         */
        getContentPane().removeAll(); 
        getContentPane().add(jPanelIntro); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
        ActionListener action = new ActionListener()
        {   
            @Override
            public void actionPerformed(java.awt.event.ActionEvent event)
            {
                if(counter2 == 0)
                {
                    timer.stop();
                    getContentPane().removeAll(); 
                    getContentPane().add(jPanelIntro2); 
                    getContentPane().revalidate(); 
                    getContentPane().repaint();
                    ActionListener action2 = new ActionListener()
        {   
            @Override
            public void actionPerformed(java.awt.event.ActionEvent event)
            {
                if(counter3 == 0)
                {
                    timer.stop();
                    getContentPane().removeAll(); 
                    getContentPane().add(jPanelMain); 
                    getContentPane().revalidate(); 
                    getContentPane().repaint();
                    
                }
                else
                {                   
                    counter3--;
                }
            }
        };
        
        timer = new Timer(delay, action2);
        timer.setInitialDelay(0);
        timer.start();
    
                }
                else
                {                   
                    counter2--;
                }
            }
        };

        timer = new Timer(delay, action);
        timer.setInitialDelay(0);
        timer.start();
    }    
    
    public void CustomCursor(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage(getClass().getResource("/wargame/Icons/Arrow_result.png"));
        Point point=new Point(0,0);
        Cursor c = toolkit.createCustomCursor(image , point, "Cursor");
        setCursor(c);
    }
    
/**
 * Initialisation de toutes elements de menu
 */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanelIntro = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanelIntro2 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jPanelMain = new javax.swing.JPanel();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanelLoadGame = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jButton26 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jPanelNewGame = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanelTutorial = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanelPreferences = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        jSlider2 = new javax.swing.JSlider();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanelGame = new javax.swing.JPanel();
        panneauJeu1 = new wargame.PanneauJeu();
        jLabel64 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanelCredits = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanelLoading = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jPanelGameDark = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jPanelHumWin = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jPanelHumDef = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel171 = new javax.swing.JLabel();
        creationMap1 = new wargame.CreationMap();
        jLabel36 = new javax.swing.JLabel();
        creationMap2 = new wargame.CreationMap();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1365, 768));
        setSize(new java.awt.Dimension(1365, 768));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanelIntro.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jPanelIntroVetoableChange(evt);
            }
        });
        jPanelIntro.setLayout(null);

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/backintro.jpg"))); // NOI18N
        jPanelIntro.add(jLabel21);
        jLabel21.setBounds(0, 0, 1365, 768);

        getContentPane().add(jPanelIntro);
        jPanelIntro.setBounds(0, 0, 1370, 770);
        jPanelIntro.setVisible(true);
        try{Thread.sleep(2000);
        }catch(InterruptedException e){}
        getContentPane().removeAll();
        getContentPane().add(jPanelMain);
        getContentPane().invalidate();
        getContentPane().repaint();

        jPanelIntro2.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jPanelIntro2VetoableChange(evt);
            }
        });
        jPanelIntro2.setLayout(null);

        jLabel49.setBackground(new java.awt.Color(0, 0, 0));
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/backintro2.jpg"))); // NOI18N
        jPanelIntro2.add(jLabel49);
        jLabel49.setBounds(0, 0, 1365, 768);

        getContentPane().add(jPanelIntro2);
        jPanelIntro2.setBounds(0, 0, 1370, 770);
        jPanelIntro.setVisible(true);
        try{Thread.sleep(2000);
        }catch(InterruptedException e){}
        getContentPane().removeAll();
        getContentPane().add(jPanelMain);
        getContentPane().invalidate();
        getContentPane().repaint();
        /**
         * Menu principale
         */
        jPanelMain.setLayout(null);



        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/newgame.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanelMain.add(jButton1);
        jButton1.setBounds(560, 230, 240, 69);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/loadgame.png"))); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanelMain.add(jButton2);
        jButton2.setBounds(560, 320, 240, 69);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/credits.png"))); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanelMain.add(jButton3);
        jButton3.setBounds(560, 500, 240, 69);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/exit.png"))); // NOI18N
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanelMain.add(jButton4);
        jButton4.setBounds(560, 590, 240, 69);

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/tutorial.png"))); // NOI18N
        jButton25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton25MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton25MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton25MouseExited(evt);
            }
        });
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanelMain.add(jButton25);
        jButton25.setBounds(560, 410, 240, 69);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/fire.gif"))); // NOI18N
        jPanelMain.add(jLabel2);
        jLabel2.setBounds(390, 550, 150, 200);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/fire3.gif"))); // NOI18N
        jLabel3.setToolTipText("");
        jPanelMain.add(jLabel3);
        jLabel3.setBounds(850, 550, 103, 194);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/back1365.jpg"))); // NOI18N
        jPanelMain.add(jLabel1);
        jLabel1.setBounds(0, 0, 1365, 768);

        getContentPane().add(jPanelMain);
        jPanelMain.setBounds(0, 0, 1365, 768);

        jPanelLoadGame.setLayout(null);

        jLabel71.setFont(new java.awt.Font("LifeCraft", 0, 24)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("EMPTY");
        jPanelLoadGame.add(jLabel71);
        jLabel71.setBounds(495, 240, 370, 54);

        jLabel72.setFont(new java.awt.Font("LifeCraft", 0, 24)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("EMPTY");
        jPanelLoadGame.add(jLabel72);
        jLabel72.setBounds(495, 310, 370, 54);

        jLabel73.setFont(new java.awt.Font("LifeCraft", 0, 24)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("EMPTY");
        jPanelLoadGame.add(jLabel73);
        jLabel73.setBounds(495, 380, 370, 54);

        jLabel74.setFont(new java.awt.Font("LifeCraft", 0, 24)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("EMPTY");
        jPanelLoadGame.add(jLabel74);
        jLabel74.setBounds(495, 450, 370, 54);

        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/save-load.png"))); // NOI18N
        jLabel66.setText("EMPTY");
        jPanelLoadGame.add(jLabel66);
        jLabel66.setBounds(495, 240, 370, 54);

        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/save-load.png"))); // NOI18N
        jLabel67.setText("EMPTY");
        jPanelLoadGame.add(jLabel67);
        jLabel67.setBounds(495, 310, 370, 54);

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/save-load.png"))); // NOI18N
        jLabel68.setText("EMPTY");
        jPanelLoadGame.add(jLabel68);
        jLabel68.setBounds(495, 380, 370, 54);

        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/save-load.png"))); // NOI18N
        jLabel69.setText("EMPTY");
        jPanelLoadGame.add(jLabel69);
        jLabel69.setBounds(495, 450, 370, 54);

        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/photosl.png"))); // NOI18N
        jPanelLoadGame.add(jLabel65);
        jLabel65.setBounds(480, 220, 400, 300);

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/return.png"))); // NOI18N
        jButton26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton26MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton26MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton26MouseExited(evt);
            }
        });
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanelLoadGame.add(jButton26);
        jButton26.setBounds(560, 590, 240, 69);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/fire.gif"))); // NOI18N
        jPanelLoadGame.add(jLabel7);
        jLabel7.setBounds(390, 550, 150, 200);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/fire3.gif"))); // NOI18N
        jLabel8.setToolTipText("");
        jPanelLoadGame.add(jLabel8);
        jLabel8.setBounds(850, 550, 103, 194);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/back1365.jpg"))); // NOI18N
        jPanelLoadGame.add(jLabel9);
        jLabel9.setBounds(0, 0, 1365, 768);

        jLabel70.setText("jLabel70");
        jPanelLoadGame.add(jLabel70);
        jLabel70.setBounds(930, 190, 53, 16);

        getContentPane().add(jPanelLoadGame);
        jPanelLoadGame.setBounds(0, 0, 1370, 770);
        globalcounter=1;

        jPanelNewGame.setLayout(null);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/create.png"))); // NOI18N
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton5MousePressed(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanelNewGame.add(jButton5);
        jButton5.setBounds(560, 230, 240, 69);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/random.png"))); // NOI18N
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanelNewGame.add(jButton6);
        jButton6.setBounds(560, 320, 240, 69);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/return.png"))); // NOI18N
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton8MouseExited(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanelNewGame.add(jButton8);
        jButton8.setBounds(560, 590, 240, 69);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/fire.gif"))); // NOI18N
        jPanelNewGame.add(jLabel4);
        jLabel4.setBounds(390, 550, 150, 200);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/fire3.gif"))); // NOI18N
        jLabel5.setToolTipText("");
        jPanelNewGame.add(jLabel5);
        jLabel5.setBounds(850, 550, 103, 194);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/back1365.jpg"))); // NOI18N
        jPanelNewGame.add(jLabel6);
        jLabel6.setBounds(0, 0, 1365, 768);

        getContentPane().add(jPanelNewGame);
        jPanelNewGame.setBounds(0, 0, 1370, 770);
        globalcounter=1;

        jPanelTutorial.setLayout(null);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/photoram400.png"))); // NOI18N
        jLabel20.setText("jLabel20");
        jPanelTutorial.add(jLabel20);
        jLabel20.setBounds(70, 60, 320, 300);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/phototext300.png"))); // NOI18N
        jLabel22.setText("jLabel22");
        jPanelTutorial.add(jLabel22);
        jLabel22.setBounds(530, 260, 300, 290);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/photoram400.png"))); // NOI18N
        jLabel23.setText("jLabel23");
        jPanelTutorial.add(jLabel23);
        jLabel23.setBounds(870, 230, 180, 160);

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/photoram400.png"))); // NOI18N
        jLabel24.setText("jLabel24");
        jPanelTutorial.add(jLabel24);
        jLabel24.setBounds(1000, 440, 180, 160);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/return.png"))); // NOI18N
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton9MouseExited(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanelTutorial.add(jButton9);
        jButton9.setBounds(560, 590, 240, 69);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/fire.gif"))); // NOI18N
        jPanelTutorial.add(jLabel10);
        jLabel10.setBounds(380, 550, 150, 200);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/fire3.gif"))); // NOI18N
        jLabel11.setToolTipText("");
        jPanelTutorial.add(jLabel11);
        jLabel11.setBounds(850, 550, 103, 194);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/back1365.jpg"))); // NOI18N
        jPanelTutorial.add(jLabel12);
        jLabel12.setBounds(0, 0, 1370, 768);

        getContentPane().add(jPanelTutorial);
        jPanelTutorial.setBounds(0, 0, 1370, 770);
        globalcounter=1;

        jPanelPreferences.setLayout(null);

        jSlider1.setBackground(new java.awt.Color(51, 51, 255));
        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jPanelPreferences.add(jSlider1);
        jSlider1.setBounds(680, 330, 160, 29);

        jSlider2.setMaximum(25);
        jSlider2.setValue(12);
        jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });
        jPanelPreferences.add(jSlider2);
        jSlider2.setBounds(680, 390, 150, 29);

        jLabel33.setFont(new java.awt.Font("LifeCraft", 0, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("25");
        jLabel33.setToolTipText("");
        jPanelPreferences.add(jLabel33);
        jLabel33.setBounds(870, 330, 40, 30);

        jLabel34.setFont(new java.awt.Font("LifeCraft", 0, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("12");
        jLabel34.setToolTipText("");
        jPanelPreferences.add(jLabel34);
        jLabel34.setBounds(870, 390, 40, 30);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/smallf.png"))); // NOI18N
        jLabel28.setText("jLabel28");
        jPanelPreferences.add(jLabel28);
        jLabel28.setBounds(680, 310, 240, 70);

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/smallf.png"))); // NOI18N
        jLabel32.setText("jLabel32");
        jPanelPreferences.add(jLabel32);
        jLabel32.setBounds(680, 370, 240, 70);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/size.png"))); // NOI18N
        jPanelPreferences.add(jLabel19);
        jLabel19.setBounds(440, 310, 240, 69);
        jPanelPreferences.add(jLabel30);
        jLabel30.setBounds(620, 340, 0, 0);
        jPanelPreferences.add(jLabel31);
        jLabel31.setBounds(630, 400, 0, 0);

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/number.png"))); // NOI18N
        jPanelPreferences.add(jLabel27);
        jLabel27.setBounds(440, 370, 240, 69);

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/options2.png"))); // NOI18N
        jLabel29.setText("jLabel29");
        jPanelPreferences.add(jLabel29);
        jLabel29.setBounds(550, 200, 240, 69);

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/start.png"))); // NOI18N
        jButton20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton20MouseExited(evt);
            }
        });
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanelPreferences.add(jButton20);
        jButton20.setBounds(560, 500, 240, 69);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/fire.gif"))); // NOI18N
        jPanelPreferences.add(jLabel13);
        jLabel13.setBounds(390, 550, 150, 200);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/fire3.gif"))); // NOI18N
        jLabel14.setToolTipText("");
        jPanelPreferences.add(jLabel14);
        jLabel14.setBounds(850, 550, 103, 194);

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/return.png"))); // NOI18N
        jButton21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton21MouseExited(evt);
            }
        });
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanelPreferences.add(jButton21);
        jButton21.setBounds(560, 590, 240, 69);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/back1365.jpg"))); // NOI18N
        jPanelPreferences.add(jLabel15);
        jLabel15.setBounds(0, 0, 1365, 768);

        jLabel35.setText("jLabel35");
        jPanelPreferences.add(jLabel35);
        jLabel35.setBounds(840, 340, 53, 16);

        getContentPane().add(jPanelPreferences);
        jPanelPreferences.setBounds(0, 0, 1370, 770);
        globalcounter=1;

        jPanelGame.setMinimumSize(new java.awt.Dimension(1365, 768));
        jPanelGame.setLayout(null);
        /**
         * JPanel de jeu principale
         */

        panneauJeu1.setPreferredSize(new java.awt.Dimension(1365, 768));
        jPanelGame.add(panneauJeu1);
        panneauJeu1.setBounds(0, 20, 950, SettingsControl.getHEIGHT_PAGE()-20);
        panneauJeu1.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                //double constante = 1.154;
                int x = e.getX() / (SettingsControl.getNB_PIX_CASE() + (SettingsControl.getNB_PIX_CASE() / 2));
                int y = (int) (e.getY() / (SettingsControl.getNB_PIX_CASE() / SettingsControl.getCONSTANTE() / 2));
                Position pos = new Position(x, y);
                if (pos.estValide()) {
                    if (panneauJeu1.carte.getElement(pos) instanceof Soldat) {
                        info.setMonLabel(((Soldat) panneauJeu1.carte.getElement(pos)).getType() + " ( " + ((Soldat) panneauJeu1.carte.getElement(pos)).getPoints() + "/"
                                + ((Soldat) panneauJeu1.carte.getElement(pos)).getPointsMax() + "HP, Range : " + ((Soldat) panneauJeu1.carte.getElement(pos)).getTir() +
                                ", Damage : " + ((Soldat) panneauJeu1.carte.getElement(pos)).getPuissance() + " )");
                    }
                }
            }
        });

        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/colon.png"))); // NOI18N
        //jLabel64.setText("jLabel64");
        jPanelGame.add(jLabel64);
        jLabel64.setBounds(1050, 0, 323, 789);
        

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/menug.png"))); // NOI18N
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanelGame.add(jButton7);
        jButton7.setBounds(960, 12, 93, 92);

        jLabel171.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/backjeu.png"))); // NOI18N
        jPanelGame.add(jLabel171);
        jLabel171.setBounds(0, 0, 1365, 768);
        //Info Soldats
        info.setPreferredSize(new java.awt.Dimension(1365,20));
        jPanelGame.add(info);
        info.setBounds(0,0,950,20);
        
        

        PanneauJeu.finTour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/turn.png"))); // NOI18N
        PanneauJeu.finTour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                finTourMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                finTourMouseExited(evt);
            }
        });
        
        jPanelGame.add(PanneauJeu.finTour);
        PanneauJeu.finTour.setBounds(966, 659, 93, 92);
        
        //revalidate();
        //repaint();
        
        

        getContentPane().add(jPanelGame);
        jPanelGame.setBounds(0, 0, 1365, 768);
        globalcounter=2;

        jPanelCredits.setLayout(null);

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/thankyou.png"))); // NOI18N
        jPanelCredits.add(jLabel40);
        jLabel40.setBounds(560, 230, 240, 70);

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/soupi.png"))); // NOI18N
        jPanelCredits.add(jLabel41);
        jLabel41.setBounds(430, 410, 240, 70);

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/pash.png"))); // NOI18N
        jPanelCredits.add(jLabel42);
        jLabel42.setBounds(670, 410, 240, 70);

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/photo1.png"))); // NOI18N
        jPanelCredits.add(jLabel38);
        jLabel38.setBounds(130, 200, 220, 300);

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/photo2.png"))); // NOI18N
        jPanelCredits.add(jLabel39);
        jLabel39.setBounds(990, 200, 220, 300);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/photoram400.png"))); // NOI18N
        jLabel25.setText("jLabel20");
        jPanelCredits.add(jLabel25);
        jLabel25.setBounds(960, 150, 270, 410);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/photoram400.png"))); // NOI18N
        jLabel26.setText("jLabel20");
        jPanelCredits.add(jLabel26);
        jLabel26.setBounds(100, 160, 270, 390);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/return.png"))); // NOI18N
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton10MouseExited(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanelCredits.add(jButton10);
        jButton10.setBounds(560, 590, 240, 69);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/fire.gif"))); // NOI18N
        jPanelCredits.add(jLabel16);
        jLabel16.setBounds(390, 550, 150, 200);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/fire3.gif"))); // NOI18N
        jLabel17.setToolTipText("");
        jPanelCredits.add(jLabel17);
        jLabel17.setBounds(850, 550, 103, 194);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/back1365.jpg"))); // NOI18N
        jPanelCredits.add(jLabel18);
        jLabel18.setBounds(0, 0, 1365, 768);

        getContentPane().add(jPanelCredits);
        jPanelCredits.setBounds(0, 0, 1370, 770);
        globalcounter=1;

        jPanelLoading.setLayout(null);

        jLabel48.setFont(new java.awt.Font("LifeCraft", 0, 28)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("LOADING...");
        jLabel48.setToolTipText("");
        jPanelLoading.add(jLabel48);
        jLabel48.setBounds(600, 530, 150, 50);

        jLabel47.setFont(new java.awt.Font("LifeCraft", 0, 13)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/smallf.png"))); // NOI18N
        jLabel47.setToolTipText("");
        jPanelLoading.add(jLabel47);
        jLabel47.setBounds(560, 520, 240, 69);

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/fire.gif"))); // NOI18N
        jPanelLoading.add(jLabel43);
        jLabel43.setBounds(390, 550, 150, 200);

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/load.gif"))); // NOI18N
        jPanelLoading.add(jLabel46);
        jLabel46.setBounds(390, 110, 580, 400);

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/fire3.gif"))); // NOI18N
        jLabel44.setToolTipText("");
        jPanelLoading.add(jLabel44);
        jLabel44.setBounds(850, 550, 103, 194);

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/back1365l.jpg"))); // NOI18N
        jPanelLoading.add(jLabel45);
        jLabel45.setBounds(0, 0, 1365, 768);

        getContentPane().add(jPanelLoading);
        jPanelLoading.setBounds(0, 0, 1370, 770);

        jPanelGameDark.setMinimumSize(new java.awt.Dimension(1365, 768));
        jPanelGameDark.setLayout(null);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/savegame.png"))); // NOI18N
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton11MouseExited(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanelGameDark.add(jButton11);
        jButton11.setBounds(560, 230, 240, 69);

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/loadgame.png"))); // NOI18N
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton12MouseExited(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanelGameDark.add(jButton12);
        jButton12.setBounds(560, 320, 240, 69);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/exit.png"))); // NOI18N
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton13MouseExited(evt);
            }
        });
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanelGameDark.add(jButton13);
        jButton13.setBounds(560, 410, 240, 69);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/return.png"))); // NOI18N
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton14MouseExited(evt);
            }
        });
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
    /**
     * Petit menu de jeu
     */
        jPanelGameDark.add(jButton14);
        jButton14.setBounds(560, 500, 240, 69);

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/game-dark.jpg"))); // NOI18N
        jLabel37.setText("jLabel37");
        jPanelGameDark.add(jLabel37);
        jLabel37.setBounds(0, 0, 1365, 768);

        getContentPane().add(jPanelGameDark);
        jPanelGameDark.setBounds(0, 0, 1365, 768);

        jPanelHumWin.setLayout(null);

        jLabel51.setFont(new java.awt.Font("LifeCraft", 0, 36)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("YOU ARE");
        jLabel51.setToolTipText("");
        jPanelHumWin.add(jLabel51);
        jLabel51.setBounds(760, 180, 150, 50);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/mainmenu.png"))); // NOI18N
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton16MouseExited(evt);
            }
        });
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanelHumWin.add(jButton16);
        jButton16.setBounds(590, 480, 240, 69);

        jLabel58.setFont(new java.awt.Font("LifeCraft", 0, 36)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("WINNER!!!");
        jPanelHumWin.add(jLabel58);
        jLabel58.setBounds(780, 290, 140, 50);

        jLabel59.setText("jLabel56");
        jPanelHumWin.add(jLabel59);
        jLabel59.setBounds(780, 260, 53, 16);

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/fire.gif"))); // NOI18N
        jPanelHumWin.add(jLabel60);
        jLabel60.setBounds(390, 550, 150, 200);

        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/Sig3-1f7cff0.gif"))); // NOI18N
        jPanelHumWin.add(jLabel61);
        jLabel61.setBounds(420, 80, 310, 400);

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/fire3.gif"))); // NOI18N
        jLabel62.setToolTipText("");
        jPanelHumWin.add(jLabel62);
        jLabel62.setBounds(850, 550, 103, 194);

        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/back1365l.jpg"))); // NOI18N
        jPanelHumWin.add(jLabel63);
        jLabel63.setBounds(0, 0, 1365, 768);

        getContentPane().add(jPanelHumWin);
        jPanelHumWin.setBounds(0, 0, 1370, 770);

        jPanelHumDef.setLayout(null);

        jLabel50.setFont(new java.awt.Font("LifeCraft", 0, 48)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("YOU ARE");
        jLabel50.setToolTipText("");
        jPanelHumDef.add(jLabel50);
        jLabel50.setBounds(770, 230, 150, 50);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/mainmenu.png"))); // NOI18N
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton15MouseExited(evt);
            }
        });
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanelHumDef.add(jButton15);
        jButton15.setBounds(590, 480, 240, 69);

        jLabel57.setFont(new java.awt.Font("LifeCraft", 0, 48)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("DEFEATED!!!");
        jPanelHumDef.add(jLabel57);
        jLabel57.setBounds(750, 340, 220, 50);

        jLabel56.setText("jLabel56");
        jPanelHumDef.add(jLabel56);
        jLabel56.setBounds(780, 260, 53, 16);

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/fire.gif"))); // NOI18N
        jPanelHumDef.add(jLabel52);
        jLabel52.setBounds(390, 550, 150, 200);

        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/Tauren_Dancing.gif"))); // NOI18N
        jPanelHumDef.add(jLabel53);
        jLabel53.setBounds(410, 80, 310, 400);

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/fire3.gif"))); // NOI18N
        jLabel54.setToolTipText("");
        jPanelHumDef.add(jLabel54);
        jLabel54.setBounds(850, 550, 103, 194);

        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/back1365l.jpg"))); // NOI18N
        jPanelHumDef.add(jLabel55);
        jLabel55.setBounds(0, 0, 1365, 768);

        getContentPane().add(jPanelHumDef);
        jPanelHumDef.setBounds(0, 0, 1370, 770);

        jPanel1.setMinimumSize(new java.awt.Dimension(1365, 768));
        jPanel1.setPreferredSize(new java.awt.Dimension(1365, 768));
        jPanel1.setLayout(null);
        creationMap1.setLayout(null); //*************
        jPanel1.add(creationMap1);
        creationMap1.setBounds(0, 0, 1365, 768);

        jLabel36.setText("jLabel36");
        jPanel1.add(jLabel36);
        jLabel36.setBounds(0, 0, 53, 16);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1365, 768);

        creationMap2.setPreferredSize(new java.awt.Dimension(1365, 768));
        getContentPane().add(creationMap2);
        creationMap2.setLayout(null); //*************
        creationMap2.setBounds(0, 0, 1365, 768);

        pack();
    }// </editor-fold>                        
    /**
     * Animation des boutons
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/newgamelight.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/newgame.png")));
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/loadgamelight.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/loadgame.png")));
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/creditslight.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/credits.png")));
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/exitlight.png")));
        Sound pig = new Sound();

    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/exit.png")));

    }//GEN-LAST:event_jButton4MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        globalcounter=1;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelLoadGame); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        globalcounter=1;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelCredits); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        globalcounter=1;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelNewGame); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton1ActionPerformed
/**
 * Methode pour diriger bouton "Escape"
 */
    public void keyPressed(KeyEvent e){
        if((e.getKeyCode() == KeyEvent.VK_ESCAPE)&&(globalcounter==0)){
            if( e.getComponent() instanceof Window){
                ((Window)e.getComponent()).dispose();
                setVisible(false);
            }
        }
        else if ((e.getKeyCode() == KeyEvent.VK_ESCAPE)&&(globalcounter==1)){
        globalcounter=0;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelMain); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
        }
        else if ((e.getKeyCode() == KeyEvent.VK_ESCAPE)&&(globalcounter==2)){
        getContentPane().removeAll(); 
        getContentPane().add(jPanelGameDark); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
        }
        else if ((e.getKeyCode() == KeyEvent.VK_ESCAPE)&&(globalcounter==3)){
        globalcounter=1;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelNewGame); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
        }
        
    }
    

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/createlight.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/create.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton5MouseExited

    private void jButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MousePressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        globalcounter=3;
        getContentPane().removeAll(); 
        getContentPane().add(creationMap2); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void finTourMouseEntered(java.awt.event.MouseEvent evt) {                                        
        PanneauJeu.finTour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/turnlight.png")));
        Sound pig = new Sound();
        if(Heros.getnombre() == 0){
            System.out.println("Monstres on gagner");
            getContentPane().removeAll();
            getContentPane().add(jPanelHumDef);
            getContentPane().revalidate();
            getContentPane().repaint();
           
        }
        if(Monstre.getnombre() == 0){
            System.out.println("Heros on gagner");
            getContentPane().removeAll();
            getContentPane().add(jPanelHumWin);
            getContentPane().revalidate(); 
            getContentPane().repaint();
        }
        
    }                                       

    private void finTourMouseExited(java.awt.event.MouseEvent evt) {                                       
        PanneauJeu.finTour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/turn.png")));
    }
    
    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/randomlight.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/random.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton6MouseExited
    /**
    * Loading de jeu
    */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        globalcounter=2;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelLoading); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
        ActionListener action = new ActionListener()
        {   
            @Override
            public void actionPerformed(java.awt.event.ActionEvent event)
            {
                if(counter == 0)
                {
                    timer.stop();
                    getContentPane().removeAll(); 
                    getContentPane().add(jPanelGame); 
                    getContentPane().revalidate(); 
                    getContentPane().repaint();
                    
                }
                else
                {                   
                    counter--;
                }
            }
        };

        timer = new Timer(delay, action);
        timer.setInitialDelay(0);
        timer.start();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseEntered
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/returnlight.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton8MouseEntered

    private void jButton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseExited
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/return.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton8MouseExited
    /**
    * Connexions entre JPanels de menu
    */
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        globalcounter=0;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelMain); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton20MouseEntered
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/startlight.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton20MouseEntered

    private void jButton20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton20MouseExited
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/start.png")));
    }//GEN-LAST:event_jButton20MouseExited

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        globalcounter=0;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelMain); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        globalcounter=1;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelNewGame); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jPanelIntroVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jPanelIntroVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelIntroVetoableChange

    private void jButton25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton25MouseClicked
        globalcounter=1;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelTutorial); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton25MouseClicked

    private void jButton25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton25MouseEntered
        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/tutoriallight.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton25MouseEntered

    private void jButton25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton25MouseExited
        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/tutorial.png")));
    }//GEN-LAST:event_jButton25MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        globalcounter=1;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelCredits); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton26MouseClicked
        globalcounter=0;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelMain); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton26MouseClicked

    private void jButton26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton26MouseEntered
        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/returnlight.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton26MouseEntered

    private void jButton26MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton26MouseExited
        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/return.png")));
    }//GEN-LAST:event_jButton26MouseExited

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        globalcounter=0;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelMain); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        globalcounter=0;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelMain); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/returnlight.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton9MouseEntered

    private void jButton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseExited
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/return.png")));
    }//GEN-LAST:event_jButton9MouseExited

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        globalcounter=0;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelMain); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        globalcounter=0;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelMain); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseEntered
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/returnlight.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton10MouseEntered

    private void jButton10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseExited
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/return.png")));
    }//GEN-LAST:event_jButton10MouseExited

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        globalcounter=0;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelMain); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        globalcounter=1;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelLoadGame); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton21MouseEntered
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/returnlight.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton21MouseEntered

    private void jButton21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton21MouseExited
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/return.png")));
    }//GEN-LAST:event_jButton21MouseExited

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        globalcounter=1;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelNewGame); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        globalcounter=3;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelPreferences); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton21MouseClicked
        globalcounter=1;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelNewGame); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton21MouseClicked

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        jLabel33.setText(Integer.toString(jSlider1.getValue()));
    }//GEN-LAST:event_jSlider1StateChanged

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        jLabel34.setText(Integer.toString(jSlider2.getValue()));
    }//GEN-LAST:event_jSlider2StateChanged

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        globalcounter=1;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelTutorial); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton25ActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        save(panneauJeu1.carte);
    }//GEN-LAST:event_jButton11ActionPerformed
    
    
    private void jButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseEntered
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/returnlight.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton14MouseEntered

    private void jButton14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseExited
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/return.png")));
    }//GEN-LAST:event_jButton14MouseExited

    private void jButton13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseEntered
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/exitlight.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton13MouseEntered

    private void jButton13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseExited
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/exit.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton13MouseExited

    private void jButton12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseEntered
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/loadgamelight.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton12MouseEntered

    private void jButton12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseExited
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/loadgame.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton12MouseExited

    private void jButton11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseEntered
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/savegamelight.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton11MouseEntered

    private void jButton11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseExited
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/savegame.png")));
    }//GEN-LAST:event_jButton11MouseExited

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        globalcounter=2;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelGame);
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        globalcounter=0;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelMain); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        getContentPane().removeAll(); 
        getContentPane().add(jPanelGameDark); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/menuglight.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/menug.png")));
    }//GEN-LAST:event_jButton7MouseExited

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        globalcounter=2;
        getContentPane().removeAll(); 
        getContentPane().add(jPanelGame); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        Object[] options ={"Saved","Maps"};
        String defaut ="Saved";
        Object choix =JOptionPane.showInputDialog(
        null,
                "Voulez vous charger une Carte ou une Partie saved?\n",
                "type de chargement",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                defaut
        );
        String a=JOptionPane.showInputDialog(
        null,
        "Nom de carte ou sauvegarde\n",
        "Save ou map",
        1
        );
        File f = new File(choix+"/"+a+".txt");
        if(f.exists() && !f.isDirectory()){
            Heros.setnombre(0);
            Monstre.setnombre(0);
            PanneauJeu panneauJeu2=new PanneauJeu(a,(String)choix);
            panneauJeu1.carte=panneauJeu2.carte;
            //////////////////
            getContentPane().removeAll(); 
             getContentPane().add(jPanelGame); 
             getContentPane().revalidate(); 
             getContentPane().repaint();
             ////////////////////
            System.out.print("YPOOooo");
        }
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jPanelIntro2VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jPanelIntro2VetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelIntro2VetoableChange

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        getContentPane().removeAll(); 
        getContentPane().add(jPanelMain); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseEntered
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/mainmenu-light.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton15MouseEntered

    private void jButton15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseExited
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/mainmenu.png")));
    }//GEN-LAST:event_jButton15MouseExited

    private void jButton16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseEntered
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/mainmenu-light.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton16MouseEntered

    private void jButton16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseExited
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/mainmenu.png")));
    }//GEN-LAST:event_jButton16MouseExited

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        getContentPane().removeAll(); 
        getContentPane().add(jPanelMain); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        getContentPane().removeAll(); 
        getContentPane().add(jPanelHumDef); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        getContentPane().removeAll(); 
        getContentPane().add(jPanelHumWin); 
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }//GEN-LAST:event_jButton17ActionPerformed

    public void save(Carte c) {
        String a = JOptionPane.showInputDialog(
                null,
                "Le nom de votre Sauvegarde : \n" + "Sera sauvegarde dans le dossier Saved\n",
                "Save Name",
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
                map = new PrintWriter("Saved/sav_" + a + ".txt", "UTF-8");
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
        }
    }
    /**
     * Declaration des variables de menu
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private wargame.CreationMap creationMap1;
    private wargame.CreationMap creationMap2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCredits;
    private javax.swing.JPanel jPanelGame;
    public static  javax.swing.JPanel jPanelGameDark;
    public static javax.swing.JPanel jPanelHumDef;
    public static  javax.swing.JPanel jPanelHumWin;
    private javax.swing.JPanel jPanelIntro;
    private javax.swing.JPanel jPanelIntro2;
    private javax.swing.JPanel jPanelLoadGame;
    private javax.swing.JPanel jPanelLoading;
    public static javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelNewGame;
    private javax.swing.JPanel jPanelPreferences;
    private javax.swing.JPanel jPanelTutorial;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private wargame.PanneauJeu panneauJeu1;
    // End of variables declaration//GEN-END:variables

    private paneauInformation info=new paneauInformation();
}
