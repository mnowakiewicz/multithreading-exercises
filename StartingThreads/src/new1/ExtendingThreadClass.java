package new1;

public class ExtendingThreadClass extends Thread {

    public final String HELLO = "Hello ";

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println(HELLO +i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
