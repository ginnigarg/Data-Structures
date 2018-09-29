package Queues;

public class Main {

    static void test(QueueInterface q) {
        for(int i = 0; i < 11; i++) {
            q.enqueue(i);
        }
        for(int i = 0; i < 11; i++) {
            System.out.println(q.peek() + " "  + q.dequeue());
        }
    }

    public static void main(String args[]) {
        test(new StaticArray());
    }



}
