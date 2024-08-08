/*
이중 확인
인스턴스가 null일 경우 synchronized로 인스턴스 없을 경우 할당
인스턴스 없는 지 확인 2번
*/


public class Singleton06_01 {

    private volatile Singleton06_01 instance;

    private Singleton06_01() {

    }

    public Singleton06_01 getInstance() {
        if (instance == null) {
            synchronized (Singleton06_01.class) {
                if (instance == null) {
                    instance = new Singleton06_01();
                }
            }
        }
        return instance;
    }
}