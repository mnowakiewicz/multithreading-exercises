package new2;

public class ImplementingRunnableInterface implements Runnable{
    private final String HELLO = "Hello2 ";

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
