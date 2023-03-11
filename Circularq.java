public class Circularq
    int a[];
    int n, front, rear;
    public Circularq(int n){
        this.n = n;
        this.a = new int[n];
    }
    void enqueue(int data){
        if((rear+1)%n == front){
            return;
        }
        if(front == -1){
            front = 0;
            rear = (rear+1)%n;
            a[rear] = data;
        }
    }
    int dequeue(){
        if(front == -1){
            System.out.println("Exception");
        }
        int result = a[front];
        if(front == rear){
            front = rear = -1;
        }
        else{
            front = (front+1)%n;
        }
        return result;
    }
}
