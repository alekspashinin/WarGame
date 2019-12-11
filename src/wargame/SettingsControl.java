package wargame;

public class SettingsControl {

    private static int WIDTH_PAGE;
    private static int HEIGHT_PAGE;
    private static int LARGEUR_CARTE;
    private static int HAUTEUR_CARTE;
    private static int NB_PIX_CASE;
    private static int POSITION_X;
    private static int POSITION_Y;
    private static int NB_HEROS;
    private static int NB_MONSTRES;
    private static int NB_OBSTACLES;
    private static double CONSTANTE = 1.154;

    //Accesseurs
    public SettingsControl() {
        WIDTH_PAGE = 1365;
        HEIGHT_PAGE = 768;
        LARGEUR_CARTE = 15;
        HAUTEUR_CARTE = 40;
        NB_PIX_CASE = 40;
        POSITION_X = 100;
        POSITION_Y = 50;
        NB_HEROS = 10;
        NB_MONSTRES = 15;
        NB_OBSTACLES = 30;

    }

    public static int getLARGEUR_CARTE() {
        return LARGEUR_CARTE;
    }

    public static int getWIDTH_PAGE() {
        return WIDTH_PAGE;
    }

    public static int getHEIGHT_PAGE() {
        return HEIGHT_PAGE;
    }

    public static int getHAUTEUR_CARTE() {
        return HAUTEUR_CARTE;
    }

    public static int getNB_PIX_CASE() {
        return NB_PIX_CASE;
    }

    public static int getPOSITION_X() {
        return POSITION_X;
    }

    public static int getPOSITION_Y() {
        return POSITION_Y;
    }

    public static int getNB_HEROS() {
        return NB_HEROS;
    }

    public static int getNB_MONSTRES() {
        return NB_MONSTRES;
    }

    public static int getNB_OBSTACLES() {
        return NB_OBSTACLES;
    }

    public static double getCONSTANTE() {
        return CONSTANTE;
    }

    //Mutateurs


    public static void setLARGEUR_CARTE(int LARGEUR_CARTE) {
        SettingsControl.LARGEUR_CARTE = LARGEUR_CARTE;
    }

    public static void setWIDTH_PAGE(int WIDTH_PAGE) {
        SettingsControl.WIDTH_PAGE = WIDTH_PAGE;
    }

    public static void setHEIGHT_PAGE(int HEIGHT_PAGE) {
        SettingsControl.HEIGHT_PAGE = HEIGHT_PAGE;
    }

    public static void setHAUTEUR_CARTE(int HAUTEUR_CARTE) {
        SettingsControl.HAUTEUR_CARTE = HAUTEUR_CARTE;
    }

    public static void setNB_PIX_CASE(int NB_PIX_CASE) {
        SettingsControl.NB_PIX_CASE = NB_PIX_CASE;
    }

    public static void setPOSITION_X(int POSITION_X) {
        SettingsControl.POSITION_X = POSITION_X;
    }

    public static void setPOSITION_Y(int POSITION_Y) {
        SettingsControl.POSITION_Y = POSITION_Y;
    }

    public static void setNB_HEROS(int NB_HEROS) { SettingsControl.NB_HEROS = NB_HEROS; }

    public static void setNB_MONSTRES(int NB_MONSTRES) { SettingsControl.NB_MONSTRES = NB_MONSTRES; }

    public static void setNB_OBSTACLES(int NB_OBSTACLES) {
        SettingsControl.NB_OBSTACLES = NB_OBSTACLES;
    }
}
