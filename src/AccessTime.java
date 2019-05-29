import java.util.Vector;

public class AccessTime {
	final int searchTime = 5;
	final int latency = 5;
	final int transferTime = 10;
	
	
	public void printAccessTime(Vector<Integer> ordine){
		int[] accessTime = new int[10];
		int Z = Math.abs(ordine.get(1) - ordine.get(0));
		accessTime[1] = transferTime + latency + (searchTime + 3*Z);
		System.out.print("T1= " + accessTime[1] + " || ");
		for(int i=2;i<10-1; i++){
			int T = Math.abs(ordine.get(i) - ordine.get(i-1));
			accessTime[i] = transferTime + latency + (searchTime + 3*T) + accessTime[i-1];
			System.out.print("T" + i + "= " + accessTime[i] + " || ");
		}
		System.out.println();
	}
	
}
