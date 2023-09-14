public class SingletonLazySafe1 {
    private static SingletonLazySafe1 instance;

    private SingletonLazySafe1() {
    }

    public static synchronized SingletonLazySafe1 getInstance() {
        if (instance == null)
            instance = new SingletonLazySafe1();
        return instance;
    }

}
