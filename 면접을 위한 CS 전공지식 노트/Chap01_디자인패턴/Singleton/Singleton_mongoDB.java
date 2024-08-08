/*
방법5 사용
mongoDB 연결 코드
*/


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    // 내부 클래스(singleInstanceHolder)로 싱글톤 인스턴스 지연 초기화
    private static class singleInstanceHolder {
        private static final MongoDBConnection INSTANCE = new MongoDBConnection();
    }

    private MongoClient mongoClient;
    private MongoDatabase database;

    // private 생성자: 외부에서 인스턴스화 할 수 없음
    private MongoDBConnection() {
        // MongoDB 연결 설정
        connect();
    }

    // getInstance() 메서드를 통해 싱글톤 인스턴스 반환
    public static MongoDBConnection getInstance() {
        return singleInstanceHolder.INSTANCE;
    }

    // MongoDB에 연결하는 메서드
    private void connect() {
        String connectionString = "mongodb://localhost:27017";
        mongoClient = MongoClients.create(connectionString);
        database = mongoClient.getDatabase("mydatabase");
        System.out.println("MongoDB connected");
    }

    // 데이터베이스 객체 반환 메서드
    public MongoDatabase getDatabase() {
        return database;
    }

    // 연결을 종료 메서드
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    public static void main(String[] args) {
        // 예제 사용법
        MongoDBConnection connection = MongoDBConnection.getInstance();
        MongoDatabase db = connection.getDatabase();

        // 여기에서 데이터베이스 작업 수행

        // 작업이 끝나면 연결 종료
        connection.close();
    }
}
