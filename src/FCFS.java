import java.util.Random;
import java.util.Vector;

public class FCFS extends AccessTime{
	int [] coada = new int[100];
	Vector<Integer> ordine = new Vector<Integer>();
	int head;
	int [] coadaInitial = new int[100];
	int headInitial;
	
	public FCFS(){}
	
	//-------------MEMBER FUNCTIONS-------------
	
	public void start(){
		// GENERARE COADA + HEAD SI AFISARE
		Random rand = new Random();
		for(int i=0;i<10; i++){
			coada[i] = rand.nextInt(199) + 1;
			coadaInitial[i] = coada[i];
		}
		head = rand.nextInt(199) + 1;
		headInitial = head;
		ordine.add(head);
		for(int i=1;i<10; i++){
			ordine.add(coada[i-1]);
		}
	}
	
	public void afisare(){
		start();
		System.out.println("-----FCFS Disk Scheduling-----");
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
		System.out.println();
	}
}
