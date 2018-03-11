import new1.ExtendingThreadClass;
import new2.ImplementingRunnableInterface;

public class Main {
    public static void main(String[] args) {
        ExtendingThreadClass runner1 = new ExtendingThreadClass();
        runner1.start();

        ExtendingThreadClass runner2 = new ExtendingThreadClass();
        runner2.start();

        Thread t1 = new Thread(new ImplementingRunnableInterface());
        t1.start();



    }
}
