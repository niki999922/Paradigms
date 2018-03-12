package queue;

public class testLink {
    static void print(Queue el) {
        while (!el.isEmpty()) System.out.print(el.dequeue()+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        print(queue);
        queue.enqueue("lol");
        System.out.println(queue.element());
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        queue.dequeue();
        for(Object el :queue.toArray()) {
            System.out.print(el + " ");
        }
        System.out.println();
    }
}
