package Concurrency.example;

public class Main {
    public static void main(String[] args) {
      TaskExample taskExample1 = new TaskExample();
      TaskExample taskExample2 = new TaskExample();

      taskExample1.start();
      taskExample2.start();

    }
}
