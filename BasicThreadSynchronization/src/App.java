import java.util.Scanner;

public class App {
    public static void main(String args[]){
        Processor processor1 = new Processor();
        processor1.start();

        System.out.println("Press any key to shutdown the loop...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        processor1.shutdown();

    }
}

class Processor extends Thread {
    private volatile boolean running = true;

    public void shutdown() {
        this.running = false;
    }

    @Override
    public void run() {
        while(running){
            System.out.println("Hello");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

