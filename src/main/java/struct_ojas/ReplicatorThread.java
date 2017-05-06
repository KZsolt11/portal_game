package struct_ojas;


import java.util.Random;

public class ReplicatorThread extends Thread{

	private boolean stopflag;
	Player replicator;
	private Field spawnField;
	private Controller ownerController;
	Random rand;

	
	public ReplicatorThread(Field f, Controller con){
		super();
		spawnField=f;
		replicator=new Replicator(f, 0, 10);
		stopflag=false;
		rand = new Random();
		ownerController=con;
		ownerController.setReplicator(replicator);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Thread#run()
	 * M�sodpercenk�nt egyszer fut le.
	 * Ha az utols� replik�tor a list�ban meghalt, akkor
	 */
	@Override
	public void run(){
		//A fut�s addig tart, am�g k�v�lr�l nem jelt�nk.
		while(!stopflag){
			try {
				Thread.sleep(1000);
				if(replicator.isAlive==false){
					replicator=new Replicator(spawnField,0,10);
					ownerController.setReplicator(replicator);
				}
				replicator.step(rand.nextInt(4)+1);
				ownerController.repaintGamePanel();
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void stopThread(){
		stopflag=true;
	}
}
