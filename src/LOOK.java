import java.util.Random;
import java.util.Vector;

public class LOOK extends AccessTime {
	int [] coada = new int[100];
	Vector<Integer> ordine = new Vector<Integer>();
	int head;
	int [] coadaInitial = new int[100];
	int headInitial;
	
	public LOOK(){}
	
	public void start(){
		// GENERARE COADA + HEAD
		Random rand = new Random();
		for(int i=0;i<10; i++){
			coada[i] = rand.nextInt(199) + 1;
			coadaInitial[i] = coada[i]; // COPY
		}
		head = rand.nextInt(199) + 1;
		headInitial = head;
		coada[10] = head; // ADD HEAD IN COADA
		sortArr(); // SORT CRESC

		// CAUTA POZITIA HEAD
		int headPos = 0;
		for(int i=0; i<10; i++){
			if(coada[i] == head){
				headPos = i;
				ordine.add(head);
			}
		}
		if(Math.abs(head-0) <= Math.abs(head-199)){
			for(int i=headPos+1; i<11; i++){
				ordine.add(coada[i]);
			}
			for(int i=headPos-1; i>=0; i--){
				ordine.add(coada[i]);
			}
		}
		else { // HEAD CLOSE TO LEFT
			for(int i=headPos+1; i<11; i++){
				ordine.add(coada[i]);
			}
			for(int i=headPos-1; i>=0; i--){
				ordine.add(coada[i]);
			}
		}
	}
	
	public void afisare(){
		start();
		System.out.println("-----LOOK Disk Scheduling-----");
		System.out.print("Coada: ");
		for(int i=0; i<10; i++){
			System.out.print(coadaInitial[i] + " ");
		}
		System.out.println(" || Head: " + headInitial);
		// AFISARE ORDINE
		System.out.print("Ordinea: ");
		for(int i=0; i<ordine.size(); i++){
			System.out.print(ordine.get(i) + " ");
		}
		System.out.println();
		// AFISARE TIMPI ACCES
		printAccessTime(ordine);
		System.out.println();
	}
	
	public void sortArr(){
		int temp;
		for(int i=0 ; i<11;i++){
			for(int j=0; j<11; j++){
				if(coada[i] > coada[j]){
					temp = coada[i];
					coada[i] = coada[j];
					coada[j] = temp;
				}
			}
		}
	}
}
