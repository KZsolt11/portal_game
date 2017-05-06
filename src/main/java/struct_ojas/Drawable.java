package struct_ojas;

import java.awt.Graphics;

/*
 * A kirajzolhat� interf�sz. Egy darab f�ggv�nye van.
 */
public interface Drawable {
	/*
	 * A kirajzol�s f�ggv�nye. A param�terben kapott Graphics objektumra rajzol.
	 * @param - Graphics objektum
	 */
	public void draw(Graphics g, int size);
}
