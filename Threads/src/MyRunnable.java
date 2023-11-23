public class MyRunnable implements Runnable{

    private final String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Hello from " + name + " runnable.");
    }
}
