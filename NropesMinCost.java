/* PRIORITY QUEUE */
/* Connect n ropes with minimum cost. Where n is the size of given array */

import java.util.*;

public class NropesMinCost {
    // Array must be static.
    static int[] array = {4, 89, 26, 42, 97, 11, 50, 28};

    int minCost(int[] a){
        /* We are using inbuilt class from java.util.* to make our task easy. */
        PriorityQueue <Integer> pq = new PriorityQueue<>();

        /* Add all elements to the pq */
        for(int i=0; i<a.length; i++){
            pq.add(a[i]);
        }

        /* Select the 2 minimum elements and add them i.e; first 2 elements from minheap or pq where
         * minimum element has the priority. And go on adding their sum to the cost. 
        */
        int cost = 0;
        while(pq.size()>1){ //Till there are atleast 2 elements in the pq
            int smallest1 = pq.poll();
            int smallest2 = pq.poll();
            int sum = smallest1 + smallest2;
            cost += sum;
            pq.add(sum); // Add the sum back to the pq and among them select the minimum 2.
        }
        return cost;
    }
    public static void main(String[] args){
        NropesMinCost n = new NropesMinCost();
        System.out.println(n.minCost(array));
    }
}
