import java.util.NoSuchElementException;

	
public class MinPQ<Key extends Comparable<Key>> {

	private Key[] pq;
	private Map<Integer, Integer> indexlist;
	private int N = 0;
	
	public MinPQ(int maxN){
		pq = (Key[]) new Comparable[maxN+1];
		indexlist = new HashMap<Integer, Integer>(maxN);
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	public void insert(Key v){
		pq[++N] = v;
		swim(N);
	}
	
	public Key delMin(){
		Key min = pq[1];
		exch(1, N--);
		pq[N+1] = null;
		sink(1);
		return min;
	}
	
	private  boolean great(int i, int j){
		return pq[i].compareTo(pq[j]) > 0;
	}
	
	private void exch(int k, int j){
		Key t = pq[k]; 
		pq[k] = pq[j]; 
		pq[j] = t;
	}
	
	private void swim(int k){
		while (k>1 && great(k/2, k)){
			exch(k/2, k);
			k = k/2;
		}
	}
	
	private void sink(int k){
		while (2*k <= N){
			int j = 2*k;
			if (j<N && great(j, j+1)) j++;
			if (!great(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	
}
