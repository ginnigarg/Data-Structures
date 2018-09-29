public class PriorityQueue {

    Node arr[] = new Node[1000];
    int size = 0;

    private void swap(int i, int j) {
            Node temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
    }

    private void swim(int i) {
	if(arr[i].priority <= arr[i / 2].priority) return;
        swap(i, i / 2);
        swim(i / 2);
    }

    private void sink(int i) {
        int leftChild = 2 * i;
        int rightChild = leftChild + 1;

        if(leftChild >= size && rightChild >= size) return;
	if(arr[i].priority >= arr[leftChild].priority && arr[i].priority >= arr[rightChild].priority) return;
        int max = i;
        if(leftChild < size && arr[max].priority < arr[leftChild].priority) {
            max =  leftChild;
        }
        if(rightChild < size && arr[max].priority < arr[rightChild].priority) {
            max = rightChild;
        }
        swap(i, max);
        sink(max);
    }

    public void enqueue(int data, int priority) {
        if(size >= 1000) {
            System.out.println("Queue Overflow");
            return;
        }
        arr[size] = new Node(data, priority);
        swim(size);
        System.out.println(arr[size].data);
        size++;
    }

    public Node dequeue() {
        if(size <= 0) {
            System.out.println("Queue Underflow");
            return null;
        }
        Node temp = arr[0];
        arr[0] = arr[size - 1];
        sink(0);
        size--;
        return temp;
    } 

    public Node peek() {
        if(size == 0) {
            System.out.println("Queue Empty");
            return null;
        }
        return arr[0];
    }


    public boolean isEmpty() {
        return (size == 0);
    }

    public static void main(String args[]) {
        PriorityQueue q = new PriorityQueue();
        int j = 20;
        for(int i = 0; i < 10 ; i++) {
            q.enqueue(i, j++);
        }
        while(!q.isEmpty()) {
            System.out.println(q.peek().data + " "  + q.peek().priority);
            //System.out.println(q.dequeue().data);
        }
    }





}

class Node {

    int data;
    int priority;

    Node(int data, int priority) {
        this.data = data;
        this.priority = priority;
    }

}
