public class Queue {
    private static int front, rear, capacity;
    private static int[] queue;

    Queue(int size) {
        front = rear = 0;
        capacity = size;
        queue = new int[capacity];
    }

    // insert an element into the queue
    void queueEnqueue(int item)  {
        // check if the queue is full
        if (capacity == rear) {
            System.out.print("\nQueue is full\n");
        }

        // insert element at the rear
        else {
            queue[rear] = item;
            rear++;
        }
    }

    //remove an element from the queue
    void queueDequeue()  {
        // check if queue is empty
        if (front == rear) {
            System.out.print("\nQueue is empty\n");
        }

        // shift elements to the right by one place uptil rear
        else {
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }


            // set queue[rear] to 0
            if (rear < capacity)
                queue[rear] = 0;

            // decrement rear
            rear--;
        }
    }

    // print queue elements
    void queueDisplay()
    {
        int i;
        if (front == rear) {
            System.out.print("Queue is Empty\n");
            return;
        }

        // traverse front to rear and print elements
        for (i = front; i < rear; i++) {
            System.out.printf(" %d = ", queue[i]);
        }
    }

    // print front of queue
    void queueFront()
    {
        if (front == rear) {
            System.out.print("Queue is Empty\n");
            return;
        }
        System.out.printf("\nFront Element of the queue: %d", queue[front]);
    }

    public static void main(String[] args) {
        // Create a queue of capacity 4
        Queue q = new Queue(4);

        System.out.println("Initial Queue:");
        // print Queue elements
        q.queueDisplay();

        // inserting elements in the queue
        q.queueEnqueue(10);
        q.queueEnqueue(30);
        q.queueEnqueue(50);
        q.queueEnqueue(70);

        // print Queue elements
        System.out.println("Queue after Enqueue Operation:");
        q.queueDisplay();

        // print front of the queue
        q.queueFront();

        // insert element in the queue
        q.queueEnqueue(90);

        // print Queue elements
        q.queueDisplay();

        q.queueDequeue();
        q.queueDequeue();
        System.out.print("\nQueue after two dequeue operations:");

        // print Queue elements
        q.queueDisplay();

        // print front of the queue
        q.queueFront();
    }
}



