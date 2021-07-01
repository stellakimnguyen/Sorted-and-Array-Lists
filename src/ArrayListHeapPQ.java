import java.util.ArrayList;

public class ArrayListHeapPQ<E extends Comparable<E>>
        implements MinPriorityQueue<E> {
    private ArrayList<E> heap;

    /**
     *  Constructor
     */
    public ArrayListHeapPQ() {
        heap = new ArrayList<E>();
    }

    public E extractMin() {
        if (heap.size() <= 0)
            return null;
        else {
            E minVal = heap.get(0);
            heap.set(0, heap.get(heap.size()-1));  // Move last to position 0
            heap.remove(heap.size()-1);
            minHeapify(heap, 0);
            return minVal;
        }
    }

    public E extractMax() {
        if (heap.size() <= 0)
            return null;
        else {
            E maxVal = maximum();
            heap.remove(maximum());
            return maxVal;
        }
    }

    public void insert(E element) {
        heap.add(element);        // Put new value at end;
        int loc = heap.size()-1;  // and get its location

        // Swap with parent until parent not larger
        while (loc > 0 && heap.get(loc).compareTo(heap.get(parent(loc))) < 0) {
            swap(heap, loc, parent(loc));
            loc = parent(loc);
        }
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public E minimum() {
        if (heap.size() <= 0)
            return null;
        else
            return heap.get(0);
    }

    public E maximum() {
        E maximumElement = heap.get(0);

        for (int i = 0; i < heap.size(); i++) {
            if (maximumElement.compareTo(heap.get(i)) < 0) {
                maximumElement = heap.get(i);
            }
        }

        return maximumElement;
    }

    public void printIndex(int index) {
        System.out.println(heap.get(index));
    }

    private static <E extends Comparable<E>> void minHeapify(ArrayList<E> a, int i) {
        int left = leftChild(i);    // index of node i's left child
        int right = rightChild(i);  // index of node i's right child
        int smallest;    // index of the node with the smallest element

        // Is there a left child
        // AND does the left child have an element smaller than node i
        if (left <= a.size()-1 && a.get(left).compareTo(a.get(i)) < 0)
            smallest = left;   // left child is smallest
        else
            smallest = i;      // node i is smallest

        // Is there a right child
        // AND does the right child have an element smaller than the smaller of node i and the left child
        if (right <= a.size()-1 && a.get(right).compareTo(a.get(smallest)) < 0)
            smallest = right;  // yes, so the right child is the smallest

        // If node i holds an element smaller than both the left and right
        // children, then the max-heap property already held, and we need do
        // nothing more.  Otherwise, we need to swap node i with the smaller
        // of the two children, and then recurse down the heap from the smaller child.
        if (smallest != i) {
            swap(a, i, smallest);
            minHeapify(a, smallest);
        }
    }

    // Swap two locations i and j in ArrayList a.
    private static <E> void swap(ArrayList<E> a, int i, int j) {
        E t = a.get(i);
        a.set(i, a.get(j));
        a.set(j, t);
    }

    // Return the index of the left child of node i.
    private static int leftChild(int i) {
        return 2*i + 1;
    }

    // Return the index of the right child of node i.
    private static int rightChild(int i) {
        return 2*i + 2;
    }

    // Return the index of the parent of node i
    // (Parent of root will be -1)
    private static int parent(int i) {
        return (i-1)/2;
    }

    //Testing
//    public static void main (String [] args)  {
//        System.out.println(parent(0));
//        MinPriorityQueue<String> pq = new ArrayListHeapPQ<String>();
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
//        System.out.println("Biggest is: " + pq.extractMax());
//        System.out.println("Next biggest is: " + pq.extractMax());
//        System.out.println("Next biggest is: " + pq.extractMax());
//    }
}