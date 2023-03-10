/* GRAPHS */
#include<stdio.h>

/*Depth first search traverses till the final node of a depth is reached.
Then comes back to the previous node to dig deep into other unvisited nodes.
It uses stack data structure. But we didnot implement stack as a data structure here.
coz functions by itself use stack in the memory.
hence by using recursion we indirectly made use of stack.*/
int visited[5] ={ 0, 0, 0, 0, 0};
int adjacency[5][5] = {
    {0,1,0,0,1},
    {1,0,1,1,1},
    {0,1,0,0,0},
    {0,1,0,0,0},
    {1,1,0,0,0}
};

void dfs(int n){
    /*s1: print
    s2: set as visited
    s3: call the fn recursively for child node*/
    printf("%d\t", n);
    visited[n] = 1;
    for(int i=0; i<5; i++){
        if(visited[i]==0 && adjacency[n][i] ==1){
            dfs(i);
        }
    }
}
int main(){
    
    dfs(2);
    
    return 0;
}