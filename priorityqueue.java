/* Priority queue implementation in java using inbuilt class. */
import java.util.*;

public class priorityqueue{
    public static void main(String[] args) {
        /* This class is a member of the Java Collections Framework. */
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        pq.add(20); /* push elements */
        pq.add(48);
        pq.add(10);
        pq.add(63);
        /* By default Java creates a MINHEAP i.e; minimum element has highest priority */
        System.out.println("Size: "+pq.size());
        System.out.println("Elements:");
        while(! pq.isEmpty()){
            /* retrieve first element of heap. */
            System.out.println(pq.peek());
            /* pop element feature of the queue. */
            pq.poll();
        }
    }
}