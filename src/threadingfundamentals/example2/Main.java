package threadingfundamentals.example2;

public class Main {
    public static void main(String[] args) {
        //Se crea un hilo y recibe una clase que hereda la clase Thread, Thread por su parte implementa la interfaz Runneable
        Thread thread = new NewThread();
        Thread thread1 = new Thread(new NewThread());
        thread.start();
        thread1.start();
    }

    private static class NewThread extends Thread{
        @Override
        public void run(){
            System.out.println("Hello from " + this.getName());
        }

    }

}
