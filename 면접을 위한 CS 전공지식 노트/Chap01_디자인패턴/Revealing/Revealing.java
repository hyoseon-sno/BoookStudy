class Module {
    // private 변수와 메서드
    private int privateVariable = 1;
    private int privateMethod() {
        return 2;
    }

    // public 변수와 메서드
    public int publicVariable = 3;
    public int publicMethod() {
        return 4;
    }

    // 접근 제어자에 따른 메서드 노출
    public int getPrivateVariable() {
        return privateVariable;
    }

    public int callPrivateMethod() {
        return privateMethod();
    }
}

public class Main {
    public static void main(String[] args) {
        Module module = new Module();

        // public 변수와 메서드 접근
        System.out.println("Public Variable: " + module.publicVariable); // 3
        System.out.println("Public Method: " + module.publicMethod()); // 4

        // private 변수와 메서드 접근 (공개된 메서드를 통해)
        System.out.println("Private Variable: " + module.getPrivateVariable()); // 1
        System.out.println("Private Method: " + module.callPrivateMethod()); // 2

        // 직접 접근 불가
        // System.out.println(module.privateVariable); // 컴파일 오류
        // System.out.println(module.privateMethod()); // 컴파일 오류
    }
}

