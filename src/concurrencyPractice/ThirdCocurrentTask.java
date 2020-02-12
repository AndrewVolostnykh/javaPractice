package concurrencyPractice;

import java.util.concurrent.locks.ReentrantLock;

//incorrect realisation, read about Callable, Future and Executor

public class ThirdCocurrentTask{

    public static void execute()
    {
        ReentrantLock reentrantLock_first = new ReentrantLock();
        ReentrantLock reentrantLock_second = new ReentrantLock();
        Operator first_operator = new Operator();
        Operator second_operator = new Operator();

        int firstOperatorQueue = 0;
        int secondOperatorQueue = 0;

        for(int i = 0; i < 50; i++)
        {
            if(firstOperatorQueue < secondOperatorQueue)
            {
                new Buyer(first_operator, reentrantLock_first).start();
                firstOperatorQueue++;
            } else {
                new Buyer(second_operator, reentrantLock_second).start();
                secondOperatorQueue++;
            }
        }


    }

}

class Operator
{
    double cash = 0;
//    private static int turn = 0;
    double billPayer(double bill)
    {
        try {
            cash += bill;
            int sleep = (int)(Math.random()*100);
            Thread.sleep(sleep);
            System.out.println("LOG: Buyer slept " + sleep);
            System.out.println("Cash result: " + cash);
            return 0;
        } catch (Exception e)
        {
            System.err.println("LOG(Operator): " + e);
        }
        return bill;
    }

}

class Buyer extends Thread{
    private double bill = (Math.random()*1000)/3;
    private Operator operator;
    private ReentrantLock lock;

    Buyer(Operator operator, ReentrantLock lock)
    {
        this.operator = operator;
        this.lock = lock;
    }

    @Override
    public void run() {
        System.err.println(this.getName() + " waiting");
        lock.lock();
        System.out.println(this.getName() + " have get control");
        try{
            if(operator.billPayer(bill) != 0)
            {
                this.interrupt();
            }
            System.out.println("LOG(Buyer): " + this.getName() + " Successfully payed  ");
        } catch (Exception e)
        {
            System.err.println("LOG(Buyer): " + e);
        } finally {
            lock.unlock();
        }
    }
}