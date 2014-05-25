public class Driver {
	private static int N = 50;
	private static int keyRange = 10;
	private static int tests = 10;
	
	public static void main(String[] args){
		MaxPQ<Integer> pq = new MaxPQ<>();
		fillMaxPQ(pq);
		int count;
		for(int i=0; i<tests; i++){
			count = test(pq);
			System.out.println(i + " " + count + " " + keyRange);
			keyRange *= 10;
		}
	}
	
	private static int test(MaxPQ<Integer> pq){
		double time = 0;
		int times = 10;
		int k = 0, sum = 0;
		for(int m=0; m<times; m++){
			while(time < 1){
				if(!pq.isEmpty()){
					time += time(pq);
					k++;
				}
				else
					fillMaxPQ(pq);
			}
			time = 0;
			sum += k;
			k = 0;
		}
		return sum/times;
	}
	
	private static double time(MaxPQ<Integer> pq){
		Stopwatch timer = new Stopwatch();
		pq.delMax();
		return timer.elapsedTime();
	}
	
	private static void fillMaxPQ(MaxPQ<Integer> pq){
		while(pq.size() < N){
			pq.insert(StdRandom.uniform(keyRange));
		}
	}
}
