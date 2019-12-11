package wargame;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Cette class implémente les Soldats.
 * <p>
 * Elle est constitue du nom des soldate, de ses points, de ses points maximaux, de sa portée visuelle,
 * de la puissance de ses tirs, de la portée de ses tirs, d'un boolean pour vérifier s'il a jouer
 * et d'un boolean pour vérifier s'il est sélectionné (utilise dans la class Carte méthode dessineTout()).
 *
 * @author Soupilas Dimitrios
 * @author Pashinin Aleksei
 */
public abstract class Soldat extends Element implements ISoldat {

    private String type;
    private int points;
    private int pointsMax;
    private int portee;
    private int puissance;
    private int tir;
    private boolean tour;
    private boolean selected;

    public Soldat(Position pos, int points, int portee, int puissance, int tir, String type) {
        super(pos, 1);
        this.type = type;
        this.points = points;
        this.pointsMax = points;
        this.portee = portee;
        this.puissance = puissance;
        this.tir = tir;
        tour = false;
        selected = false;
    }


    public boolean estVivant() {
        return this.points > 0;
        // ^ true si le soldat est vivant false sinon
    }

    // Accesseurs

    @Override
    public int getPoints() {
        return points;
    }

    public int getPointsMax() {
        return pointsMax;
    }

    @Override
    public boolean getTour() {
        return tour;
    }

    @Override
    public int getPortee() {
        return portee;
    }

    public int getPuissance() {
        return puissance;
    }

    public int getTir() {
        return tir;
    }

    public String getType() {
        return type;
    }

    public boolean getSelected() {
        return selected;
    }


    // Mutateurs

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public void joueTour(boolean b) {
        this.tour = b;
    }

    public void setSelected(boolean b) {
        this.selected = b;
    }

    @Override
    public boolean distanceCombat(Soldat soldat) {
        return Math.abs(getPosition().getX() - soldat.getPosition().getX()) <= getTir() &&
                Math.abs(getPosition().getY() - soldat.getPosition().getY()) <= getTir();
    }


    public List<Position> intervalTir() {
        List<Position> Coordones = new ArrayList<Position>();
        int xMin, xMax;
        int yMin, yMax;
        int tir = this.getTir();

        if (tir == 0) {
            tir = 1;
        }
        yMax = this.getPosition().getY() + (2 * tir);
        yMin = this.getPosition().getY() - (2 * tir);
        if (this.getPosition().getY() % 2 == 0) {
            if (tir % 2 == 0) {
                xMax = this.getPosition().getX() + tir / 2;
                xMin = this.getPosition().getX() - tir / 2;
            } else {
                xMax = this.getPosition().getX() + (tir / 2);
                xMin = this.getPosition().getX() - (tir / 2)-1;
            }
        } else {
            if (tir % 2 == 0) {
                xMax = this.getPosition().getX() + (tir / 2);
                xMin = this.getPosition().getX() - (tir / 2);
            } else {
                xMax = this.getPosition().getX() + (tir / 2) + 1;
                xMin = this.getPosition().getX() - (tir / 2);
            }
        }
        Coordones.add(new Position(xMin, yMin));
        Coordones.add(new Position(xMax, yMax));
        return Coordones;

    }

    @Override
    public boolean combat(Soldat soldat) {
        List<Position> c1 = intervalTir();
        List<Position> c2 = soldat.intervalTir();
        if (soldat.getPosition().getX() >= c1.get(0).getX() && soldat.getPosition().getX() <= c1.get(1).getX()
                && soldat.getPosition().getY() >= c1.get(0).getY() && soldat.getPosition().getY() <= c1.get(1).getY()) {

            soldat.setPoints(soldat.getPoints() - new Random().nextInt(this.getPuissance() + 1));

            if (soldat.getPoints() > 0 && this.getPosition().getX() >= c2.get(0).getX() && this.getPosition().getX() <= c2.get(1).getX()
                    && this.getPosition().getY() >= c2.get(0).getY() && this.getPosition().getY() <= c2.get(1).getY())
                this.setPoints(this.getPoints() - new Random().nextInt(soldat.getPuissance() + 1));

            //System.out.println("Points sol1 : " + this.getPoints() + " Points sol2 : " + soldat.getPoints());
            joueTour(true);
            return true;
        }
        return false;
    }


    public boolean enemy(Soldat soldat) {
        return ((this instanceof Heros && soldat instanceof Monstre) || (this instanceof Monstre && soldat instanceof Heros));
    }

    @Override
    public void seDeplace(Position newPos) {
        setPosition(newPos);
    }

    public void healing() {
        if (this.points < this.pointsMax) {
            setPoints(this.points + 1);
        }
    }


}
