/*
기본 싱글톤 예제 코드
-> 원자성 없음, 멀티 스레드 x
    (java는 멀티 스레드를 위한 언어임)

*/

public class Singleton01_01{
    private static Singleton01_01 instance:

    private Singleton01_01() {

    }

    public static Singleton01_01 getInstance() {
        if (instance == null) {
            instance = new Singleton01_01();
        }
        return instance;
    }
}