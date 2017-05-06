package struct_ojas;

import java.awt.Graphics;

/**
 * @author Boti
 * Absztrakt item oszt�ly.
 */
public abstract class Item {

	/**
	 * A r�l�p�s megval�s�t�sa.
	 * @param player A lesz�rmazottak haszn�lj�k.
	 * @return false - True eset�n a tulajdonos Field kit�r�ln� az adott Item-et.
	 */
	public boolean onStepAction(Player player, int weight) {
		return false;
	}

	/**
	 * Doboz felv�tele, csak a Box override-olja.
	 * @return null- Box eset�n �nmaga.
	 */
	public Item onPickAction() {
		return null;
	}

	/**
	 * A mez�r�l val� lel�p�skor, vagy doboz lev�telekor h�v�dik meg, csak a Scale-re van hat�sa.
	 * 
	 */
	public void onStepOffAction(int weight) {}
	
	/**
	 * Doboz r�dob�sakor h�v�dik meg. A Scale �s a Hole override-olja, el�bbi ajt�t nyit, ut�bbi true-val t�r vissza.
	 * @return boolean - Hole eset�n true, hogy a Field tudja, hogy meg kell semmis�teni a r�dobott Box-ot, egy�b esetben false.
	 * 
	 */
	public boolean onDropAction(int weight) {
		return false;
	}
	
	public int getWeight(){
		return 0;
	}

	public void draw(Graphics g, int size, Integer posX, Integer posY) {
		// TODO Auto-generated method stub
		
	}

}