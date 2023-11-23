public class Counter {

    int count;

    public Counter() {
        count = 0;
    }

    public synchronized int increment() {
        count = count + 1;
        return count;
    }

}
