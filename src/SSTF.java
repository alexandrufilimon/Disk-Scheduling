import java.util.Random;
import java.util.Vector;
import java.lang.Math;

public class SSTF extends AccessTime{
	int [] coada = new int[100];
	Vector<Integer> ordine = new Vector<Integer>();
	int closest, head;
	int headInitial;
	int [] coadaInitial = new int[100];
	
	
	public SSTF(){}
	
	//-------------MEMBER FUNCTIONS-------------
	
	public void start(){
		// GENERARE COADA + HEAD
		Random rand = new Random();
		for(int i=0; i<10; i++){
			coada[i] = rand.nextInt(199) + 1;
			coadaInitial[i] = coada[i];
		}
		head = rand.nextInt(199) + 1;
		headInitial = head;
		//
		ordine.add(head);
		for(int i=1; i<11; i++){
			ordine.add(findClosest(head));
			head = ordine.get(i);
		}
	}
	
	public void afisare(){
		start();
		System.out.println("-----SSTF Disk Scheduling-----");
		System.out.print("Coada: ");
		for(int i=0; i<10; i++){
			System.out.print(coadaInitial[i] + " ");
		}
		System.out.println(" || Head: " + headInitial);
		System.out.print("Ordinea: ");
		// AFISARE ORDINE
		for(int nr : ordine){
			System.out.print(nr + " ");
		}
		System.out.println();
		printAccessTime(ordine);
	}
	
	// RETURN CEA MAI APROPIATA CERERE
	public int findClosest(int newHead){
		for(int i=0; i<10; i++){
			if(closest == coada[i]){
				coada[i]=999;
			}
		}
		int min = 301;
		for(int i=0; i<10; i++){
			int dist = Math.abs(newHead-coada[i]);
			if (dist < min){
				min = dist;
				closest = coada[i];
			}
		}
		return closest;
	}
	
	
	public static void main(String[] args) {
		Threading T1 = new Threading("Thread 1 ", new SSTF());
		Threading T2 = new Threading("Thread 2 ", new FCFS());
		Threading T3 = new Threading("Thread 3 ", new SCAN());
		Threading T4 = new Threading("Thread 4 ", new LOOK());
		Threading T5 = new Threading("Thread 5 ", new CSCAN());
		Threading T6 = new Threading("Thread 6 ", new CLOOK());
		
		//
	    T1.start();
	    T2.start();    
	    T3.start();
	    T4.start();
	    T5.start();
	    T6.start();

	}
}