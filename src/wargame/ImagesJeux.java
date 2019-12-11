package wargame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Cette classe contient toutes les images utilisés pour la carte.
 *
 * @author Soupilas Dimitrios
 * @author Pashinin Aleksei
 */
public class ImagesJeux {
    public BufferedImage font;
    public BufferedImage terrain;
    /**IMAGES OBSTACLES**/
    public BufferedImage eau;
    public BufferedImage foret;
    public BufferedImage rocher;

    /**IMAGES HEROS**/
    public BufferedImage humain;
    public BufferedImage humainSelected;
    public BufferedImage humainPlayed;

    public BufferedImage nain;
    public BufferedImage nainSelected;
    public BufferedImage nainPlayed;

    public BufferedImage hobbit;
    public BufferedImage hobbitSelected;
    public BufferedImage hobbitPlayed;

    public BufferedImage elf;
    public BufferedImage elfSelected;
    public BufferedImage elfPlayed;

    /**IMAGES MONSTRES**/
    public BufferedImage troll;
    public BufferedImage orc;
    public BufferedImage goblin;

    /**
     * Ce constructeur initialise toutes les images.
     */
    public ImagesJeux(){
        /** Images de base **/
        ImageFont();
        ImageTerrain();
        ImageEau();
        ImageForet();
        ImageRocher();

        /** Images Heros **/
        ImageElf();
        ImageElfPlayed();
        ImageElfSelected();

        ImageHobbit();
        ImageHobbitPlayed();
        ImageHobbitSelected();

        ImageHumain();
        ImageHumainPlayed();
        ImageHumainSelected();

        ImageNain();
        ImageNainPlayed();
        ImageNainSelected();

        /** Images Heros **/
        ImageGoblin();
        ImageOrc();
        ImageTroll();

    }

    private void ImageTerrain(){
        try {
            terrain = ImageIO.read(new File("Images/Obstacles/terrain.png"));
        } catch (IOException ex) {
            System.out.println("ERREUR CHAREMENT IMAGE TERRAIN");
        }
    }

    /** Images Obstacles **/
    private void ImageEau(){
        try {
            eau = ImageIO.read(new File("Images/Obstacles/leau.png"));
        } catch (IOException ex) {
            System.out.println("ERREUR CHAREMENT IMAGE EAU");
        }
    }

    private void ImageForet(){
        try {
            foret = ImageIO.read(new File("Images/Obstacles/foret.png"));
        } catch (IOException ex) {
            System.out.println("ERREUR CHAREMENT IMAGE FORET");
        }
    }

    private void ImageRocher(){
        try {
            rocher = ImageIO.read(new File("Images/Obstacles/hills.png"));
        } catch (IOException ex) {
            System.out.println("ERREUR CHAREMENT IMAGE ROCHER");
        }
    }

    /** Images Heros **/

    /** Les humains **/
    private void ImageHumain(){
        try {
            humain = ImageIO.read(new File("Images/Heros/humain.png"));
        } catch (IOException ex) {
            System.out.println("ERREUR CHAREMENT IMAGE HUMAIN");
        }
    }

    private void ImageHumainSelected(){
        try {
            humainSelected = ImageIO.read(new File("Images/Heros/humainSelected.png"));
        } catch (IOException ex) {
            System.out.println("ERREUR CHAREMENT IMAGE HUMAIN SELECTED");
        }
    }
    private void ImageHumainPlayed(){
        try {
            humainPlayed = ImageIO.read(new File("Images/Heros/humainPlayed.png"));
        } catch (IOException ex) {
            System.out.println("ERREUR CHAREMENT IMAGE HUMAIN PLAYED");
        }
    }

    /** Les hobbits **/
    private void ImageHobbit(){
        try {
            hobbit = ImageIO.read(new File("Images/Heros/hobbit.png"));
        } catch (IOException ex) {
            System.out.println("ERREUR CHAREMENT IMAGE HOBBIT");
        }
    }
    private void ImageHobbitSelected(){
        try {
            hobbitSelected = ImageIO.read(new File("Images/Heros/hobbitSelected.png"));
        } catch (IOException ex) {
            System.out.println("ERREUR CHAREMENT IMAGE HOBBIT SELECTED");
        }
    }

    private void ImageHobbitPlayed(){
        try {
            hobbitPlayed = ImageIO.read(new File("Images/Heros/hobbitPlayed.png"));
        } catch (IOException ex) {
            System.out.println("ERREUR CHAREMENT IMAGE HOBBIT PLAYED");
        }
    }

    /** Les Elfs **/
    private void ImageElf(){
        try {
            elf = ImageIO.read(new File("Images/Heros/elf.png"));
        } catch (IOException ex) {
            System.out.println("ERREUR CHAREMENT IMAGE ELF");
        }
    }

    private void ImageElfSelected(){
        try {
            elfSelected = ImageIO.read(new File("Images/Heros/elfSelected.png"));
        } catch (IOException ex) {
            System.out.println("ERREUR CHAREMENT IMAGE ELF SELECTED");
        }
    }

    private void ImageElfPlayed(){
        try {
            elfPlayed = ImageIO.read(new File("Images/Heros/elfPlayed.png"));
        } catch (IOException ex) {
            System.out.println("ERREUR CHAREMENT IMAGE ELF PLAYED");
        }
    }

    /** Les Nains **/
    private void ImageNain(){
        try {
            nain = ImageIO.read(new File("Images/Heros/nain.png"));
        } catch (IOException ex) {
            System.out.println("ERREUR CHAREMENT IMAGE NAIN");
        }
    }

    private void ImageNainSelected(){
        try {
            nainSelected = ImageIO.read(new File("Images/Heros/nainSelected.png"));
        } catch (IOException ex) {
            System.out.println("ERREUR CHAREMENT IMAGE NAIN SELECTED");
        }
    }

    private void ImageNainPlayed(){
        try {
            nainPlayed = ImageIO.read(new File("Images/Heros/nainPlayed.png"));
        } catch (IOException ex) {
            System.out.println("ERREUR CHAREMENT IMAGE NAIN PLAYED");
        }
    }

    /** Images Monstres **/

    private void ImageOrc(){
        try {
            orc= ImageIO.read(new File("Images/Monstres/orc.png"));
        } catch (IOException ex) {
            System.out.println("ERREUR CHAREMENT IMAGE ORC");
        }
    }

    private void ImageTroll(){
        try {

            troll = ImageIO.read(new File("Images/Monstres/troll.png"));
        } catch (IOException ex) {
            System.out.println("ERREUR CHAREMENT IMAGE TROLL");
        }
    }

    private void ImageGoblin(){
        try {
            goblin = ImageIO.read(new File("Images/Monstres/goblin.png"));
        } catch (IOException ex) {
            System.out.println("ERREUR CHAREMENT IMAGE GOBLIN");
        }
    }

    private void ImageFont(){
        try {
            font = ImageIO.read(getClass().getResource("/wargame/Images/backjeu.png"));
        } catch (IOException ex) {
            System.out.println("ERREUR CHAREMENT IMAGE Font");
        }
    }

    public void dessinerImage(Graphics g, BufferedImage image, Position pos,Position taille){
        g.drawImage(image, pos.getX(), pos.getY(), taille.getX(),taille.getY(),null);

    }

}
