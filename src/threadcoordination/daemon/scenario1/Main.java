package threadcoordination.daemon.scenario1;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread =
                new Thread(new LongComputationTask2(new BigInteger("200000"), new BigInteger("10000000000")));

        thread.setDaemon(true);
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
    }
    private static class LongComputationTask2 implements Runnable{
        private final BigInteger base;
        private final BigInteger power;

        public LongComputationTask2(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base+"^"+power+ " = "+ pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power){

            BigInteger result = BigInteger.ONE;

            for(BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0 ; i = i.add(BigInteger.ONE)){
                result = result.multiply(base);
            }
            return result;
        }
    }
}