package struct_ojas;

import java.awt.Color;
import java.awt.Graphics;



public class Player {

	protected Field pos;
	protected int faceDir;
	private int ZPMCount;
	private Item box;
	protected boolean isAlive;
	protected int weight;
	private Bullet.bulletTypes bulletType;
	public boolean hasBox;
	
	/**
	 * 
	 * @param startPos A j�t�kos kezd� poz�ci�ja
	 * @param playerNumber - A j�t�kos t�pusa == a be�llathat� sz�n� l�ved�keket
	 * tudjuk meg.
	 * @param weight - a j�t�kos s�lya
	 */
	public Player(Field startPos, int playerNumber, int weight){		
		if(playerNumber==1)bulletType=Bullet.bulletTypes.YELLOW;
		else bulletType=Bullet.bulletTypes.RED;
		
		hasBox = false;
		isAlive = true;
		box = null;
		pos=startPos;
		faceDir=1;
		this.weight=weight;
	}
	/**
	 * A j�t�kos l�p�se a kapott ir�nyba
	 * @author Pacz Benjamin
	 * @date 2016.03.28
	 * @param dir A l�p�s ir�nya
	 */
	public void step(int dir) {
		Field newPos;
		faceDir=dir;
		newPos= pos.getNextField(dir);
		if (newPos!=pos) {
			pos.stepOff(weight);
			newPos.stepOn(this, weight);
			pos=newPos;
		}
	}
	/**
	 * A j�t�kos n�z�s�nek ford�t�sa +-90 fokkal
	 * @author Pacz Benjamin
	 * @date 2016.03.28
	 * @param dir A forgat�s ir�nya
	 */
	public void turn() {
		faceDir+=2;
		if(faceDir>4) faceDir-=4;
	}
	/**
	 * Ellen�rizz�k, hogy a n�z�snek megfelel� ir�nyban van-e doboz, �s ha igen felvessz�k
	 * @author Pacz Benjamin
	 * @date 2016.03.28
	 */
	public void pickUp() {
		Field tempfield=pos.getNextField(faceDir);
		if (pos!=tempfield&&!hasBox) //nem egy fal el�tt �llunk, van el�tt�nk el�rhet� m�sik mez�
		{	//�s nincs a kez�nkben box
			box=tempfield.performPick();
			
			if(box!=null) {
				hasBox=true;
				this.weight+=box.getWeight();
			}
			else hasBox=false;
		}
		
	}

	/**
	 * Ellen�rizz�k, hogy a n�z�snek megfelel� ir�nyban van-e mez�, �s ha igen letessz�k a dobozt
	 * @author Pacz Benjamin
	 * @date 2016.03.28
	 */
	public void putDown() {
		Field putToThisField=pos.getNextField(faceDir);
		if (pos!=putToThisField&&hasBox) //nem egy fal el�tt �llunk, van el�tt�nk el�rhet� m�sik mez�
		{	//�s van a kez�nkben box
			putToThisField.addNewItem(box);
			hasBox=false;
			weight-=box.getWeight();
			box=null;
		}
	}

	/**
	 * N�velj�k a ZPM sz�ml�l�t, a Field h�vja meg a stepOn(player:Player f�ggv�ny�ben)
	 * @author Pacz Benjamin
	 * @date 2016.03.28
	 */
	public boolean collectZPM() {	
		ZPMCount++;
		return true;
	}

	/**
	 * A j�t�kos meghal
	 * @author Pacz Benjamin
	 * @date 2016.03.28
	 */
	public boolean die() {
		isAlive=false;
		return false;
	}

	/**
	 * A j�t�kos lead egy l�v�st
	 * @author Pacz Benjamin
	 * @date 2016.03.28
	 */
	public void fire() {
		Bullet bullet=new Bullet(pos, bulletType);
		bullet.firing(faceDir);
	}

	/**
	 * A j�t�kos megv�ltoztatja a l�ved�k t�pus�t
	 * @author Pacz Benjamin
	 * @date 2016.03.28
	 */
	public void changeBulletType() {
		switch(this.bulletType){
		case BLUE: this.bulletType=Bullet.bulletTypes.YELLOW; break;
		case YELLOW: this.bulletType=Bullet.bulletTypes.BLUE; break;
		case GREEN: this.bulletType=Bullet.bulletTypes.RED; break;
		case RED: this.bulletType=Bullet.bulletTypes.GREEN; break;
		default: break;
		}
	}
	
	public String getBulletType() {
		return this.bulletType.toString();
	}
	
	/**
	 * Visszaadja az �let�nek �llapot�t, azaz, hogy �l -e m�g.
	 * @author Boti
	 * @date 2016.04.23.
	 */
	public boolean isAlive(){
		return isAlive;
	}

	/**
	 * Visszaadja a begy�jt�tt ZPM-ek sz�m�t.
	 * @author Boti
	 * @date 2016.04.23.
	 */
	public int getZPMCount(){
		return this.ZPMCount;
	}
	
	/*
	 * A j�t�kos kirajzol�s��rt felel� f�ggv�ny
	 * Ismeri a saj�t poz�ci�j�t, ir�ny�t, l�ved�ke t�pus�t, �s hogy van -e n�la doboz.
	 * @param g - Graphics objektum, a j�t�kpanel�, erre rajzolunk.
	 * @param size - int, a m�retet ez alapj�n tudjuk.
	 */
	public void draw(Graphics g, int size) {
		if(isAlive){
			// J�t�kos arca
			
			
			int r=(size-1)*5;
			int realPosX=pos.getPosX()*size*5+6;
			int realPosY=pos.getPosY()*size*5+3;
			
			//A l�ved�kt�pus alapj�n eld�ntj�k, hogy melyik j�t�kos vagyunk.
			if(bulletType==Bullet.bulletTypes.BLUE||bulletType==Bullet.bulletTypes.YELLOW)
			g.setColor(new Color(245,194,151));
			
			else{
				g.setColor(new Color(128,0,128));
			}
			g.fillOval(realPosX, realPosY, r, r);
			
			//J�t�kos fegyvere
			switch(this.bulletType){
			case RED: g.setColor(Color.RED); break;
			case GREEN: g.setColor(Color.GREEN); break;
			case YELLOW: g.setColor(Color.YELLOW); break;
			case BLUE: g.setColor(Color.BLUE); break;
			}
			
			int x=0;
			int y=0;
			int width=0;
			int height=0;
			
			//v�zszintes �ll�s� fegyver
			if(faceDir==2||faceDir==4){
				width=size*5/2;
				height=size*5/6;
				y=pos.getPosY()*size*5+size*5/6*3;
				if(faceDir==2){
					x=pos.getPosX()*size*5+size*5/6*5;
				}
				else if(faceDir==4){
					x=pos.getPosX()*size*5-size;
				}
				
			}
			
			else{
				width=size*5/6;
				height=size*5/2;
				x=pos.getPosX()*size*5+size*5/6*3;
				if(faceDir==1){
					y=pos.getPosY()*size*5-size;
				}
				else if(faceDir==3){
					y=pos.getPosY()*size*5+size*5*4/6;
				}
			}
			
			g.fillRect(x, y, width, height);
			
			//Ha van n�lunk box, eleg�nsan a fej�nk�n hordjuk.
			if(box!=null){
				x=pos.getPosX()*size*5+size*5/4+5;
				y=pos.getPosY()*size*5+size*5/4+5;
				width=size*5/2;
				height=size*5/2;
				
				g.setColor(new Color(222,184,135));
				g.fillRect(x, y, width, height);
			}
		}
		
		
	}
}