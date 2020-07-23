class test {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        s.test();
    }
}

class Singleton {
    private static Singleton singleton = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null)
                    singleton = new Singleton();
            }
        }
        return singleton;
    }

    public void test() {
        System.out.println("test");
    }

}