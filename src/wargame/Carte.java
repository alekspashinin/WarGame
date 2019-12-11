package wargame;


import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;



/**
 * Cette classe implemente la construction d'une carte et divers manipulations dessus.
 * <p>
 * Une carte est constitue d'un tableau d'Elements et une classe ImagesJeux qui contient toutes les images.
 *
 * @author Soupilas Dimitrios
 * @author Pashinin Aleksei
 */
public class Carte implements ICarte, IConfig{

    public Element[][] carte;
    /***IMAGES**/
    public ImagesJeux images;

    /**
     * Ce constructeur cree une carte "vierge" ne contenant que des Elements vides.
     */
    public Carte() {
        //initialisation des images
        images = new ImagesJeux();

        carte = new Element[SettingsControl.getLARGEUR_CARTE()][SettingsControl.getHAUTEUR_CARTE()];
        for (int i = 0; i < SettingsControl.getLARGEUR_CARTE(); i++) {
            for (int j = 0; j < SettingsControl.getHAUTEUR_CARTE(); j++) {
                carte[i][j] = new Element(new Position(i, j));
                // ^ remplissage avec des elements vides
            }
        }
    }

    /**
     * Ce constructeur cree une carte a partir d'un fichier pris en parametre.
     * <p>
     * Elle modifie egalement settings generales de la largeur et la hauteur de la carte.
     * Elle peut prendre soit une Carte "vierge" (ne contenant pas de soldats) soit une carte "prete"
     * Elle verifie l'existance de Heros et de Monstres et les ajoutera en cas de Carte "vierge"
     *
     * @param nomFichier String du nom de fichier de la carte a charger
     * @param dossier    String du nom du dossier ou ce trouve la carte. Maps ou Saved
     */
    public Carte(String nomFichier, String dossier) {
        //j aurai aimer appeler this() mais il est possible que a la fin de la ligne ce qui
        //est perturbant puisque la largeur et hauteur doivent êtres changés dépendant de la map
        images = new ImagesJeux();
        try {
            BufferedReader in = new BufferedReader(new FileReader(dossier + "/" + nomFichier + ".txt"));
            int type;
            int points;
            SettingsControl.setLARGEUR_CARTE(Integer.parseInt(in.readLine()));
            SettingsControl.setHAUTEUR_CARTE(Integer.parseInt(in.readLine()));
            carte = new Element[SettingsControl.getLARGEUR_CARTE()][SettingsControl.getHAUTEUR_CARTE()];
            for (int i = 0; i < SettingsControl.getLARGEUR_CARTE(); i++) {
                for (int j = 0; j < SettingsControl.getHAUTEUR_CARTE(); j++) {
                    type = Integer.parseInt(in.readLine());
                    carte[i][j] = new Element(new Position(i, j));
                    switch (type) {
                        case 1:
                            //foret
                            ajouterElement(new Obstacle(Obstacle.TypeObstacle.FORET, new Position(i, j)));
                            break;
                        case 2:
                            //eau
                            ajouterElement(new Obstacle(Obstacle.TypeObstacle.EAU, new Position(i, j)));
                            break;
                        case 3:
                            //rocher
                            ajouterElement(new Obstacle(Obstacle.TypeObstacle.ROCHER, new Position(i, j)));
                            break;
                        case 4:
                            //troll
                            ajouterElement(new Monstre(Monstre.TypesM.TROLL, new Position(i, j)));
                            points = Integer.parseInt(in.readLine());
                            ((Soldat) getElement(new Position(i, j))).setPoints(points);
                            break;
                        case 5:
                            //goblin
                            ajouterElement(new Monstre(Monstre.TypesM.GOBELIN, new Position(i, j)));
                            points = Integer.parseInt(in.readLine());
                            ((Soldat) getElement(new Position(i, j))).setPoints(points);
                            break;
                        case 6:
                            //orc
                            ajouterElement(new Monstre(Monstre.TypesM.ORC, new Position(i, j)));
                            points = Integer.parseInt(in.readLine());
                            ((Soldat) getElement(new Position(i, j))).setPoints(points);
                            break;
                        case 7:
                            //nain
                            ajouterElement(new Heros(Heros.TypesH.NAIN, new Position(i, j)));
                            points = Integer.parseInt(in.readLine());
                            ((Soldat) getElement(new Position(i, j))).setPoints(points);
                            break;
                        case 8:
                            //hobbit
                            ajouterElement(new Heros(Heros.TypesH.HOBBIT, new Position(i, j)));
                            points = Integer.parseInt(in.readLine());
                            ((Soldat) getElement(new Position(i, j))).setPoints(points);
                            break;

                        case 9:
                            //humain
                            ajouterElement(new Heros(Heros.TypesH.HUMAIN, new Position(i, j)));
                            System.out.println("HUMAAN");
                            points = Integer.parseInt(in.readLine());
                            ((Soldat) getElement(new Position(i, j))).setPoints(points);
                            break;
                        case 10:
                            //elf
                            ajouterElement(new Heros(Heros.TypesH.ELF, new Position(i, j)));
                            points = Integer.parseInt(in.readLine());
                            ((Soldat) getElement(new Position(i, j))).setPoints(points);
                            break;
                        default:
                            //vide
                            ajouterElement(new Element(new Position(i, j)));
                            break;
                    }
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println("ERREUR CHARGEMENT MAP");
        }

        //add Soldats if they dont exist

        if (Heros.getnombre() == 0) {
            ajoutHeros(SettingsControl.getNB_HEROS());
        }
        if (Monstre.getnombre() == 0) {
            ajoutMonstre(SettingsControl.getNB_MONSTRES());
        }


    }

    /**
     * @return True si il existe au
     */
    public boolean existeHeros() {
        boolean b = false;
        for (int i = 0; i < SettingsControl.getLARGEUR_CARTE(); i++) {
            for (int j = 0; j < SettingsControl.getHAUTEUR_CARTE(); j++) {
                if (getElement(new Position(i, j)) instanceof Heros) {
                    b = true;
                }
            }

        }
        return b;
    }

    /**
     * Cette methode retourne l'element qui se trouve à la position donnee en argument.
     *
     * @param pos Position de l'element que l'on veut retourner.
     * @return Element
     */
    @Override
    public Element getElement(Position pos) {
        return this.carte[pos.getX()][pos.getY()];
    }


    /**
     * Cette methode trouve et retourne une position vide aleatoire dans la Carte
     *
     * @return Position
     */

    @Override
    public Position trouvePositionVide() {
        // Creation d'une liste qui va contenir tout les positions vides de la carte
        List<Position> pos = new ArrayList<Position>();
        for (int i = 0; i < SettingsControl.getLARGEUR_CARTE(); i++) {
            for (int j = 0; j < SettingsControl.getHAUTEUR_CARTE(); j++) {
                // Ajout de tous les Heros dans cette liste
                if (!this.carte[i][j].EstOccupe())
                    pos.add(new Position(i, j));
            }
        }
        // Si la liste est vide (s'il existe donc pas de positions vides retour null)
        // Verification devra etre faite lors de l'appel de la fonction affin de
        // verifier le retour null
        if (pos.isEmpty())
            return null;
        else {
            // Sinon choix alleatoir parmis les positions vides trouves
            int choix = new Random().nextInt(pos.size());
            return pos.get(choix);
        }
    }

    //method not used due to hexagonal map
    @Override
    public Position trouvePositionVide(Position pos) {
        // Creation d'une liste qui va contenir tout les positions vides de la carte
        List<Position> posi = new ArrayList<Position>();
        int x = 0, y = 0;
        if ((pos.getX() - 1) > 0) {
            x = pos.getX() - 1;
        }
        if ((pos.getY() - 1) > 0) {
            y = pos.getY() - 1;
        }
        for (int i = x; i < SettingsControl.getLARGEUR_CARTE() && i <= (pos.getX() + 1); i++) {
            for (int j = y; j < SettingsControl.getHAUTEUR_CARTE() && j <= (pos.getY() + 1); j++) {
                // Ajout de tous les Heros dans cette liste
                if (!this.carte[i][j].EstOccupe())
                    posi.add(new Position(i, j));
            }
        }
        // Si la liste est vide (s'il existe donc pas de positions vides retour null)
        // Verification devra etre faite lors de l'appel de la fonction affin de
        // verifier le retour null
        if (posi.isEmpty())
            return null;
        else {
            // Sinon choix alleatoir parmis les positions vides trouves
            int choix = new Random().nextInt(posi.size());
            return posi.get(choix);
        }
    }

    /**
     * Cette methode trouve et retourne une position aleatoire vide voisine d'une position prise en argument sur une carte hexagonale.
     *
     * @param pos Position
     * @return Position
     */
    public Position trouvePositionVideHexagonal(Position pos) {
        List<Position> posi = new ArrayList<Position>();

        //y+1
        if (new Position(pos.getX(), pos.getY() + 1).estValide()) {
            if (!carte[pos.getX()][pos.getY() + 1].EstOccupe())

                posi.add(new Position(pos.getX(), pos.getY() + 1));
        }

        //y-1
        if (new Position(pos.getX(), pos.getY() - 1).estValide()) {
            if (!carte[pos.getX()][pos.getY() - 1].EstOccupe())
                posi.add(new Position(pos.getX(), pos.getY() - 1));
        }
        //y+2
        if (new Position(pos.getX(), pos.getY() + 2).estValide()) {
            if (!carte[pos.getX()][pos.getY() + 2].EstOccupe())
                posi.add(new Position(pos.getX(), pos.getY() + 2));
        }
        //y-2
        if (new Position(pos.getX(), pos.getY() - 2).estValide()) {
            if (!carte[pos.getX()][pos.getY() - 2].EstOccupe())
                posi.add(new Position(pos.getX(), pos.getY() - 2));
        }
        //cas particulier
        if (pos.getY() % 2 == 0) {
            //x-1,y-1
            if (new Position(pos.getX() - 1, pos.getY() - 1).estValide()) {
                if (!carte[pos.getX() - 1][pos.getY() - 1].EstOccupe())
                    posi.add(new Position(pos.getX() - 1, pos.getY() - 1));
            }
            //x-1,y+1
            if (new Position(pos.getX() - 1, pos.getY() + 1).estValide()) {
                if (!carte[pos.getX() - 1][pos.getY() + 1].EstOccupe())
                    posi.add(new Position(pos.getX() - 1, pos.getY() + 1));
            }
        } else {

            //x+1,y-1
            if (new Position(pos.getX() + 1, pos.getY() - 1).estValide()) {
                if (!carte[pos.getX() + 1][pos.getY() - 1].EstOccupe())
                    posi.add(new Position(pos.getX() + 1, pos.getY() - 1));
            }
            //x+1,y+1
            if (new Position(pos.getX() + 1, pos.getY() + 1).estValide()) {
                if (!carte[pos.getX() + 1][pos.getY() + 1].EstOccupe())
                    posi.add(new Position(pos.getX() + 1, pos.getY() + 1));
            }
        }
        if (posi.isEmpty())
            return null;
        else {
            // Sinon choix alleatoir parmis les positions vides trouves
            int choix = new Random().nextInt(posi.size());
            //System.out.println(choix+" "+posi.size());

            return posi.get(choix);
        }

    }

    /**
     * Cette methode retourne la a liste des position autour d'un point.
     * <p>
     * Affin de s'assurer que nous sommes bien sur le bon point en carte hexagonale.
     * Elle va etre utilisee afin de verifier si le click se trouve bien dans l'hexagone de pos ou dans ses voisin.
     *
     * @param pos Position
     * @return Liste de Positions
     */
    public List<Position> trouvePositionHexagonal(Position pos) {
        List<Position> posi = new ArrayList<Position>();
        posi.add(pos);

        //y+1
        if (new Position(pos.getX(), pos.getY() + 1).estValide())
            posi.add(new Position(pos.getX(), pos.getY() + 1));

        //y-1
        if (new Position(pos.getX(), pos.getY() - 1).estValide())
            posi.add(new Position(pos.getX(), pos.getY() - 1));

        //y+2
        if (new Position(pos.getX(), pos.getY() + 2).estValide())
            posi.add(new Position(pos.getX(), pos.getY() + 2));

        //y-2
        if (new Position(pos.getX(), pos.getY() - 2).estValide())
            posi.add(new Position(pos.getX(), pos.getY() - 2));

        //cas particulier
        if (pos.getY() % 2 == 0) {
            //x-1,y-1
            if (new Position(pos.getX() - 1, pos.getY() + -1).estValide())
                posi.add(new Position(pos.getX() - 1, pos.getY() - 1));

            //x-1,y+1
            if (new Position(pos.getX() - 1, pos.getY() + 1).estValide())
                posi.add(new Position(pos.getX() - 1, pos.getY() + 1));
        } else {

            //x+1,y-1
            if (new Position(pos.getX() + 1, pos.getY() - 1).estValide())
                posi.add(new Position(pos.getX() + 1, pos.getY() - 1));

            //x+1,y+1
            if (new Position(pos.getX() + 1, pos.getY() + 1).estValide())
                posi.add(new Position(pos.getX() + 1, pos.getY() + 1));
        }
        return posi;
    }

    /**
     * Cette methode trouve et retourne un Heros aleatoire de la carte.
     *
     * @return Heros
     */
    @Override
    public Heros trouveHeros() {
        // Creation d'une liste qui va contenir tout les heros de la carte
        List<Heros> hero = new ArrayList<Heros>();
        for (int i = 0; i < SettingsControl.getLARGEUR_CARTE(); i++) {
            for (int j = 0; j < SettingsControl.getHAUTEUR_CARTE(); j++) {
                // Ajout de tous les Heros dans cette liste
                if (this.carte[i][j] instanceof Heros)
                    hero.add((Heros) this.carte[i][j]);
            }
        }
        // Si la liste est vide (s'il existe donc pas de heros retour null)
        // Verification devra etre faite lors de l'appel de la fonction affin de
        // verifier le retour null
        if (hero.isEmpty())
            return null;
        else {
            // Sinon choix alleatoir parmis les heros trouves
            int choix = new Random().nextInt(hero.size());
            return hero.get(choix);
        }

    }

    //not used due to hexagonal map
    @Override
    public Heros trouveHeros(Position pos) {
        // Creation d'une liste qui va contenir tout les heros de la carte dans
        // l'interval demande
        List<Heros> hero = new ArrayList<Heros>();
        int x = 0, y = 0;
        if ((pos.getX() - 1) > 0) {
            x = pos.getX() - 1;
        }
        if ((pos.getY() - 1) > 0) {
            y = pos.getY() - 1;
        }
        for (int i = x; i < SettingsControl.getLARGEUR_CARTE() && i <= (pos.getX() + 1); i++) {
            for (int j = y; j < SettingsControl.getHAUTEUR_CARTE() && j <= (pos.getY() + 1); j++) {
                // Ajout de tous les Heros dans cette liste
                if (this.carte[i][j] instanceof Heros)
                    hero.add((Heros) this.carte[i][j]);
            }
        }
        // Si la liste est vide (s'il existe donc pas de heros retour null)
        // Verification devra etre faite lors de l'appel de la fonction affin de
        // verifier le retour null
        if (hero.isEmpty())
            return null;
        else {
            // Sinon choix alleatoir parmis les heros trouves
            int choix = new Random().nextInt(hero.size());
            return hero.get(choix);
        }
    }

    //not used due to hexagonal map
    public Heros trouveHerosAPortee(Soldat soldat) {
        // Creation d'une liste qui va contenir tout les heros de la carte dans
        // l'interval demande
        List<Heros> hero = new ArrayList<Heros>();
        int x = 0, y = 0;
        if ((soldat.getPosition().getX() - 1 - soldat.getTir()) > 0) {
            x = (soldat.getPosition().getX() - 1 - soldat.getTir());
        }
        if ((soldat.getPosition().getY() - 1 - soldat.getTir()) > 0) {
            y = (soldat.getPosition().getY() - 1 - soldat.getTir());
        }
        for (int i = x; i < SettingsControl.getLARGEUR_CARTE() && i <= (soldat.getPosition().getX() + 1 + soldat.getTir()); i++) {
            for (int j = y; j < SettingsControl.getHAUTEUR_CARTE() && j <= (soldat.getPosition().getY() + 1 + soldat.getTir()); j++) {
                // Ajout de tous les Heros dans cette liste
                if (soldat.enemy((Soldat) this.carte[i][j]))
                    hero.add((Heros) this.carte[i][j]);
            }
        }
        // Si la liste est vide (s'il existe donc pas de heros retour null)
        // Verification devra etre faite lors de l'appel de la fonction affin de
        // verifier le retour null
        if (hero.isEmpty())
            return null;
        else {
            // Sinon choix alleatoir parmis les heros trouves
            int choix = new Random().nextInt(hero.size());
            return hero.get(choix);
        }
    }

    /**
     * Cette methode ajoute un Element pris en parametre dans la Carte.
     *
     * @param elem Element
     */
    @Override
    public void ajouterElement(Element elem) {
        if (elem.getPosition().estValide()) {
            carte[elem.getPosition().getX()][elem.getPosition().getY()] = elem;
        }
    }

    /**
     * Cette methode deplace un Soldat donne en argument à une Position donnee en argument.
     *
     * @param pos    Position
     * @param soldat Soldat
     * @return boolean Retourne "true" su le deplacement a bien ete effectue et "false" sinon.
     */
    @Override
    public boolean deplaceSoldat(Position pos, Soldat soldat) {
        if (!this.carte[pos.getX()][pos.getY()].EstOccupe() || !pos.estValide()) {
            this.carte[soldat.getPosition().getX()][soldat.getPosition().getY()] = new Element(soldat.getPosition());
            soldat.seDeplace(pos);
            soldat.setHexagone(this.carte[pos.getX()][pos.getY()].getHexagone());
            this.carte[soldat.getPosition().getX()][soldat.getPosition().getY()] = soldat;
            return true;
        }
        return false;

    }

    /**
     * Cette methode effectue un combat entre deux Soldats pris en argument.
     * <p>
     * Le combat consiste a un coup (direct ou a distance) du "premier" et un coup du "deuxieme" (direct ou a distance).
     * Le combat est considere valide même si le "deuxieme" ne peut pas repondre.
     *
     * @param premier  Soldat
     * @param deuxieme Soldat
     * @return boolean
     */
    @Override
    public boolean combatSoldat(Soldat premier, Soldat deuxieme) {
        // vérification que les deux combattants ne sont pas dumêmee type
        if (!premier.enemy(deuxieme)) {
            System.out.println("Dont fight each other ur on the same fucking team");
            // metre un son d erreur?
            return false;
        }
        boolean b = premier.combat(deuxieme);

        if (!premier.estVivant()) {
            this.mort(premier);
            //change tour
        }
        if (!deuxieme.estVivant()) {
            this.mort(deuxieme);
        }
        return b;
        //retourne vrai si un combat a ue lieu false sinon
    }

    /**
     * Cette methode tue un Soldat pris en parametre.
     * <p>
     * Remplace donc sa place dans la carte par une place vide.
     * Egalement diminue le nombre general de soldats du meme type.
     *
     * @param soldat Soldat a tuer.
     */
    @Override
    public void mort(Soldat soldat) {
        // perso.setPoints(0);
        Position pos = soldat.getPosition();
        //si soldat est un Herps le nombre de Heros general diminu
        if (soldat instanceof Heros) {
            Heros.setnombre(Heros.getnombre() - 1);
        } else {
            //si soldat est un Monstre le nombre de Monstre general diminu
            Monstre.setnombre(Monstre.getnombre() - 1);
        }
        System.out.println("NOOOMBRE:" + Heros.getnombre());
        this.carte[pos.getX()][pos.getY()] = new Element(pos);
    }

    /**
     * @param pos Position
     * @return boolean Retourne "true" si à la position prise en parametre se trouve un Heros, "false" sinon.
     */
    @Override
    public boolean estHeros(Position pos) {
        return carte[pos.getX()][pos.getY()] instanceof Heros;
        //retourne vrai si la position est un Heros

    }

    /**
     * @param pos Position
     * @return boolean Retourne "true" si a la position prise en paramètre se trouve un Obstacle, "false" sinon.
     */
    @Override
    public boolean estObstacle(Position pos) {
        return carte[pos.getX()][pos.getY()] instanceof Obstacle;
        //retourn vrai si la position est un obstacle
    }

    /**
     * Cette methode orchestre tout le jeu des Heros par l'utilisateur.
     * <p>
     * Elle verifie que les Positions prisent en argument sont bien valides,
     * que la premiere correspond bien a celle d'un Heros et que la deuxieme n'est pas un Obstacle.
     * Elle effectue un combat si a la pos2 se trouve un ennemi qui est a distance de tir,
     * ou un deplacement si la pos2 est voisine et vide.
     *
     * @param pos  Position initiale
     * @param pos2 Position finale
     * @return boolean retournera "true" si une action a ete accomplie et "false" sinon.
     */
    @Override
    public boolean actionHeros(Position pos, Position pos2) {

        //false si positions pas valides
        if (!pos.estValide() || !pos2.estValide()) {
            System.out.println("UNE POS NON VALIDE");
            return false;
        }
        //false si il ne s agit pas d'un hero ou si la position d'arrivee (pos2) est un obstacle
        if (!estHeros(pos) || estObstacle(pos2)) {
            System.out.println("NON HEROS OU OBSTACLE");
            return false;
        }
        //verification si le soldat a deja jouer
        if (((Soldat) getElement(pos)).getTour() != false) {
            System.out.println("ACTION DEJA EFFECTUE");
            return false;
        }
        //retour du combat si la position n'est pas voisine car il peu y avoir combat a distance
        if (!pos.estVoisineHexagonale(pos2)) {
            System.out.println("NON VOISINE HEXAGONALE");
            if (carte[pos2.getX()][pos2.getY()] instanceof Soldat) {
                System.out.println("COMBAT1");
                return combatSoldat((Soldat) carte[pos.getX()][pos.getY()], (Soldat) carte[pos2.getX()][pos2.getY()]);

            }
        } else {
            //si la pos2 n'est pas occupee alors deplacement
            if (!carte[pos2.getX()][pos2.getY()].EstOccupe()) {
                System.out.println("DEPLACEMENT");
                deplaceSoldat(pos2, (Soldat) carte[pos.getX()][pos.getY()]);
                ((Soldat) getElement(pos2)).joueTour(true);
                return true;
            }
            //sinon combat
            else {
                System.out.println("COMBAT2");
                return combatSoldat((Soldat) carte[pos.getX()][pos.getY()], (Soldat) carte[pos2.getX()][pos2.getY()]);
            }
        }
        return false;
    }

    /**
     * Cette methode cherche et retourne un Heros aleatoire.
     * <p>
     * Le Héros est a bon "Range" pour etre frappe par le soldat pris en argument.
     *
     * @param soldat Soldat
     * @return Heros qui peut etre frappe.
     */
    public Heros trouverHerosDansTir(Soldat soldat) {
        List<Position> pos = soldat.intervalTir();
        List<Heros> heros = new ArrayList<Heros>();
        Position p;
        for (int i = pos.get(0).getX(); i <= pos.get(1).getX(); i++) {
            for (int j = pos.get(0).getY(); j <= pos.get(1).getY(); j++) {
                p = new Position(i, j);
                if (p.estValide())
                    if (getElement(p) instanceof Heros) {
                        heros.add((Heros) getElement(p));
                    }
            }
        }
        if (heros.isEmpty()) {
            return null;
        } else {
            // Sinon choix alleatoir parmis les heros trouves
            int choix = new Random().nextInt(heros.size());
            return heros.get(choix);
        }


    }

    /**
     * Cette methode est une pseudo IA de Monstre.
     * <p>
     * Le Monstre va soit attaquer un Heros si ca Position lui le permet,soit se deplacer aleatoirement dans une case voisine.
     */
    public void actionMonstres1() {

        //!!!!!!!!! change tour to avoid double or even triple playing
        for (int i = 0; i < SettingsControl.getLARGEUR_CARTE(); i++) {
            for (int j = 0; j < SettingsControl.getHAUTEUR_CARTE(); j++) {
                if (getElement(new Position(i, j)) instanceof Monstre) {
                    if (((Monstre) getElement(new Position(i, j))).getTour() == false) {
                        boolean b;
                        Heros hero = trouverHerosDansTir((Soldat) getElement(new Position(i, j)));
                        Position p;
                        if (hero != null) {
                            combatSoldat((Soldat) getElement(new Position(i, j)), hero);
                        } else {
                            if ((p = trouvePositionVideHexagonal(new Position(i, j))) != null) {
                                //System.out.println("POOOOS" + p.getX() + " " + p.getY());
                                b = deplaceSoldat(p, (Soldat) getElement(new Position(i, j)));
                                ((Soldat) getElement(p)).joueTour(b);
                            }
                        }
                    }
                }
            }
            remetreTourMonstreZero();
        }
    }

    /**
     * Cette methode remet le tour de tous les Heros a false.
     * <p>
     * Elle va heal egalement les Heros non bouges.
     */
    public void remetreTourHeroZero() {
        for (int i = 0; i < SettingsControl.getLARGEUR_CARTE(); i++) {
            for (int j = 0; j < SettingsControl.getHAUTEUR_CARTE(); j++) {
                if (carte[i][j] instanceof Heros) {
                    if (!((Soldat) carte[i][j]).getTour()) {
                        ((Soldat) carte[i][j]).healing();
                    } else {
                        ((Soldat) carte[i][j]).joueTour(false);
                    }
                }
            }
        }
    }

    /**
     * Cette methode remet le tour de tous les Monstres a false.
     */
    public void remetreTourMonstreZero() {
        for (int i = 0; i < SettingsControl.getLARGEUR_CARTE(); i++) {
            for (int j = 0; j < SettingsControl.getHAUTEUR_CARTE(); j++) {
                if (carte[i][j] instanceof Monstre) {
                    if (!((Soldat) carte[i][j]).getTour()) {
                        ((Soldat) carte[i][j]).healing();
                    } else {
                        ((Soldat) carte[i][j]).joueTour(false);
                    }
                }
            }
        }
    }


    @Override
    public void jouerSoldats(PanneauJeu pj) {
        // TODO Auto-generated method stub

    }

    /**
     * Cette methode ajoute "nombre" de Heros aleatoirement en haut a gauche de la carte.
     * <p>
     * Elle est concue de facon a ce que l'interval augmente s'il existe pas de places vides.
     *
     * @param nombre
     */
    public void ajoutHeros(int nombre) {
        int compteur = 0;
        Position pos;
        int interval = 4;
        int max = 0;
        int larg = 15, haut = 50;
        if (SettingsControl.getLARGEUR_CARTE() > 0 && SettingsControl.getHAUTEUR_CARTE() > 0) {
            larg = SettingsControl.getLARGEUR_CARTE();
            haut = SettingsControl.getHAUTEUR_CARTE();
        }
        while (compteur <= nombre) {

            if (max > 20) {
                if (interval > 1) {
                    interval -= 1;
                }
                max = 0;
            }
            int x = new Random().nextInt(larg / interval);
            int y = new Random().nextInt(haut / interval);

            if ((pos = trouvePositionVideHexagonal(new Position(x, y))) != null) {
                ajouterElement(new Heros(ISoldat.TypesH.getTypeHAlea(), pos));
                compteur++;
            }
            max++;
        }
    }

    /**
     * Cette methode ajoute "nombre" de Monstres aleatoirement en bas a droite de la carte.
     * <p>
     * Elle est concue de facon a ce que l'interval augmente s'il existe pas de places vides.
     *
     * @param nombre
     */
    public void ajoutMonstre(int nombre) {
        int compteur = 0;
        int max = 0;
        double interval = 0.7;
        Position pos;
        int larg=15,haut=40;
        if (SettingsControl.getLARGEUR_CARTE() > 0 && SettingsControl.getHAUTEUR_CARTE() > 0) {
            larg = SettingsControl.getLARGEUR_CARTE();
            haut = SettingsControl.getHAUTEUR_CARTE();
        }
        while (compteur <= nombre) {

            if (max > 20) {
                if (interval > 0.1) {
                    interval -= 0.05;
                    max = 0;
                }
            }

            int x = new Random().nextInt((int) ((larg + 1) - (larg * interval))) + (int) (larg * interval);
            int y = new Random().nextInt((int) ((haut + 1) - (haut * interval))) + (int) (haut * interval);

            if ((pos = trouvePositionVideHexagonal(new Position(x, y))) != null) {
                ajouterElement(new Monstre(ISoldat.TypesM.getTypeMAlea(), pos));
                compteur++;
            }
            max++;
        }
    }

    /**
     * Cree un carte totalement aleatoire.
     */
    public void carteAlea() {
        int i = 0;
        while (i < SettingsControl.getNB_OBSTACLES()) {
            Position pos = trouvePositionVide();
            ajouterElement(new Obstacle(Obstacle.TypeObstacle.getObstacleAlea(), pos));
            i++;
        }
        ajoutHeros(SettingsControl.getNB_HEROS());
        ajoutMonstre(SettingsControl.getNB_MONSTRES());

    }


    /**
     * Cette methode dessine la totalite de la carte.
     * <p>
     * Elle dessine les image correspondant a chaque Soldat et Obstacle.
     * Pour les Heros il existe une image de selection et une image de deja joue en plus de l'image normale.
     *
     * @param g Graphics
     */
    @Override
    public void toutDessiner(Graphics g) {
        
        double constante = 1.154;
        Position taille = new Position(SettingsControl.getNB_PIX_CASE() + 2, (int) (SettingsControl.getNB_PIX_CASE() / constante + 2));
        images.dessinerImage(g, images.font, new Position(0,0), new Position(1365,768));
        for (int i = 0; i < SettingsControl.getLARGEUR_CARTE(); i++) {

            for (int j = 0; j < SettingsControl.getHAUTEUR_CARTE(); j++) {
                Position pos = new Position(getElement(new Position(i, j)).getHexagone().get(3).getX(), getElement(new Position(i, j)).getHexagone().get(4).getY());

                if (carte[i][j] instanceof Heros) {
                    //il s'agit d'un elf
                    if (((Heros) carte[i][j]).getType() == "ELF") {

                        if (((Heros) carte[i][j]).getTour() == true) {
                            g.setColor(COULEUR_HEROS_DEJA_JOUE);
                            //deja joue
                            images.dessinerImage(g, images.elfPlayed, pos, taille);

                        } else if (((Heros) carte[i][j]).getSelected() == true) {
                            ///selected

                            images.dessinerImage(g, images.elfSelected, pos, taille);
                            g.setColor(COULEUR_HEROS);
                        } else {
                            //image normale
                            images.dessinerImage(g, images.elf, pos, taille);
                            g.setColor(COULEUR_HEROS);
                        }

                        //il s'agit d'un humain
                    } else if (((Heros) carte[i][j]).getType() == "HUMAIN") {
                        if (((Heros) carte[i][j]).getTour() == true) {
                            g.setColor(COULEUR_HEROS_DEJA_JOUE);
                            //deja joue
                            images.dessinerImage(g, images.humainPlayed, pos, taille);
                        } else if (((Heros) carte[i][j]).getSelected() == true) {
                            g.setColor(COULEUR_HEROS);
                            ///selected
                            images.dessinerImage(g, images.humainSelected, pos, taille);
                        } else {
                            //image normale
                            images.dessinerImage(g, images.humain, pos, taille);

                            g.setColor(COULEUR_HEROS);
                        }

                        //il s'agit d'un hobit
                    } else if (((Heros) carte[i][j]).getType() == "HOBBIT") {
                        if (((Heros) carte[i][j]).getTour() == true) {
                            g.setColor(COULEUR_HEROS_DEJA_JOUE);
                            //deja joue
                            images.dessinerImage(g, images.hobbitPlayed, pos, taille);

                        } else if (((Heros) carte[i][j]).getSelected() == true) {
                            g.setColor(COULEUR_HEROS);
                            ///selected
                            images.dessinerImage(g, images.hobbitSelected, pos, taille);

                        } else {
                            //image normale
                            g.setColor(COULEUR_HEROS);
                            images.dessinerImage(g, images.hobbit, pos, taille);

                        }

                        //il s'agit d'un nain
                    } else if (((Heros) carte[i][j]).getType() == "NAIN") {
                        if (((Heros) carte[i][j]).getTour() == true) {
                            g.setColor(COULEUR_HEROS_DEJA_JOUE);
                            //deja joue
                            images.dessinerImage(g, images.nainPlayed, pos, taille);

                        } else if (((Heros) carte[i][j]).getSelected() == true) {
                            g.setColor(COULEUR_HEROS);
                            ///selected
                            images.dessinerImage(g, images.nainSelected, pos, taille);

                        } else {
                            //image normale
                            images.dessinerImage(g, images.nain, pos, taille);

                            g.setColor(COULEUR_HEROS);
                        }
                    }
                    //carte[i][j].dessinerHexagone(g);
                } else if (carte[i][j] instanceof Monstre) {

                    if (((Monstre) carte[i][j]).getType() == "ORC") {
                        // il s'agit d'un orc
                        images.dessinerImage(g, images.orc, pos, taille);
                        g.setColor(COULEUR_MONSTRES);
                        //carte[i][j].dessinerHexagone(g);

                    } else if (((Monstre) carte[i][j]).getType() == "GOBELIN") {
                        // il s'agit d'un gobelin
                        images.dessinerImage(g, images.goblin, pos, taille);

                        g.setColor(COULEUR_MONSTRES);
                        //carte[i][j].dessinerHexagone(g);

                    } else if (((Monstre) carte[i][j]).getType() == "TROLL") {
                        // il s'agit d'un troll
                        images.dessinerImage(g, images.troll, pos, taille);

                        g.setColor(COULEUR_MONSTRES);
                        //carte[i][j].dessinerHexagone(g);

                    }


                } else if (carte[i][j] instanceof Obstacle) {
                    //il s'agit d'un obstacle
                    Color couleur = ((Obstacle) getElement(new Position(i, j))).getTYPE().getObstacle();
                    if (couleur == COULEUR_ROCHER) {
                        //dessiner rocher
                        images.dessinerImage(g, images.rocher, pos, taille);
                        //g.setColor(COULEUR_ROCHER);
                    } else if (couleur == COULEUR_EAU) {
                        //dessiner eau
                        images.dessinerImage(g, images.eau, pos, taille);
                        //g.setColor(COULEUR_EAU);
                    } else if (couleur == COULEUR_FORET) {
                        //dessiner foret
                        images.dessinerImage(g, images.foret, pos, taille);
                        //g.setColor(COULEUR_FORET);
                    }
                } else {

                    // il s'aggit d'une position vide
                    images.dessinerImage(g, images.terrain, pos, taille);
                }
            }
        }
    }


}
