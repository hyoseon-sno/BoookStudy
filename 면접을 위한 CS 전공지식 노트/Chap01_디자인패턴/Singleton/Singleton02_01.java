/*
기본 싱글톤 예제 코드
인스턴스 없을 경우 만들고 있으면 존재하는 인스턴스 반환
synchronized 키워드 추가
getInstance 호출할때마다 멀티스레드에서 사용 가능

*/

public class Singleton02_01{
    private static Singleton02_01 instance;

    private Singleton(){

    }

    public static synchronized Singleton02_01 getInstance(){
        if (instance == null){
            instance=new Singleton02_01();
        }
        return instance;
    }
}