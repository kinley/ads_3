import java.util.Comparator;
import java.util.Iterator;

public class MinPriorityQueue<Key> implements Iterable<Key> {
    private Key[] pq; //пирамидально упорядоченное полное бинарное дерево
    private int N; // в элементах pq[1..pq] (pq[0] не используется)
    private Comparator<Key> comparator;
    public MinPriorityQueue(int minN) {
        pq = (Key[]) new Object[minN + 1];
        N = 0;
    }
    public MinPriorityQueue() {
    	this(1);
    }
    public MinPriorityQueue(int minN, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[minN + 1];
        N = 0;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    public Key min() {
        return pq[1];
    }
    private void resize(int capacity) {
        assert capacity > N;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= N; i++) temp[i] = pq[i];
        pq = temp;
    }
    public void insert(Key x) {
        if (N == pq.length - 1) resize(2 * pq.length);
        pq[++N] = x;
        swim(N);
        assert isMinHeap();
    }
    public Key delMin() {
        exch(1, N);
        Key min = pq[N--];
        sink(1);
        pq[N+1] = null;
        if ((N > 0) && (N == (pq.length - 1) / 4)) resize(pq.length  / 2);
        assert isMinHeap();
        return min;
    }
    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }
    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    private boolean greater(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }
    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
   private boolean isMinHeap() {
        return isMinHeap(1);
    }
    private boolean isMinHeap(int k) {
        if (k > N) return true;
        int left = 2*k, right = 2*k + 1;
        if (left  <= N && greater(k, left))  return false;
        if (right <= N && greater(k, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }
    public Iterator<Key> iterator() {
    	return new HeapIterator();
    }
    private class HeapIterator implements Iterator<Key> {
        private MinPriorityQueue<Key> copy;
        public HeapIterator() {
            if (comparator == null) copy = new MinPriorityQueue<Key>(size());
            else                    copy = new MinPriorityQueue<Key>(size(), comparator);
            for (int i = 1; i <= N; i++)
                copy.insert(pq[i]);
        }
        public boolean hasNext()  {
        	return !copy.isEmpty();
        }
        public void remove() {
        	throw new UnsupportedOperationException();
        }
        public Key next() {
            return copy.delMin();
        }
    }
}