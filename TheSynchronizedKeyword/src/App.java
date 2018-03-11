public class App {
    private int count = 0;

    public static void main(String[] args){
        App app = new App();
        app.doWork();
    }

    private void doWork() {
        Thread t1 = new Thread(() -> {
            for(int i=0; i<10000; i++){
                counting();
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i=0; i<10000; i++){
                counting();
            }
        });
        Thread t3 = new Thread(() -> {
            for(int i=0; i<10000; i++){
                counting();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }

    private synchronized void counting() {
        count++;
    }
}
