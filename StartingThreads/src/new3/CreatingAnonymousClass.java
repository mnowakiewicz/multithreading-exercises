package new3;



public class CreatingAnonymousClass {
    public static void main (String args[]){

        Thread t1 = new Thread(() -> {
            for(int i = 0; i<5; i++){
                System.out.println("Hello "+i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
    }
}
