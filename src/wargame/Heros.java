package wargame;


import java.awt.*;

/**
 * Cette classe implmente les Hros qui serons sur la carte.
 * <p>
 * Elle extend la classe Soldat.
 * Elle est compose d'un entier static (nombre d'heros) et d'un entier ( numro de cet Heros).
 *
 * @author Soupilas Dimitrios
 * @author Pashinin Aleksei
 */
public class Heros extends Soldat {
    private static int nbrHeros = 0;
    private int numHero;

    /**
     * Ce constructeur appel le constructeur de son pere (Soldats) en precisant qu'il s'agit d'un Heros.
     *
     * @param genreHeros Type d' Heros (ELF, HUMAIN, NAIN, HOBBIT).
     * @param pos        Position dans la carte.
     */
    public Heros(TypesH genreHeros, Position pos) {
        super(pos, genreHeros.getPoints(), genreHeros.getPortee(), genreHeros.getPuissance(), genreHeros.getTir(), genreHeros.name());
        nbrHeros++;
        numHero = nbrHeros;
    }

    /**
     * Methode pour avoir le numero de l'Heros
     *
     * @return Numero de l'heros.
     */
    @Override
    public int getnum() {
        return numHero;
    }

    public static int getnombre(){return nbrHeros;}

    public static void setnombre(int nvNombre){Heros.nbrHeros=nvNombre;}
    //not used
    @Override
    public void dessiner(Graphics g, int x, int y) {
        g.setColor(COULEUR_HEROS);
    }

}
