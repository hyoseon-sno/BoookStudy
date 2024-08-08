// 패턴 적용 x

// GunType 열거형 정의
enum GunType {
    PISTOL,
    RIFLE,
    SHOTGUN
}

// Gun 추상 클래스 정의
abstract class Gun {
    protected String name;

    public String getName() {
        return name;
    }

    // 움직임
    public abstract void move();

    // 효과음
    public abstract void sound();

    // 쏘는 간격
    public abstract void fireInterval();
}

// Pistol 클래스 정의
class Pistol extends Gun {
    public Pistol() {
        name = "Pistol";
    }

    @Override
    public void move() {
        System.out.println("Pistol moves quickly");
    }

    @Override
    public void sound() {
        System.out.println("Pistol sound: Pew Pew");
    }

    @Override
    public void fireInterval() {
        System.out.println("Pistol fires every 0.5 seconds");
    }
}

// Rifle 클래스 정의
class Rifle extends Gun {
    public Rifle() {
        name = "Rifle";
    }

    @Override
    public void move() {
        System.out.println("Rifle moves steadily");
    }

    @Override
    public void sound() {
        System.out.println("Rifle sound: Bang Bang");
    }

    @Override
    public void fireInterval() {
        System.out.println("Rifle fires every 1 second");
    }
}

// Shotgun 클래스 정의
class Shotgun extends Gun {
    public Shotgun() {
        name = "Shotgun";
    }

    @Override
    public void move() {
        System.out.println("Shotgun moves slowly");
    }

    @Override
    public void sound() {
        System.out.println("Shotgun sound: Boom Boom");
    }

    @Override
    public void fireInterval() {
        System.out.println("Shotgun fires every 1.5 seconds");
    }
}

// Main 클래스
public class Main {
    public static void main(String[] args) {
        Gun pistol = new Pistol();
        pistol.move();
        pistol.sound();
        pistol.fireInterval();

        Gun rifle = new Rifle();
        rifle.move();
        rifle.sound();
        rifle.fireInterval();

        Gun shotgun = new Shotgun();
        shotgun.move();
        shotgun.sound();
        shotgun.fireInterval();
    }
}





// 전략 패턴 적용
//전략 인터페이스 정의
// 움직임 전략 인터페이스
interface MoveStrategy {
    void move();
}

// 효과음 전략 인터페이스
interface SoundStrategy {
    void sound();
}

// 쏘는 간격 전략 인터페이스
interface FireIntervalStrategy {
    void fireInterval();
}


//구체적인 전략 클래스 정의
// Pistol의 움직임 전략 클래스
class PistolMoveStrategy implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("Pistol moves quickly");
    }
}

// Rifle의 움직임 전략 클래스
class RifleMoveStrategy implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("Rifle moves steadily");
    }
}

// Shotgun의 움직임 전략 클래스
class ShotgunMoveStrategy implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("Shotgun moves slowly");
    }
}

// Pistol의 효과음 전략 클래스
class PistolSoundStrategy implements SoundStrategy {
    @Override
    public void sound() {
        System.out.println("Pistol sound: Pew Pew");
    }
}

// Rifle의 효과음 전략 클래스
class RifleSoundStrategy implements SoundStrategy {
    @Override
    public void sound() {
        System.out.println("Rifle sound: Bang Bang");
    }
}

// Shotgun의 효과음 전략 클래스
class ShotgunSoundStrategy implements SoundStrategy {
    @Override
    public void sound() {
        System.out.println("Shotgun sound: Boom Boom");
    }
}

// Pistol의 쏘는 간격 전략 클래스
class PistolFireIntervalStrategy implements FireIntervalStrategy {
    @Override
    public void fireInterval() {
        System.out.println("Pistol fires every 0.5 seconds");
    }
}

// Rifle의 쏘는 간격 전략 클래스
class RifleFireIntervalStrategy implements FireIntervalStrategy {
    @Override
    public void fireInterval() {
        System.out.println("Rifle fires every 1 second");
    }
}

// Shotgun의 쏘는 간격 전략 클래스
class ShotgunFireIntervalStrategy implements FireIntervalStrategy {
    @Override
    public void fireInterval() {
        System.out.println("Shotgun fires every 1.5 seconds");
    }
}


//Gun 클래스 정의
// Gun 클래스
class Gun {
    private String name;
    private MoveStrategy moveStrategy;
    private SoundStrategy soundStrategy;
    private FireIntervalStrategy fireIntervalStrategy;

    public Gun(String name, MoveStrategy moveStrategy, SoundStrategy soundStrategy, FireIntervalStrategy fireIntervalStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
        this.soundStrategy = soundStrategy;
        this.fireIntervalStrategy = fireIntervalStrategy;
    }

    public void performMove() {
        moveStrategy.move();
    }

    public void performSound() {
        soundStrategy.sound();
    }

    public void performFireInterval() {
        fireIntervalStrategy.fireInterval();
    }

    public String getName() {
        return name;
    }
}


//Main 클래스
public class Main {
    public static void main(String[] args) {
        Gun pistol = new Gun("Pistol", new PistolMoveStrategy(), new PistolSoundStrategy(), new PistolFireIntervalStrategy());
        pistol.performMove();
        pistol.performSound();
        pistol.performFireInterval();

        Gun rifle = new Gun("Rifle", new RifleMoveStrategy(), new RifleSoundStrategy(), new RifleFireIntervalStrategy());
        rifle.performMove();
        rifle.performSound();
        rifle.performFireInterval();

        Gun shotgun = new Gun("Shotgun", new ShotgunMoveStrategy(), new ShotgunSoundStrategy(), new ShotgunFireIntervalStrategy());
        shotgun.performMove();
        shotgun.performSound();
        shotgun.performFireInterval();
    }
}


