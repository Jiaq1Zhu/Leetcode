class SingletonEager {
    // eager load, not multi-thread safety problem
    // might cause resources waste.
    private SingletonEager() {
    }

    private final static SingletonEager instance = new SingletonEager();

    public static SingletonEager getInstance() {
        return instance;
    }
}
