/*HEAPSORT*/
#include <stdio.h>

void swap(int a[], int i, int j){
    /*Better to take input as (array, index1, index2) or else pass by reference. If you try to take 
    just 2 no's as input it will not swap the elements globally.*/
    int temp = a[i]; 
    a[i] = a[j];
    a[j] = temp;
}

/*This is for subset of tree array*/
void heapify(int a[], int n, int i){
    /*This converts the given subtree into a heap by recursion.*/
    /*Note that n is total number of elements. So, all calculations will be made for n-1 elements.*/
    int largest = i;
    /*Here we consider the array starts from 1.*/
    int l = 2*i; //leftchild
    int r = 2*i+1; //rightchild
    if(l<n && a[l]>a[largest] ){
        largest = l;
    }
    if(r<n && a[r]>a[largest] ){
        largest = r;
    }
    if(largest != i){
        swap(a, i, largest);
        heapify(a, n, largest);
    }
}

/*This is for entire tree array*/
void buildheap(int a[], int n){
    /*Ensures that entire tree is converted into heap.*/
    for(int i=(n-1)/2 -1; i>0; i--){
        heapify(a, n, i);
    }
}

void heapsort(int a[], int n){
    /*The main sorting function*/
    buildheap(a, n); /*First: convert the given array to heap*/
    for(int i=n-1; i>1; i--){ /*Second: Sort it*/
        swap(a, i, 1);
        heapify(a, i, 1);
    }
}

int main(){
    int n = 9;
    /*As we need 1 based indexing for array, first element is made to zero;)*/
    int heap[9] = {0, 15, 25, 16, 30, 19, 23, 18, 2};
    heapsort(heap, n);
    for(int i=1; i<n; i++){
        printf("%d\t", heap[i]);
    }
    printf("\n");
    return 0;
}