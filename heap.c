/* HEAP */

//implement max heap
#include <stdio.h>
#define MAX 20 /*Maximum elements it can store*/
#define SWAP(a,b,c) c=a;a=b;b=c;

/*In max heap root node is highest.
insertion goes from bottom to top.
deletion goes from top to bottom.*/

void satisfyHeap(int a[], int n, int i){
    /*This is helper function for insertin to satisfy heap condition*/
    /*n is passed by value as no change in n will be made*/
    int parent = (i-1)/2;
    int temp;
    if(parent>=0){
        if(a[i] > a[parent]){
            temp = a[i];
            a[i] = a[parent];
            a[parent] = temp;

            satisfyHeap(a, n, parent);
        }
    }
}

void insert(int a[], int *n, int val){
    /*Insert as leaf*/
    /*n is passed by reference as it will change the value altogether*/
    (*n)++;
    a[*n-1] = val;
    satisfyHeap(a, *n, *n-1);
}

void delete(int a[], int *n){
    /*Remove root*/
    /*n is passed by reference as it will change the value altogether*/
    a[1] = a[*n-1];
    (*n) --;

    /*Helper block of code to satisfy heap condn*/
    int i = 1;
    int temp;
    while(i<(*n)){
        int l = a[2*i];
        int r = a[2*i + 1];
        int large = (l>r)? (2*i) : (2*i+1);
        if(a[i]<a[large]){
            SWAP(a[i], a[large], temp);
            i = large;
        }
        else{
            return;
        }
    }
}

int main(){
    /*Number of value in the array including the first zero*/
    /*The first value is made zero. It is not the part of the heap. 
    It is 0 because we need index to be starting from 1. 
    Or else child node calculation cannot be done properly.*/
    int n = 9;
    int heap[MAX] = {0, 30, 25, 23, 15, 16, 19, 22, 2};
    insert(heap, &n, 7);
    for(int i=1; i<n; i++){
        printf("%d\t", heap[i]);
    }
    printf("\n");
    delete(heap, &n);
    for(int i=1; i<n; i++){
        printf("%d\t", heap[i]);
    }
    return 0;
}

