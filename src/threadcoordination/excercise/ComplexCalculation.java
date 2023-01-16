package threadcoordination.excercise;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ComplexCalculation {

    public static void main(String[] args) throws InterruptedException {
        BigInteger two = BigInteger.TWO;
        BigInteger one = BigInteger.valueOf(4L);

        ComplexCalculation complexCalculation = new ComplexCalculation();
        System.out.println(complexCalculation.calculateResult(two, one, one ,two));
    }

    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws InterruptedException {

           /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */

        BigInteger result = BigInteger.valueOf(0L);

        List<PowerCalculatingThread> powerCalculatingThreads = new ArrayList<>();
        powerCalculatingThreads.add(new PowerCalculatingThread(base1, power1));
        powerCalculatingThreads.add(new PowerCalculatingThread(base2, power2));

        powerCalculatingThreads.forEach(powerCalculatingThread -> {
            powerCalculatingThread.setDaemon(true);
            powerCalculatingThread.start();
        });

        for (Thread thread : powerCalculatingThreads){
            thread.join(2000);
        }

        for (PowerCalculatingThread powerCalculatingThread : powerCalculatingThreads) {

            result = result.add(powerCalculatingThread.getResult());

        }

        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private final BigInteger base;
        private final BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
           /*
           Implement the calculation of result = base ^ power
           */
            this.result = pow(base, power);
           // this.is = true;
        }

        private BigInteger pow(BigInteger base, BigInteger power){

            BigInteger result = BigInteger.ONE;

            for(BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0 ; i = i.add(BigInteger.ONE)){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("Prematurely interrupted computation");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }
            return result;
        }
        public BigInteger getResult() { return result; }
    }
}