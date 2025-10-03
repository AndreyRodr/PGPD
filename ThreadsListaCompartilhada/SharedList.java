import java.util.LinkedList;
import java.util.List;


public class SharedList {
    private final List<Integer> list = new LinkedList<>();

    public void produce(int value) throws InterruptedException {
        synchronized (this) {
            // Região crítica pois modifica uma lista compartilhada comoutra thread
            int capacity = 5;
            while (list.size() == capacity) {
                System.out.println("A lista está cheia. O produtor está aguardando...");
                wait();
            }
            list.add(value);
            System.out.println("Produzido: " + value);
            notifyAll();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            // Região crítica pois modifica uma lista compartilhada comoutra thread
            while (list.isEmpty()) {
                System.out.println("A lista está vazia. O consumidor está aguardando...");
                wait();
            }
            int value = list.removeFirst();
            System.out.println("Consumido: " + value);

            notifyAll();
        }
    }
}

