/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;


import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static wargame.PanneauJeu.finTour;

/**
 *
 * @author alekspashinin
 */
public class JPanelStartGame extends javax.swing.JPanel {

    /**
     * Creates new form JPanelStartGame
     */
    public JPanelStartGame() {
        System.out.print("YPOOooo1");
        initComponents();
        System.out.print("YPOOooo2");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jButton111 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1365, 768));
        setPreferredSize(new java.awt.Dimension(1365, 768));
        setLayout(null);

        jLabel112.setBounds(new java.awt.Rectangle(0, 0, 1000, 768));
        add(jLabel112);
        jLabel112.setBounds(0, 0, 920, 768);

        jLabel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/colon.png"))); // NOI18N
        jLabel113.setBounds(new java.awt.Rectangle(1050, 0, 323, 768));
        add(jLabel113);
        jLabel113.setBounds(1050, 0, 323, 789);

        jLabel111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/backjeu.png"))); // NOI18N
        jLabel111.setSize(new java.awt.Dimension(1365, 768));
        add(jLabel111);
        jLabel111.setBounds(0, 0, 1365, 768);
        panneauJeu1 = new wargame.PanneauJeu();

        panneauJeu1.setPreferredSize(new java.awt.Dimension(1365, 768));
        jLabel112.add(panneauJeu1);
        panneauJeu1.setBounds(0, 0, 1000, SettingsControl.getHEIGHT_PAGE());
        panneauJeu1.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                double constante = 1.154;
                int x = e.getX() / (SettingsControl.getNB_PIX_CASE() + (SettingsControl.getNB_PIX_CASE() / 2));
                int y = (int) (e.getY() / (SettingsControl.getNB_PIX_CASE() / constante / 2));
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

        jButton111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/menug.png"))); // NOI18N
        jButton111.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton111MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton111MouseExited(evt);
            }
        });
        jButton111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton111ActionPerformed(evt);
            }
        });
        add(jButton111);
        jButton111.setBounds(960, 12, 93, 92);
        add(PanneauJeu.finTour);
        PanneauJeu.finTour.setBounds(966, 659, 93, 92);

        PanneauJeu.finTour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/Images/turn.png"))); // NOI18N
        PanneauJeu.finTour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                finTourMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                finTourMouseExited(evt);
            }
        });
        revalidate();
        repaint();
    }// </editor-fold>//GEN-END:initComponents
      
    
    private void finTourMouseEntered(java.awt.event.MouseEvent evt) {                                        
        PanneauJeu.finTour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/turnlight.png")));
        Sound pig = new Sound();
    }                                       

    private void finTourMouseExited(java.awt.event.MouseEvent evt) {                                       
        PanneauJeu.finTour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/turn.png")));
    }
    
    
    
    
    
    private void jButton111MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton111MouseEntered
        jButton111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/menuglight.png")));
        Sound pig = new Sound();
    }//GEN-LAST:event_jButton111MouseEntered

    private void jButton111MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton111MouseExited
        jButton111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wargame/images/menug.png")));
    }//GEN-LAST:event_jButton111MouseExited

    private void jButton111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton111ActionPerformed
        removeAll(); 
        add(WarFrame.jPanelGameDark); 
        revalidate(); 
        repaint();
    }//GEN-LAST:event_jButton111ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton111;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    // End of variables declaration//GEN-END:variables
    private wargame.PanneauJeu panneauJeu1;
    private paneauInformation info=new paneauInformation();
}