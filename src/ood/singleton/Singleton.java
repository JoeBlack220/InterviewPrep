package ood.singleton;
// work only after java 1.5
public class Singleton {
    // static makes sure that there is only one object for the whole class
    // volatile is for visibility, when a shared variable is marked as volatile, it guarantees that
    // the modified value will be read into memory instantly, when other threads want to read it,
    // they will read from the memory for the newest value;
    private volatile static Singleton instance;
    private static Object lock;
    // since it's singleton, the constructor can't be accessed by other class
    private Singleton() {

    }

    // get method
    // synchronized is for the threads safe
    // synchronize will make operations sequential
    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (lock) {
                if(instance == null) instance = new Singleton();  // lazy instantiation
            }
        }
        return instance;
    }
}

// thread safe
// work regardless of jdk version
class InitializationOnDemandSingleton {
    // a static class is called automatically to initialize the class before the first instance is created or any static
    // members are referenced, A static constructor will run before an instance constructor
    private static class Holder {
        private static final InitializationOnDemandSingleton instance =
                new InitializationOnDemandSingleton();
    }

    private InitializationOnDemandSingleton(){}
    public static InitializationOnDemandSingleton getInstance() {
        return Holder.instance;
    }
}