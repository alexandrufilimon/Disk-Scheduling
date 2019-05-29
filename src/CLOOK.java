import java.util.Collections;
import java.util.Random;
import java.util.Vector;

public class CLOOK extends AccessTime {
	int [] coada = new int[100];
	Vector<Integer> ordine = new Vector<Integer>();
	Vector<Integer> coadaMinim = new Vector<Integer>();
	Vector<Integer> coadaMaxim = new Vector<Integer>();
	int head;
	int [] coadaInitial = new int[100];
	int headInitial;
	
	public CLOOK(){}
	
	//-------------MEMBER FUNCTIONS-------------
	
	
	public void start(){
		// GENERARE COADA + HEAD
		Random rand = new Random();
		head = rand.nextInt(199) + 1;
		headInitial = head;
		ordine.add(head);
		
		// VALORI MAI MARI DECAT HEAD SUNT IN coadaMaxim //
		// VALORI MAI MICI DECAT HEAD SUNT IN coadaMinim //
		for(int i=0;i<10; i++){
			coada[i] = rand.nextInt(199) + 1;
			if(coada[i] >= head){
				coadaInitial[i] = coada[i];
				coadaMaxim.add(coada[i]);
			}
			else{
				coadaInitial[i] = coada[i];
				coadaMinim.add(coada[i]);
			}
		}
		// SORTAM AMBII VECTORI
		Collections.sort(coadaMinim);
		Collections.sort(coadaMaxim);
		
		if(Math.abs(head-0) <= Math.abs(head-199)){
			for(int i=coadaMinim.size()-1; i>=0; i--){
				ordine.add(coadaMinim.get(i));
			}
			for(int i=coadaMaxim.size()-1; i>=0; i--){
				ordine.add(coadaMaxim.get(i));
			}
		}
		else {
			for(int i=0; i<coadaMaxim.size(); i++){
				ordine.add(coadaMaxim.get(i));
			}
			for(int i=0; i<coadaMinim.size(); i++){
				ordine.add(coadaMinim.get(i));
			}
		}
	}
	
	public void afisare(){
		start();
		System.out.println("-----C-LOOK Disk Scheduling-----");
		System.out.print("Coada: ");
		for(int i=0; i<10; i++){
			System.out.print(coadaInitial[i] + " ");
		}
		System.out.println(" || Head: " + headInitial);
		// AFISARE ORDINE
		System.out.print("Ordinea: ");
		for(int nr : ordine){
			System.out.print(nr + " ");
		}
		System.out.println();
		//AFISARE TIMPI ACCES
		printAccessTime(ordine);
		System.out.println();
	}
}
