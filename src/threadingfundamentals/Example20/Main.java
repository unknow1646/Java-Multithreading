package threadingfundamentals.Example20;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static final int MAX_PASSWORD = 9999;
    public static void main(String[] args) {
        Random random = new Random();
        Vault vault = new Vault(random.nextInt(MAX_PASSWORD));
        List<Thread> threads = new ArrayList<>();
        threads.add(new AsecendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new PoliceThread());

        threads.forEach(Thread::start);

    }

    private static class Vault{
        private final int password;

        public Vault(int password) {
            this.password = password;
        }

        public boolean isCorrectPassword(int passwordGuess){
            try {
                Thread.sleep(5);

            }catch (InterruptedException ignored){

            }

            return this.password == passwordGuess;
        }
    }

    private static class HackerThread extends Thread{
        protected Vault vault;

        public HackerThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(MAX_PRIORITY);
        }

        @Override
        public void start(){
            System.out.println("Starting thread " + this.getName());
            super.start();
        }
    }

    private static class AsecendingHackerThread extends HackerThread {

        public AsecendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            //i = passwordGuess
            for (int i = 0; i < MAX_PASSWORD; i++) {
                if (vault.isCorrectPassword(i)) {
                    System.out.println(this.getName() + " guessed the password " + i);
                    System.exit(0);
                }
            }
        }
    }

    private static class DescendingHackerThread extends HackerThread {

            public DescendingHackerThread(Vault vault) {
                super(vault);
            }

            @Override
            public void run() {
                //i = passwordGuess
                for (int i = MAX_PASSWORD; i >= 0 ; i--) {
                    if (vault.isCorrectPassword(i)) {
                        System.out.println(this.getName() + " guessed the password " + i);
                        System.exit(0);
                    }
                }
            }
    }

    private static class PoliceThread extends Thread {
        @Override
        public void run(){
            for(int j = 10;  j>0 ; j--){
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException ignored){}
                System.out.println(j);
            }
            System.out.println("Hacker fuck off");
            System.exit(0);
        }
    }

}
