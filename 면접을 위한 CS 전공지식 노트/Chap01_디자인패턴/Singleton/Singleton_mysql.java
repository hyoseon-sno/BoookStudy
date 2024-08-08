/*
방법5 사용
mysql 연결 코드
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    // 내부 클래스 (Lazy Holder)를 사용하여 싱글톤 인스턴스를 지연 초기화합니다.
    private static class ConnectionHolder {
        private static final MySQLConnection INSTANCE = new MySQLConnection();
    }

    private Connection connection;

    // private 생성자: 외부에서 인스턴스화 할 수 없습니다.
    private MySQLConnection() {
        // MySQL 연결 설정
        connect();
    }

    // getInstance() 메서드를 통해 싱글톤 인스턴스를 반환합니다.
    public static MySQLConnection getInstance() {
        return ConnectionHolder.INSTANCE;
    }

    // MySQL에 연결하는 메서드
    private void connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/mydatabase"; // MySQL URL
            String user = "username"; // MySQL 사용자 이름
            String password = "password"; // MySQL 비밀번호
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("MySQL connected");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to MySQL", e);
        }
    }

    // 데이터베이스 연결 객체를 반환하는 메서드
    public Connection getConnection() {
        return connection;
    }

    // 연결을 종료하는 메서드
    public void close() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("MySQL connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 예제 사용법
        MySQLConnection mySQLConnection = MySQLConnection.getInstance();
        Connection connection = mySQLConnection.getConnection();

        // 여기에서 데이터베이스 작업 수행

        // 작업이 끝나면 연결을 종료합니다.
        mySQLConnection.close();
    }
}
