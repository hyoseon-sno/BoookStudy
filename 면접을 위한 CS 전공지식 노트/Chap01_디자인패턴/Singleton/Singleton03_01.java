/*
정적 멤버 기본 예제
*/

//정적 멤버
public class Singleton03_01 {
    private final static Singleton03_01 instance = new Singleton03_01();

    private Singleton03_01() {

    }

    public static Singleton03_01 getInstance() {
        return instance;
    }
}

//정적 블록
public class Singleton03_01 {
    private final Singleton03_01 instance=null;

    static{
        instance=new Singleton03_01();
    }

    private Singleton03_01() {

    }

    public static Singleton03_01 getInstance() {
        return instance();
    }
}