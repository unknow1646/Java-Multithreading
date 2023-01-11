package threadingfundamentals.example1;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        //Creacion de un Thread (FORMA 1) recibe una interfaz runnable y se sobre escribe el metodo run
        Thread thread = new Thread(() -> {
            //Code that will wun in a new thread
            System.out.println("We are now in thread "+ Thread.currentThread().getName());
            System.out.println("Current Thread Priority is: "+ Thread.currentThread().getPriority());

        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
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