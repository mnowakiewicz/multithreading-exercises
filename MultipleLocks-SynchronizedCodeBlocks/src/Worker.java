import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Worker {

    private Random random;
    private List<Integer> list1;
    private List<Integer> list2;

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public Worker() {
        list2 = new LinkedList<>();
        list1 = new LinkedList<>();
        random = new Random();
    }

    public void stageOne() {
        synchronized (lock1) {
            waitOneMs();
            list1.add(random.nextInt(100));
        }

    }

    private void waitOneMs() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stageTwo() {
        synchronized (lock2) {
            waitOneMs();
            list2.add(random.nextInt(100));
        }
    }

    public void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public void main() {
        System.out.println("Starting...");

        long start = System.currentTimeMillis();

        Thread thread1 = getThread();
        Thread thread2 = getThread();
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("Time taken: " + (end - start));
        System.out.println("List1: " + list1.size() + "; List2: " + list2.size());
    }

    private Thread getThread() {
        return new Thread(() -> process());
    }
}
