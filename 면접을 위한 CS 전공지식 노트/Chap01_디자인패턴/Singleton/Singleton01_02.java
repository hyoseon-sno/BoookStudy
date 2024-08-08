/*
멀티 스레드 만족x 예제
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

    public void say(String song){
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