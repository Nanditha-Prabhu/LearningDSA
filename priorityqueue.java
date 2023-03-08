// /* Priority queue implementation in java using inbuilt class. */
// import java.util.*;

// public class priorityqueue{
//     public static void main(String[] args) {
//         /* This class is a member of the Java Collections Framework. */
//         PriorityQueue <Integer> pq = new PriorityQueue<>();
//         pq.add(20); /* push elements */
//         pq.add(48);
//         pq.add(10);
//         pq.add(63);
//         /* By default Java creates a MINHEAP i.e; minimum element has highest priority */
//         System.out.println("Size: "+pq.size());
//         System.out.println("Elements:");
//         while(! pq.isEmpty()){
//             /* retrieve first element of heap. */
//             System.out.println(pq.peek());
//             /* pop element feature of the queue. */
//             pq.poll();
//         }
//     }
// }

/* Procedural implementation of priority queue using binary heap */
import java.util.*;

public class priorityqueue{
    static int[] heap  = {15, 25, 16, 30, 19, 23, 18, 2};

    void swap(int a, int b){
        int temp = priorityqueue.heap[a];
        priorityqueue.heap[a] = priorityqueue.heap[b];
        priorityqueue.heap[b] = temp;
    }

    void heapify(int n, int i){
        /*This converts the given subtree into a heap by recursion.*/
        /*Note that n is total number of elements. So, all calculations will be made for n-1 array indices.*/
        int largest = i;
        /*Here we consider the array starts from 1.*/
        int l = 2*i+1; //leftchild
        int r = 2*i+2; //rightchild
        if(l<n && priorityqueue.heap[l]>priorityqueue.heap[largest] ){
            largest = l;
        }
        if(r<n && priorityqueue.heap[r]>priorityqueue.heap[largest] ){
            largest = r;
        }
        if(largest != i){
            swap(i, largest);
            heapify(n, largest);
        }
    }

    void buildpq(int n){
        /*Ensures that entire tree is converted into heap.*/
        for(int i=n/2 -1; i>=0; i--){
            heapify(n, i);
        }
    }

    void highestPriority(){
        System.out.println("Highest Priority: "+priorityqueue.heap[0]);
    }

    public static void main(String[] args){
        int n = priorityqueue.heap.length;
        priorityqueue p = new priorityqueue();
        p.buildpq(n);
        for(int i=0; i<n; i++){
            System.out.print(heap[i]+"\t");
        }
        System.out.println();
        p.highestPriority();
    }
}