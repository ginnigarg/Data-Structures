package Queues;

public interface QueueInterface {

    void enqueue(int val);

    int dequeue();

    int peek();

    int sizeOf();

    boolean isEmpty();

}
