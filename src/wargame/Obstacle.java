package wargame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Obstacle extends Element implements IConfig {

	public enum TypeObstacle {
		ROCHER(COULEUR_ROCHER), FORET(COULEUR_FORET), EAU(COULEUR_EAU);
		private final Color COULEUR;

		TypeObstacle(Color couleur) {
			COULEUR = couleur;
		}

		public static TypeObstacle getObstacleAlea() {
			return values()[(int) (Math.random() * values().length)];
		}
		public Color getObstacle(){
			return COULEUR;
		}

	}

	private TypeObstacle TYPE;

	Obstacle(TypeObstacle type, Position pos) {
		super(pos,1);
		TYPE = type;
	}

	public String toString() {
		return "" + TYPE;
	}

	public TypeObstacle getTYPE(){
		return TYPE;
	}

	public void dessinerObstacle(Graphics g,Position pos){
		Color couleur =getTYPE().getObstacle();
        double constante = 1.154;
        if(couleur==COULEUR_ROCHER){
			//dessiner rocher
			g.setColor(COULEUR_ROCHER);
		}else if(couleur==COULEUR_EAU){
			//dessiner eau
            System.out.println("EAUUUUU");

            g.setColor(COULEUR_EAU);
		}else if(couleur==COULEUR_FORET){
			//dessiner foret
			g.setColor(COULEUR_FORET);
		}
	}

}

