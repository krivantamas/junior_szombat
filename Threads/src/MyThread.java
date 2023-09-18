public class MyThread extends Thread {

    private final String name;
    private int value;

    private int results = 0;

    public MyThread(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public int getResults() {
        return results;
    }

    @Override
    public void run() {
        System.out.println("Hello from " + name + " thread.");
        results = (int) Math.pow(value,2);
    }
}
