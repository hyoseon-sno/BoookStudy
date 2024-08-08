/*
volatile 사용
*/

public class Test {
    boolean flag = true; //volatile 사용 전
    volatile boolean flag = true;  // volatile 사용 후

    public void test() {
        new Thread(() -> {
            int cnt = 0;
            while (flag) {
                cnt++;
            }
            System.out.println("Thread1 finished\n");
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
            System.out.println("flag to false");
            flag = false;
        }).start();
    }

    public static void main(String[] args) {
        new Test().test();
    }
}
