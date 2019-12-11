package wargame;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Cette classe implmente la cration de tous les lments qui constituent la carte.
 * <p>
 * Chaque Element est compose d'un entier (oui... qui aurait du tre un boolean, mauvaises habitudes de C) pour l'occupation,
 * une Position pour qu'il sache ou il se trouve sur la carte et un hexagone compos de Points (Positions).
 *
 * @author Soupilas Dimitrios
 * @author Pashinin Aleksei
 */
public class Element implements IConfig {

    private int estOccupe;
    private Position pos;
    private List<Position> hexagone = new ArrayList<>();

    /**
     * Ce constructeur sert a construire un �l�ment "vide" puisque null existe pas en java.
     *
     * Il construit egalement l'Hexagone de cet Element.
     *
     * @param pos Position sur la carte.
     */
    public Element(Position pos) {
        this.estOccupe = 0;
        double constante = 1.154;
        this.pos = new Position(pos.getX(), pos.getY());

        if (pos.getY() % 2 == 0) {
            Hexagone(new Position((SettingsControl.getNB_PIX_CASE() / 2 + (pos.getX() * (SettingsControl.getNB_PIX_CASE() + (SettingsControl.getNB_PIX_CASE() / 2)))), (int) (((SettingsControl.getNB_PIX_CASE() / constante) / 2) + pos.getY() * (SettingsControl.getNB_PIX_CASE() / constante / 2))));
        } else {
            Hexagone(new Position((SettingsControl.getNB_PIX_CASE() + (SettingsControl.getNB_PIX_CASE() / 4) + (pos.getX() * (SettingsControl.getNB_PIX_CASE() + (SettingsControl.getNB_PIX_CASE() / 2)))), (int) (((SettingsControl.getNB_PIX_CASE() / constante) / 2) + pos.getY() * (SettingsControl.getNB_PIX_CASE() / constante / 2))));
        }


    }

    /**
     * Ce constructeur cre un lment mais avec le choix de contrler l'occupation.
     * <p>
     * Il sera utilise par le constructeur de la sous classe Soldat.
     *
     * @param pos Position sur la carte
     * @param i   Entier de l'occupation
     */
    public Element(Position pos, int i) {
        this.estOccupe = i;
        double constante = 1.154;
        this.pos = new Position(pos.getX(), pos.getY());
        if (pos.getY() % 2 == 0) {
            Hexagone(new Position((SettingsControl.getNB_PIX_CASE() / 2 + (pos.getX() * (SettingsControl.getNB_PIX_CASE() + (SettingsControl.getNB_PIX_CASE() / 2)))), (int) (((SettingsControl.getNB_PIX_CASE() / constante) / 2) + pos.getY() * (SettingsControl.getNB_PIX_CASE() / constante / 2))));
        } else {
            Hexagone(new Position((SettingsControl.getNB_PIX_CASE() + (SettingsControl.getNB_PIX_CASE() / 4) + (pos.getX() * (SettingsControl.getNB_PIX_CASE() + (SettingsControl.getNB_PIX_CASE() / 2)))), (int) (((SettingsControl.getNB_PIX_CASE() / constante) / 2) + pos.getY() * (SettingsControl.getNB_PIX_CASE() / constante / 2))));
        }

    }

    /*** Accesseurs ***/

    /**
     * Mthode pour vois si un ment est occupe.
     *
     * @return Boolen "true" si l'element est occupe et "false" sinon.
     */
    public boolean EstOccupe() {
        return (this.estOccupe != 0);
    }

    /**
     * M�thode pour trouver la Position de l'Element dans la carte.
     *
     * @return Position dans la carte.
     */
    public Position getPosition() {
        return this.pos;
    }

    /**
     * Mthode pour avoir l'hexagone d'un Element
     *
     * @return La Liste des Positions de l'hexagone de l'Element.
     */
    public List<Position> getHexagone() {
        return hexagone;
    }


    /*** Mutateurs ***/

    /**
     * Mthode pour changer l'occupation
     *
     * @param i Entier 1=true ou 0=false
     */
    public void setEstOccupe(int i) {
        this.estOccupe = i;
    }

    /**
     * Mthode pour changer la position d'un Element.
     *
     * @param p Position nouvelle.
     */
    public void setPosition(Position p) {
        this.pos.setX(p.getX());
        this.pos.setY(p.getY());
    }

    /**
     * Mthode pour changer l'Hexagone.
     * @param hexagone Nouveau hexagone.
     */
    public void setHexagone(List<Position> hexagone) {
        this.hexagone = hexagone;
    }

    /**
     * Mthode de cration de l'hexagone d'un Element.
     *
     * @param c Position du centre de l'hexagone.
     */
    public void Hexagone(Position c) {
        Position p = new Position(c.getX() + (SettingsControl.getNB_PIX_CASE() / 2), c.getY());
        Position d = new Position(0, 0);
        double r, a;
        d.setX(p.getX() - c.getX());
        d.setY(p.getY() - c.getY());
        r = Math.sqrt(Math.pow(d.getX(), 2) + Math.pow(d.getY(), 2));
        a = Math.atan2(d.getY(), d.getX());

        //List<Position> positions = new ArrayList<Position>();
        hexagone.add(p);
        for (int i = 1; i < 6; i++) {
            Position pos = new Position(0, 0);

            pos.setX((int) (c.getX() + r * Math.cos(a + i * 2 * Math.PI / 6)));
            pos.setY((int) (c.getY() + r * Math.sin(a + i * 2 * Math.PI / 6)));
            hexagone.add(pos);
        }

    }

    /**
     * Dessine un hexagone utilis pour les tests.
     *
     * @param g Graphics
     */
    public void dessinerHexagone(Graphics g) {
        Polygon p = new Polygon();
        for (int i = 0; i < hexagone.size(); i++) {
            p.addPoint(hexagone.get(i).getX(), hexagone.get(i).getY());
        }
        g.fillPolygon(p);
    }

    /**
     * Algorithme trouve sur Internet pour vrifier qu'un point se trouve dans un hexagone.
     *
     * @param pos Position que l'on vrifiera si elle se trouve dans l'hexagone.
     * @return Boolean "true" si dedans "false" sinon
     */
    public boolean dedans(Position pos) {
        int i, j;
        boolean b = false;
        for (i = 0, j = hexagone.size() - 1; i < hexagone.size(); j = i++) {
            if (((hexagone.get(i).getY() > pos.getY()) != (hexagone.get(j).getY() > pos.getY())) &&
                    (pos.getX() < (hexagone.get(j).getX() - hexagone.get(i).getX()) * (pos.getY() - hexagone.get(i).getY()) / (hexagone.get(j).getY() - hexagone.get(i).getY()) + hexagone.get(i).getX()))
                b = !b;
        }
        return b;
    }
}
	
	

