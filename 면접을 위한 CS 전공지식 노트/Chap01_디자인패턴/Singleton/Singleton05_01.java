class Singleton05_01 {
    private static class singleInstanceholder {
        private static final Singleton05_01 INSTANCE = new Singleton05_01();

    }

    public static Singleton05_01 getInstance() {
        return singleInstanceholder.INSTANCE;
    }
}