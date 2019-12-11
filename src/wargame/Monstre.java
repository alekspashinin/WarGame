package wargame;


import java.awt.*;

/**
 * Cette classe implemente les Monstres qui serons sur la carte.
 * <p>
 * Elle extend la classe Soldat.
 * Elle est compose d'un entier static (nombre de Monstres) et d'un entier ( numero de ce Monstre).
 *
 * @author Soupilas Dimitrios
 * @author Pashinin Aleksei
 */
public class Monstre extends Soldat {
    private static int nbrMonstres = 0;
    private int numMonstre;

    /**
     * Ce constructeur appel le constructeur de son pere (Soldats) en precisant qu'il s'agit d'un Monstre.
     *
     * @param genreMonstre Type de Monstre (ORC, TROLL, GOBLIN).
     * @param pos          Position dans la carte.
     */

    public Monstre(TypesM genreMonstre, Position pos) {
        super(pos, genreMonstre.getPoints(), genreMonstre.getPortee(), genreMonstre.getPuissance(), genreMonstre.getTir(), genreMonstre.name());
        nbrMonstres++;
        numMonstre = nbrMonstres;
    }

    /**
     * M�thode pour avoir le num�ro du Monstre.
     *
     * @return Num�ro du Monstre.
     */
    @Override
    public int getnum() {
        return numMonstre;
    }

    public static int getnombre(){return nbrMonstres;}

    public static void setnombre(int nvNombre){Monstre.nbrMonstres=nvNombre;}

    @Override
    public void dessiner(Graphics g, int x, int y) {
        g.setColor(COULEUR_MONSTRES);
    }
}
