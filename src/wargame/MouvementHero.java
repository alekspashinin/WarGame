package wargame;

import java.util.List;

/**
 * Cette classe implemente le mouvement d'un Heros par l'utilisateur
 *
 * Il est compose d'un entier qui compte les occurrences d'un clic (lui aussi devais etre un boolean) et
 * de deux Positions (initiale / finale).
 *
 * @author Soupilas Dimitrios
 * @author Pashinin Aleksei
 */
public class MouvementHero implements IConfig{
    public int occurencesClick;
    public Position pos1;
    public Position pos2;

    /**
     * Le constructeur initialise juste les occurrences a 0;
     */
    public MouvementHero() {
        occurencesClick=0;
    }

    /**
     * Cette methode verifie et effectue les action de l'utilisateur.
     *
     * @param pP Position du click de l'utilisateur
     * @param carte La carte.
     * @return "true" si une action a ete accomplie, "false" sinon.
     */
    public boolean ActionMouvementHeros(Position pP,Carte carte){
        double constante = 1.154;

        /** aporximation de la position du click **/
        int x = pP.getX() / (SettingsControl.getNB_PIX_CASE() + (SettingsControl.getNB_PIX_CASE() / 2));
        int y = (int) (pP.getY() / (SettingsControl.getNB_PIX_CASE() / constante / 2));

        /**pour ne pas depacer la limite de la taille de la carte**/
        if (x==SettingsControl.getLARGEUR_CARTE()){
            x--;
        }
        if(y==SettingsControl.getHAUTEUR_CARTE()){
            y--;
        }
        Position p = new Position(x, y);
        if (p.estValide()) {
            /** liste contenant toutes les positions autour de notre position aproximative **/
            List<Position> pos = carte.trouvePositionHexagonal(p);
            boolean b;
            for (Position po : pos) {
                /** po sera notre position exacte si il est dans l'hexagone **/
                if (carte.getElement(po).dedans(pP)) {
                    if (occurencesClick % 2 == 0) {
                        pos1 = po;
                        occurencesClick++;
                        //selection de l'hero
                        if(carte.getElement(pos1) instanceof Heros){
                            ((Heros) carte.getElement(pos1)).setSelected(true);
                        }
                        //System.out.println("pos1 : x : " + pos1.getX() + " y : " + pos1.getY());
                        return true;

                    } else {
                        pos2 = po;
                        occurencesClick = 0;
                        //deselection de l'hero
                        if(carte.getElement(pos1) instanceof Heros){
                            ((Heros) carte.getElement(pos1)).setSelected(false);
                        }
                        carte.actionHeros(pos1, pos2);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

