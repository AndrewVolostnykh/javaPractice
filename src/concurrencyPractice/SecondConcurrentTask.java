package concurrencyPractice;

import java.util.LinkedList;
import java.util.Queue;

// This class created to write all most popular instruments to work with multithreading
public class SecondConcurrentTask {

    public static void main(String[] args) {
        Customer customer = new Customer();
        Producer producer = new Producer();
        customer.start();
        producer.start();


        showQueue();
    }
    static void showQueue()
    {
        Store.q.forEach(i -> System.out.print(i + " "));
    }
}


class Store{
    static final int MAX_SIZE = 50;
    volatile static Queue<Integer> q = new LinkedList<>();


    static void putInArray(int a)
    {
        q.add(a);
    }

    static int takeAll()
    {
        return q.poll();
    }

    synchronized static int currentSize()
    {
        return q.size();
    }
}

class Customer extends Thread
{

    @Override
    public void run()
    {
        int counter = 0;
        while(counter < 500)
        {
            counter++;
            try{
                 synchronized (Store.q)
                 {
                     if(Store.currentSize() == 0)
                     {
                         Store.q.wait();
                         System.out.println("Customer have slept!");
                     } else {
                         System.out.println("Customer have taken: " + Store.takeAll());
                         Store.q.notifyAll();
                     }
                 }
            } catch(Exception e)
            {
                System.out.println("Exception in Customer: " + e);
            }
        }
    }
}

class Producer extends Thread
{

    @Override
    public void run()
    {
        int counter = 0;
        while(counter < 500)
        {
            counter++;
            try {
                synchronized (Store.q) {
                    if (Store.currentSize() >= Store.MAX_SIZE) {
                        Store.q.wait();
                        System.out.println("Producer have slept!");
                    }
                    else
                    {
                        System.out.println("Producer put: " + counter);
                        Store.putInArray(counter);
                        Store.q.notifyAll();
                    }
                }
            } catch (Exception e)
            {
                System.out.println("Exception in producer: " + e);
            }
        }
    }
}