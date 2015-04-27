/**
 * Author: Zhaolong Zhong
 * Date  : 2015 3:17:50 PM
 * Review: Create a thread by Implementing Runnable Interface
 * Step 1: Implement a run() method provided by Runnable interface
 *         All the business logic will be included here.
 * Step 2: Instantiate a Thread object
 * Step 3: Call start() method after thread object is created, 
 *         which executes a call to run() method.
 */
package multithreading;

import java.util.Random;

class RunnableThread implements Runnable{
  private Thread t;
  private String threadName;
  
  RunnableThread (String name) {
    threadName = name;
    System.out.println("Creating " + threadName );
  }
  
  public void run() {
    System.out.println("Running " + threadName );
    try {
      for (int i = 3; i > 0; i--) {
        
        // Generate random number
        Random rand = new Random();
        int min = 1;
        int max = 5; 
        int n = rand.nextInt((max - min) + 1) + min;
        
        System.out.println("Thread: " + threadName + ", " + (3 - i + 1) + " times sleep: " + n + "seconds.");
        // Thread sleep
        Thread.sleep(1000 * n);
      }
    } catch (InterruptedException e) {
      System.out.println("Thread " + threadName + " interrupted.");
    }
    System.out.println("Thread " + threadName + " exiting.");
  }
  
  public void start () {
    System.out.println("Starting " + threadName );
    if (t == null) {
      t = new Thread(this, threadName);
      t.start();  // Will call run().
    }
  }
}

public class RunnableDemo {
  public static void main(String args[]) {
    System.out.println("Testing RunnableDemo...");
    RunnableThread R1 = new RunnableThread("Thread-1");
    R1.start();
    RunnableThread R2 = new RunnableThread("Thread-2");
    R2.start();
  }
}
