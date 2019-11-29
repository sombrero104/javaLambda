/**
 * Thread 호출 기존방식과 람다식.
 */
public class ThreadEx2 {

    public static void main(String[] args) {

        /**
         * 1. 기존 방식
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World.");
            }
        }).start();

        /**
         * 2. 람다식
         * 1번을 람다식으로 표현. 코드량이 줄어든 것을 확인할 수 있다.
         */
        new Thread(()->{
            System.out.println("Hello World.");
        }).start();
    }

}
