package threadingfundamentals.example1;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            //Code that will wun in a new thread
            System.out.println("We are now in thread "+ Thread.currentThread().getName());
            System.out.println("Current Thread Priority is: "+ Thread.currentThread().getPriority());

        });
        thread.setName("New Worker Thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread");
        thread.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread");
        //Thread.sleep(10000);

        System.out.println("Final");

    }
}