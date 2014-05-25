
public class Main {
	    public static void main(String[] args) { 
	    	StdOut.println("Debug? (y/n)");
	    	boolean fl = (StdIn.readChar() == 'y') ? true : false;
	        task1(fl);
	        StdOut.println("\nNext example? (y/n)");
	        StdIn.readLine();
	        fl = (StdIn.readChar() == 'y') ? true : false;
	    	if(fl){
	    		StdOut.println("Debug? (y/n)");
	    		StdIn.readLine();
		    	fl = (StdIn.readChar() == 'y') ? true : false;
	    		task2(fl);
	    	}
	    }
	    
	    private static void task1(boolean fl){
	    	MyQueue<Integer, Integer> queue = new MyQueue<>();
	    	for (int i = 0; i<7; i++) {
	            Integer key = i;
	            queue.put(key, i);
	        }
	    	for (int i = 10; i<13; i++) {
	            Integer key = i;
	            queue.put(key, i);
	        }
	    	queue.show("Queue");
	    	Integer n = 6;
	    	MyQueue<Integer,Integer> insQueue = new MyQueue<>();
	    	for (int i = 7; i<10; i++){
	    		Integer key = i;
	    		insQueue.put(key, i);
	    	}
	    	insQueue.show("insQueue");
	    	MyQueue<Integer, Integer> newQueue = queue.insertAfter(n, insQueue, fl);
	    	newQueue.show("newQueue");
	    }
	    
	    private static void task2(boolean fl){
	    	String firstStart = "ABCDEFGHIJKLMNO";
	    	String firstEnd = "UVWXYZ";
	    	String second = "PQRST";
	    	MyQueue<String, Integer> queue = new MyQueue<>();
	    	for (int i = 0; i<firstStart.length(); i++) {
	            String key = firstStart.charAt(i) + "";
	            queue.put(key, i);
	        }
	    	for (int i = 0; i<firstEnd.length(); i++) {
	            String key = firstEnd.charAt(i) + "";
	            queue.put(key, i);
	        }
	    	queue.show("Queue");
	    	String a = "O";
	    	MyQueue<String,Integer> insQueue = new MyQueue<>();
	    	for(int i=0; i<second.length(); i++){
	    		String key = second.charAt(i) + "";
	    		insQueue.put(key, i);
	    	}
	    	insQueue.show("insQueue");
	    	MyQueue<String, Integer> newQueue = queue.insertAfter(a, insQueue, fl);
	    	newQueue.show("newQueue");
	    }
}
