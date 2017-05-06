package struct_ojas;

import java.awt.Color;
import java.awt.Graphics;

public class Hole extends Item {

	/**
	 * A j�t�koson megh�vott die() f�ggv�ny �rt�k�vel t�r vissza, �gy
	 * �gy meg�li a j�t�kost, �s ha replik�tor volt, akkor a tartalmaz�
	 * Field ki fogja t�r�lni ezt a Hole-t.
	 * @param player
	 * @return player.die() - Innen tudjuk, hogy replik�tor volt -e.
	 */
	@Override
	public boolean onStepAction(Player player, int weight) {		
		return player.die();
	}
	
	@Override
	public boolean onDropAction(int weight) {
		return true;
	}
	
	@Override
	public void draw(Graphics g, int size, Integer posX, Integer posY){
		int r=(size-1)*5;
		int realPosX=posX*size*5+6;
		int realPosY=posY*size*5+3;
		g.setColor(Color.BLACK);
		g.fillOval(realPosX, realPosY, r, r);
	}

}