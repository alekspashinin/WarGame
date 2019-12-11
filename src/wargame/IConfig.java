package wargame;

import java.awt.Color;

public interface IConfig {
	int WIDTH_PAGE=3000;
	int HEIGHT_PAGE=1500;
	int LARGEUR_CARTE = 15;
	int HAUTEUR_CARTE = 40; // en nombre de cases
	int NB_PIX_CASE = 150 ;
	int POSITION_X = 100;
	int POSITION_Y = 50; 
	int NB_HEROS = 6;
	int NB_MONSTRES = 15;
	int NB_OBSTACLES = 40;
	Color COULEUR_VIDE = Color.white, COULEUR_INCONNU = Color.lightGray;
	Color COULEUR_TEXTE = Color.black, COULEUR_MONSTRES = Color.black;
	Color COULEUR_HEROS = Color.red, COULEUR_HEROS_DEJA_JOUE = Color.pink;
	Color COULEUR_EAU = Color.blue, COULEUR_FORET = Color.green, COULEUR_ROCHER = Color.gray;
}