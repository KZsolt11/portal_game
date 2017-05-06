package struct_ojas;

public class Stargate {

	protected Wall yellowWall;
	protected Wall blueWall;
	protected Wall redWall;
	protected Wall greenWall;

	/**
	 * Megadja a f�regj�rat kij�rat�t/t�ls� v�g�t, vagy visszaadja ugyanazt a falat.
	 * @param otherWall - A f�regj�rat kapuja ahol bel�p�nk
	 * Szerkesztve: 2016.04.23.
	 */
	public Wall getWormHoleExit(Wall otherWall) {
		if(yellowWall==otherWall&&blueWall!=null) return blueWall;		
		else if (blueWall==otherWall&&yellowWall!=null) return yellowWall;
		else if (redWall==otherWall&&greenWall!=null) return greenWall;
		else if (greenWall==otherWall&&redWall!=null) return redWall;
		else return otherWall;				
	}

	/**
	 * Be�ll�t egy k�k sz�n� kaput a kapott falra
	 * @param wall - A fal amelyikre a kaput be kell �ll�tani
	 */
	public void setBlueWall(Wall wall) {
		blueWall=wall;
	}

	/**
	 * Be�ll�t egy piros sz�n� kaput a kapott falra
	 * @param wall - A fal, amire a kaput be kell �ll�tani
	 */
	public void setRedWall(Wall wall) {
		redWall=wall;
	}
	
	/**
	 * Be�ll�t egy s�rga sz�n� kaput a kapott falra
	 * @param wall - A fal, amire a kaput be kell �ll�tani
	 * 
	 */
	public void setYellowWall(Wall wall) {
		yellowWall=wall;
	}
	
	/**
	 * Be�ll�t egy z�ld sz�n� kaput a kapott falra
	 * @param wall - A fal, amire a kaput be kell �ll�tani
	 */
	public void setGreenWall(Wall wall) {
		greenWall=wall;
	}

}