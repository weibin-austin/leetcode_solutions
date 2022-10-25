package DesignPattern;

public class Singleton {
    // Lazy loading, double-checking, synchronized

    private static volatile Singleton instance = null;

    private Singleton(){}

    private static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
