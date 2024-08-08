/*
팩토리 패턴
상위 : 커피 공정
하위 : 라떼, 아메리카노, 우요
*/

// CoffeeType 열거형 정의
enum CoffeeType {
    LATTE,
    ESPRESSO
}

// 상위 : 추상 클래스 Coffee
abstract class Coffee {
    protected String name;

    public String getName() {
        return name;
    }
}

// 하위 : 구체적인 커피 클래스 Latte
class Latte extends Coffee {
    public Latte() {
        name = "Latte";
    }
}

// 하위 : 구체적인 커피 클래스 Espresso
class Espresso extends Coffee {
    public Espresso() {
        name = "Espresso";
    }
}

// CoffeeFactory 클래스
class CoffeeFactory {
    public static Coffee createCoffee(CoffeeType type) {
        switch (type) {
            case LATTE:
                return new Latte();
            case ESPRESSO:
                return new Espresso();
            default:
                throw new IllegalArgumentException("Invalid coffee type: " + type);
        }
    }
}

// Main 클래스
public class Main {
    public static void main(String[] args) {
        // CoffeeFactory를 사용하여 Latte 객체 생성
        Coffee coffee = CoffeeFactory.createCoffee(CoffeeType.LATTE);
        System.out.println(coffee.getName()); // 출력: Latte
    }
}
