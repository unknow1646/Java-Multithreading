package threadcoordination.quiz.question2;

public class Main {
    public static void main(String [] args) {
        Thread thread = new Thread(new SleepingThread());
        thread.start();
        thread.interrupt();
    }

    private static class SleepingThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    System.out.println("Exiting blocking thread ...");
                }
            }
        }
    }
}


//Please choose the correct statement
// As a rule of thumb, never leave a catch block empty,
// and use the InterruptedException catch block to gracefully stop the current thread
// (by adding some print or cleaning code before returning from the run method)
