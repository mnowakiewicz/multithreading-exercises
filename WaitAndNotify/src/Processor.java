import java.util.Scanner;

public class Processor {
    Object lock = new Object();
    public void produce() throws InterruptedException{
        synchronized (this) {
            System.out.println("Producer thread running...");
            wait();
            System.out.println("Resumed.");
        }
    }

    public void consumer() throws InterruptedException{
        Thread.sleep(2000);
        Scanner sc = new Scanner(System.in);
        synchronized (this) {
            System.out.println("waiting for return key.");
            sc.nextLine();
            System.out.println("Return key pressed.");
            notify();
            Thread.sleep(2000);
            System.out.println("After notify");

        }

    }
}
