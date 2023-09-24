
public class ArraylistEfficiency {
	public static void main(String[] args) {
		ArrayList list  = new ArrayList();
		ArrayList list2 = new ArrayList();
		ArrayList list3 = new ArrayList();
		final int N = 2000000000; 
		System.out.println("N size: " + N);
				
		//add takes place at index 0.
		long startTime = System.currentTimeMillis();
		for(int count = 0; count < N; count++) {
			list.add(0, count);;
		}
		long endTime = System.currentTimeMillis();
		long elapsed = endTime - startTime;
		System.out.println("Time Adding at 0: " + elapsed + " ms");		
		
		//add takes place at index ()/2.
		long startTime2 = System.currentTimeMillis();
		for(int count = 0; count < N; count++) {
			list2.add((list2.size()/2), count);;
		}
		long endTime2 = System.currentTimeMillis();
		long elapsed2 = endTime2 - startTime2;
		System.out.println("Time Adding at ()/2: " + elapsed2 + " ms");	
		
		//add takes place at index ().
		long startTime3 = System.currentTimeMillis();
		for(int count = 0; count < N; count++) {
			list3.add((list3.size()), count);;
		}
		long endTime3 = System.currentTimeMillis();
		long elapsed3 = endTime3 - startTime3;
		System.out.println("Time Adding at (): " + elapsed3 + " ms");	
	}
}
