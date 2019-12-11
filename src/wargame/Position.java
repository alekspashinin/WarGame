package wargame;

public class Position implements IConfig {
	private int x, y;

	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean estValide() {
		if (x < 0 || x >= SettingsControl.getLARGEUR_CARTE() || y < 0 || y >= SettingsControl.getHAUTEUR_CARTE())
			return false;
		else
			return true;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public boolean estVoisine(Position pos) {
		return ((Math.abs(x - pos.x) <= 1) && (Math.abs(y - pos.y) <= 1));
	}

	public boolean estVoisineHexagonale(Position pos){
        boolean b=false;
        //y+1
        if(pos.getX()==this.x && pos.getY()==this.y+1){
            b=true;
        }
        //y-1
        if(pos.getX()==this.x && pos.getY()==this.y-1){
            b=true;
        }
        //y+2
        if (pos.getX()==this.x && pos.getY()==this.y+2){
            b=true;
        }
        //y-2
        if(pos.getX()==this.x && pos.getY()==this.y-2){
            b=true;
        }
        if (this.y % 2 == 0) {
            //x-1,y-1
            if (pos.getX() == this.x - 1 && pos.getY() == this.y - 1) {
                b = true;
            }
            //x-1,y+1
            if (pos.getX() == this.x - 1 && pos.getY() == this.y + 1) {
                b = true;
            }
        }else{
            //x+1,y-1
            if(pos.getX() == this.x + 1 && pos.getY() == this.y - 1){
                b=true;
            }
            //x+1,y+1
            if(pos.getX() == this.x + 1 && pos.getY() == this.y + 1){
                b=true;
            }
        }
        return b;
    }

	public static enum SigneAngle {
		SAM, ALIGNES, SIAM,
	}


	public SigneAngle signeAngle(Position b, Position c) {
		Position a = this;
		double det = (b.getX() - a.getX())*(c.getY() - a.getY()) - (c.getX() - a.getX())*(b.getY() - a.getY());
		if (det < 0) {
			return SigneAngle.SAM;
		} else if (det > 0) {
			return SigneAngle.SIAM;
		} else {
			return SigneAngle.ALIGNES;
		}
	}

}