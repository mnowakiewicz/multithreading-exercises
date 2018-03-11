import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args){
        ExecutorService service = Executors.newFixedThreadPool(2);

        for(int i=1; i<=6; i++){
            service.submit(new Processor(i));
        }

        service.shutdown();

        System.out.println("All tasks submitted.");

        try {
            service.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed.");
    }
}

class Processor implements Runnable{
    private int id;

    public Processor(int id){
        this.id=id;
    }

    @Override
    public void run() {
        System.out.println("Starting: "+id+" task");

        wait500ms();

        System.out.println("Completed: "+id+" task");
    }

    private void wait500ms() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}