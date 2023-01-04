package threadingfundamentals.excercise;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> System.out.println("I'm going for a walk"));

        Thread thread2 = new Thread(() -> System.out.println("I'm going to swim"));

        Thread thread3 = new Thread(() -> System.out.println("I'm going to lunch"));

        List<Runnable> runnableList = new ArrayList<>();

        runnableList.add(thread1);
        runnableList.add(thread2);
        runnableList.add(thread3);

        MultiExecutor multiExecutor = new MultiExecutor(runnableList);
        multiExecutor.executeAll();



    }



}
