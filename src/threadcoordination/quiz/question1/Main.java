package threadcoordination.quiz.question1;

import java.io.IOException;

public class Main {
    public static void main(String [] args) {
        Thread thread = new Thread(new WaitingForUserInput());
        thread.setName("InputWaitingThread");
        thread.setDaemon(true);
        thread.start();
        thread.interrupt();
    }

    private static class WaitingForUserInput implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    char input = (char) System.in.read();
                    if(input == 'q') {
                        return;
                    }
                }
            } catch (IOException e) {
                System.out.println("An exception was caught " + e);
            };
        }
    }
}


//ANSWER: success alert
//Please choose the correct statement
// The only way to programmatically stop the application is to make the thread a daemon.
// Unfortunately System.in.read() does not respond to Thread.interrupt();