package heap;

/**
 * Max Priority Queue Implementation
 * @author Sameesh
 * @param <Key> Generic param
 */
public class MaxPQ <Key extends Comparable<Key>>{

    /**
     * create a priority queue
     */
    public MaxPQ(){}

    /**
     * create a priority queue with intial capacity Max
     * @param max
     */
    public MaxPQ(int max){}

    /**
     * create a priority queue from the keys in arr
     * @param arr
     */
    public MaxPQ(Key[] arr){}

    /**
     * insert a key into priority queue
     * @param element
     */
    public void insert(Key element){}

    /**
     * return the largest key
     * @return
     */
    public Key max(){return null;}

    /**
     * return and removes the largest key
     * @return
     */
    public Key delMax(){return null;}

    /**
     * is the priority queue is empty?
     * @return
     */
    public boolean isEmpty(){return true;}

    /**
     * number of keys in the priority queue
     * @return
     */
    public int size(){return 0;}

}
