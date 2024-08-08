/*
기본 싱글톤 예제 코드
인스턴스 없을 경우 만들고 있으면 존재하는 인스턴스 반환
synchronized 키워드 추가
getInstance 호출할때마다 멀티스레드에서 사용 가능

*/

public class Hyo{
    private static String hyo="효선";

    public static void main(String[] args){
        Hyo a = new Hyo();

        //스레드 01
        new Thread(() -> {
            for (int i=0; i<10; i++){
                a.say("자바자바");
            }
        }).start();

        //스레드 02
        new Thread(() -> {
            for (int i=0; i<10; i++){
                a.say("파이썬파이썬");
            }
        }).start();
    }

    public synchronized void say(String song){
        hyo=song;
        try{
            long sleep=(long) (Math.random()*100);
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!hyo.equals(song)) {
            System.out.println(song+"|"+hyo);
        }
    }
}