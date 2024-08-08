class Singleton04_01 {
    private static class singleInstanceholder {
        private static final Singleton04_01 INSTANCE = new Singleton04_01();

    }

    public static Singleton04_01 getInstance() {
        return singleInstanceholder.INSTANCE;
    }
}