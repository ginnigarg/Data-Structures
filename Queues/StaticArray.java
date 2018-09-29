package Queues;

public class StaticArray implements QueueInterface {

    int arr[] = new int[10];
    int head = -1;
    int tail = -1;

    public void enqueue(int val) {
        if(tail == 10) {
            System.out.println("Queue Overflow");
            return;
        }
        if(head == -1) head++;
        arr[++tail] = val;
    }

    public int dequeue() {
        if(head < 0) {
            System.out.println("Queue Underflow");
            return -999999;
        }
        return arr[head--];
    }

    public int peek() {
        if(head < 0) {
            System.out.println("Queue  Empty");
        }
        return arr[head];
    }

    public int sizeOf() {
        if(tail == -1 && head == -1) return 0;
        return (tail - head);
    }

    public boolean isEmpty() {
        return (sizeOf() == 0);
    }

}
