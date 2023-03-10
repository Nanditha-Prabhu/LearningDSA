/* We implement how to find kth largest element in an array which is the implementation of priority 
 * queue using binary heap. Basically if we must find kth largest element then we construct a heap
 * of size k and peak the element. Coz java by default if we use inbuilt class constructs a minheap
 * kth largest element will be smallest among last 'k' elements of the min heap. If we must find 
 * the smallest element we must create a maxheap. 
 */
import java.util.*;

public class kthEleInPQ {
    static int[] array = {4, 89, 26, 42, 97, 11, 50, 28};
    int kthlargest(int[] a, int k){
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        /* Create a heap of 1st k elements. */
        for(int i=0; i<k; i++){
            pq.add(a[i]);
        }
        /* Add remaining element one by one till the last element.
         * Then finally peek.
         */
        for(int i=k; i<a.length; i++){
            if(a[i]>pq.peek()){
                pq.poll(); // analogous to pop
                pq.add(a[i]);
            }
        }
        return pq.peek();
    }
    public static void main(String[] args){
        kthEleInPQ p = new kthEleInPQ();
        int ans = p.kthlargest(array, 6);
        System.out.println(ans);
    }
}
