import java.util.LinkedList;
import java.util.Random;

public class Processor {

    private LinkedList<Integer> linkedList = new LinkedList<>();
    private final int LIMIT = 10;
    private  Object lock = new Object();

    public void produce() throws InterruptedException {
        int value = 0;
        while(true) {
            synchronized (lock){
                while(linkedList.size() == LIMIT){
                    lock.wait();
                }
                linkedList.add(value++);
                lock.notify();
            }

        }
    }

    public void consume() throws InterruptedException {
        while (true){
            synchronized (lock){
                while(linkedList.size() == 0){
                    lock.wait();
                }
                System.out.print("list size() "+linkedList.size());
                int value = linkedList.removeFirst();
                System.out.println("; value is: "+value);
                lock.notify();
            }
            Thread.sleep(new Random().nextInt(5000));
        }
    }
}
