import java.util.*;

public class Circularq {
    int[] a = new int[20] ;
    int n, front, rear;
    Circularq(int n){
        this.n = n;
        this.front = -1;
        this.rear = -1;
    }
    void enqueue(int data){
        if(((this.rear)+1)%(n) == (this.front)){
            return;
        }
        if(this.front == -1){
            this.front = 0;
            this.rear = ((this.rear)+1)%(n);
            this.a[this.rear] = data;
        }
    }
    int dequeue(){
        if(this.front == -1){
            System.out.println("Exception");
        }
        int result = this.a[this.front];
        if(this.front == this.rear){
            this.front = this.rear = -1;
        }
        else{
            this.front = ((this.front)+1)%(n);
        }
        return result;
    }
    public static void main(String[] args){
        Circularq c = new Circularq(5);
        Scanner s = new Scanner(System.in);
        for(int i=0; i<(this.n); i++){
            c.a[i] = s.nextInt();
        }
        s.close();
        int m = c.dequeue();
        System.out.println(m);
        c.enqueue(11);
        c.enqueue(12);
        for(int i=0; i<this.n; i++){
            System.out.println(c.a[i]);
        }
    }
}
