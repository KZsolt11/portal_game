package struct_ojas;

public class Bullet {
	/*Szerkesztve: 2016.04.23*/
	public enum bulletTypes {BLUE, YELLOW,RED,GREEN};
	private bulletTypes type;
	private Field pos;

	/**
	 * Konstruktor
	 * @param dir
	 */
	public Bullet(Field startPos, bulletTypes bulletType) {		
		pos=startPos; //l�trej�n a l�ved�k a j�t�kos mezej�n
		type=bulletType;
	}

	/**
	 * A t�lt�ny rept�nek vez�nyl�se
	 * @param dir A j�t�kos n�z�s�nek ir�ny a l�v�s lead�sakor
	 * Szerkesztve: 2016.04.23.
	 */
	public void firing(int dir) {		
		Field newfield=pos.getNextField(dir);//elkezd rep�lni
		
		while(pos!=newfield){  //rep�l ugyanabba az ir�nyba am�g tud
			pos=newfield;
			newfield=pos.getNextField(dir);
		}
		
		
		Wall targetwall=pos.getWall(dir);//megismerkedik a fallal amibe �tk�z�tt
		
		if(targetwall==null||targetwall.checkDoor()==true){
			int oppositeDir=dir+2;
			if(oppositeDir>4)oppositeDir-=4;
			try{
				targetwall=newfield.getNeighbour(dir).getWall(oppositeDir);
			}
			catch(NullPointerException e){
				
			}
		}
		
		if(targetwall!=null)
		targetwall.setGate(type);
	}

}