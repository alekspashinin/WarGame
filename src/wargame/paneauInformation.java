package wargame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class paneauInformation extends JPanel {

    private JLabel label= new JLabel("");;

    public paneauInformation() {

        setPreferredSize(new Dimension(0, 20));
        setBackground(Color.BLUE);
        setOpaque(true);
        label.setFont(new Font("LifeCraft", 0, 20));
        label.setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new GridBagLayout());
        add(label);
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void setMonLabel(String text) {
        label.setText(text);
    }
}
