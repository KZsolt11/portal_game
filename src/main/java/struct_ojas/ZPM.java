package struct_ojas;

import java.awt.Color;
import java.awt.Graphics;

public class ZPM extends Item {

	/**
	 * Megh�vja a kapott j�t�koson a collectZPM f�ggv�nyt, �gy a j�t�kosn�l (ha nem replik�tor)
	 * n�vekedni fog a ZPM-ek sz�ma, illetve a Field ki fogja t�r�lni
	 * a ZPM-et az Item-ek k�z�l.
	 * @param player
	 * @param weight - A r�ker�l� s�ly.
	 */
	@Override
	public boolean onStepAction(Player player, int weight) {
		
		return player.collectZPM();
		
	}	
	
	@Override
	public void draw(Graphics g, int size, Integer posX, Integer posY){
		int x=posX*size*5+size*5/4+5;
		int y=posY*size*5+size*5/4+5;
		int width=size*5/2;
		int height=size*5/2;
		
		g.setColor(Color.PINK);
		g.fillRect(x, y, width, height);
	}

}