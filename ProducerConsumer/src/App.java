import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public static void main(String args[]) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();


        t1.join();
        t2.join();

    }

    private static void producer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            Integer number = random.nextInt(100);
            queue.put(number);
            System.out.println("Queue put: "+number);
        }
    }

    private static void consumer() throws InterruptedException {
        while (true) {

            Thread.sleep(250);

            Random random = new Random();
            if (random.nextInt(10) == 0) {
                Integer value = queue.take();

                System.out.println("Taken value: " + value + "; Queue size is: " + queue.size());
            }
        }
    }
}

