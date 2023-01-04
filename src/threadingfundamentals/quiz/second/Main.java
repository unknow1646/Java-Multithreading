package threadingfundamentals.quiz.second;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> System.out.println("I'm going for a walk"));

        Thread thread2 = new Thread(() -> System.out.println("I'm going to swim"));

        thread1.start();
        thread2.start();
        System.out.println("I'm going home");
    }
}