import java.util.ArrayList;

public class SortedListPQ<E extends Comparable<E>> implements MinPriorityQueue<E> {
    private ArrayList<E> list; //queue items

    //CONSTRUCTOR
    public SortedListPQ() {
        list = new ArrayList<E>();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void insert(E element) {
        int p;  // Current position in the list.

        for (p = list.size(); p > 0 && list.get(p-1).compareTo(element) < 0; p--) // go through list from min until next element is larger
            ; // break when larger element has been found

        list.add(p, element);
    }

    public E minimum() {
        if (list.size() == 0)
            return null;
        else
            return list.get(list.size() - 1);  // Last item is smallest
    }

    public E maximum() {
        if (list.size() == 0)
            return null;
        else
            return list.get(0);  // first item is smallest
    }

    public E extractMin() {
        if (list.size() == 0)
            return null;
        else {                                // Shrink the size
            return list.remove(list.size()-1);  // and return the highest
        }
    }

    public E extractMax() {
        if (list.size() == 0)
            return null;
        else {                                // Shrink the size
            return list.remove(0);  // and return the lowest
        }
    }

    public void printIndex(int index) {
        System.out.println(list.get(index));
    }

    // Testing
    public static void main (String [] args)  {
        MinPriorityQueue<Job> pq = new SortedListPQ<Job>();
//        pq.insert("cat");
//        pq.insert("dog");
//        pq.insert("sheep");
//        pq.insert("cow");
//        pq.insert("eagle");
//        pq.insert("bee");
//        pq.insert("lion");
//        pq.insert("tiger");
//        pq.insert("zebra");
//        pq.insert("ant");
//        System.out.println("Bigger example:");
//        System.out.println("Smallest is: " + pq.extractMin());
//        System.out.println("Next smallest is: " + pq.extractMin());
//        System.out.println("Next smallest is: " + pq.extractMin());
//        System.out.println("Next smallest is: " + pq.extractMin());
//        System.out.println("Next smallest is: " + pq.extractMin());
//        System.out.println("Next smallest is: " + pq.extractMin());
//        System.out.println("Next smallest is: " + pq.extractMin());
//        System.out.println("Next smallest is: " + pq.extractMin());
//        System.out.println("Next smallest is: " + pq.extractMin());
//        System.out.println("Next smallest is: " + pq.extractMin());
//        System.out.println("Next smallest is: " + pq.extractMin());
    }
}