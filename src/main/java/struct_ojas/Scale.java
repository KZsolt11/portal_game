
package struct_ojas;

import java.awt.Color;
import java.awt.Graphics;

public class Scale extends Item {

	private Door myDoor;
	int load=0;
	static int weightThreshold=10;

	/**
	 * A j�t�kos r�l�p�sekor lefut� f�ggv�ny, ami kinyitja az ajt�t.
	 * @param player - A j�t�kos
	 *@return - false, l�sd a Field oszt�lyn�l.
	 */
	
	@Override
	public boolean onStepAction(Player player, int weight) {
		//System.out.println("\tScale.onStepAction(Player)");
		load+=weight;
		if(load>=weightThreshold){
			myDoor.open();
		}
		
		//System.out.println("\t<-- Scale.onStepAction");		
		return false;

	}
	
	public Scale(Door myDoor, int load) {
		super();
		this.myDoor = myDoor;
		this.load = load;
	}
	/**
	 * A j�t�kos lel�p�sekor lefut� f�ggv�ny, ami becsukja az ajt�t, ha
	 * a s�lyk�sz�b al� ment a load.
	 * @param - a levett s�ly.
	 */
	@Override
	public void onStepOffAction(int weight) {
		this.load-=weight;
		
		if(load<weightThreshold){
			myDoor.close();
		}
		
	}
	
	/**
	 * Egy item ledob�sakor lefut� f�ggv�ny, hasonl� az onStepAction()-hez.
	 * A load-hoz hozz�adjuk a kapott s�lyt, �s ha el�rj�k a s�lyhat�rt,
	 * kinyitjuk az ajt�t.
	 * False-szal t�r vissza - l�sd: Field oszt�ly.
	 * @param weight - int
	 * @return false 
	 * 
	 */
	@Override
	public  boolean onDropAction(int weight) {
		load+=weight;
		if(load>=weightThreshold){
			myDoor.open();
		}
		return false;
		
	}
	
	/**
	 *Az ajt� be�ll�t�s�ra szolg�l� f�ggv�ny
	 * @param d - Door
	 * 
	 */
	public void setDoor(Door d){
		myDoor=d;
	}
	
	@Override
	public void draw(Graphics g, int size, Integer posX, Integer posY){
		int x=posX*size*5+size*5/4+5;
		int y=posY*size*5+size*5/2+5;
		int width=size*5/4*3;
		int height=size*5/3;
		
		//A m�rleg als� r�sze
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
		
		//A m�rleg fels� r�sze
		int r=size/2*5;
		int realPosX=posX*size*5+size*5/2;
		int realPosY=posY*size*5+size*5*2/6;
		g.fillOval(realPosX, realPosY, r, r);
	}

}
