/**
 * Thread 호출.
 */
public class ThreadEx {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for(int i=0; i<10; i++) {
                System.out.println(i);
            }
        });
        thread.start();
    }

}
