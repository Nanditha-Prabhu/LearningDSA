#include<stdio.h>
#include<stdlib.h>

/*Breadth first search technique works on queues. It first traverses entire breadth before 
digging deep into one node. It uses queue data structure for implementation.*/
struct queue
{
    int size;
    int f;
    int r;
    int* arr;
};
 
 
int isEmpty(struct queue *q){
    if(q->r==q->f){
        return 1;
    }
    return 0;
}
 
int isFull(struct queue *q){
    if(q->r==q->size-1){
        return 1;
    }
    return 0;
}
 
void enqueue(struct queue *q, int val){
    if(isFull(q)){
        printf("This Queue is full\n");
    }
    else{
        q->r++;
        q->arr[q->r] = val;
        // printf("Enqued element: %d\n", val);
    }
}
 
int dequeue(struct queue *q){
    int a = -1;
    if(isEmpty(q)){
        printf("This Queue is empty\n");
    }
    else{
        q->f++;
        a = q->arr[q->f]; 
    }
    return a;
}
 
int main(){
    // Initializing Queue (Array Implementation)
    struct queue q;
    q.size = 100;
    q.f = q.r = 0;
    q.arr = (int*) malloc(q.size*sizeof(int));

    //bfs
    /*Understandable algo:
    Step 1: Select a node
    Step 2: Make it visited
    Step 3: Add it to queue*/
    int visited[5] ={ 0, 0, 0, 0, 0};
    int adjacency[5][5] = {
        {0,1,0,0,1},
        {1,0,1,1,1},
        {0,1,0,0,0},
        {0,1,0,0,0},
        {1,1,0,0,0}
    };

    /*Procedural Algo
    S1: Choose 1st node
    S2: print it
    S3: make it visited
    S4: enqueue
    S5: repeat for other nodes with loop*/
    int i=1;
    printf("%d", i);
    visited[i] = 1;
    enqueue(&q, i);

    while(!isEmpty(&q)){
        int n = dequeue(&q);
        for(int j=0; j<5; j++){
            if(adjacency[n][j]==1 && visited[j] == 0){
                printf("%d", j);
                visited[j] = 1;
                enqueue(&q, j);
            }
        }
    }
    return 0;
}