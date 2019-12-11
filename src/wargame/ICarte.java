package wargame;
import java.awt.Graphics;
public interface ICarte {
	Element getElement(Position pos);
	Position trouvePositionVide(); // Trouve aleatoirement une position vide sur la carte
	Position trouvePositionVide(Position pos); // Trouve une position vide choisie

	// al�atoirement parmi les 8 positions adjacentes de pos
	Heros trouveHeros(); // Trouve aleatoirement un heros sur la carte

	Heros trouveHeros(Position pos); // Trouve un heros choisi aleatoirement

	// parmi les 8 positions adjacentes de pos
	boolean deplaceSoldat(Position pos, Soldat soldat);

	void mort(Soldat perso);

	void ajouterElement(Element elem);

	boolean combatSoldat(Soldat premier, Soldat deuxieme);
	//bool afin de verifier que le combat a bien u lieu

	boolean estHeros(Position pos);

	boolean estObstacle(Position pos);

	boolean actionHeros(Position pos, Position pos2);

	void jouerSoldats(PanneauJeu pj);

	void toutDessiner(Graphics g);
}