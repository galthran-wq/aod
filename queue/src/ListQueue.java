public class ListQueue {
    private Node front, rear;
    private int queueSize; // queue size

    //linked list node
    private class Node {
        int data;
        Node next;
    }

    //default constructor - initially front & rear are null; size=0; queue is empty
    public ListQueue() {
        front = null;
        rear = null;
        queueSize = 0;
    }


    //check if the queue is empty
    public boolean isEmpty() {
        return (queueSize == 0);
    }

    //Remove item from the front of the queue.
    public int dequeue() {
        int data = front.data;
        front = front.next;
        if (isEmpty())
        {
            rear = null;
        }
        queueSize--;
        System.out.println("Element " + data + " removed from the queue");
        return data;
    }

    //Add data at the rear of the queue.
    public void enqueue(int data) {
        Node oldRear = rear;
        rear = new Node();
        rear.data = data;
        rear.next = null;
        if (isEmpty())
        {
            front = rear;
        }
        else  {
            oldRear.next = rear;
        }
        queueSize++;
        System.out.println("Element " + data+ " added to the queue");
    }

    public int peek() {
        return front.data;
    }

    public static void main(String[] a) {

        ListQueue queue = new ListQueue();

        queue.enqueue(6);
        queue.peek();

        queue.enqueue(3);
        queue.peek();

        queue.enqueue(12);
        queue.peek();

        queue.enqueue(24);
        queue.peek();

        queue.dequeue();
        queue.peek();

        queue.dequeue();
        queue.peek();

        queue.enqueue(9);
        queue.peek();
    }
}
