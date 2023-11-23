public class CounterThread extends Thread{

    private final String name;
    private final Counter c;


    CounterThread(String name, Counter c){
        this.name = name;
        this.c = c;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5 ; i++){
            System.out.println(name + ": " + i + " - " + c.increment());

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
