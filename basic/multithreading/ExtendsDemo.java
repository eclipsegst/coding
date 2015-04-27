/**
 * Author: Zhaolong Zhong
 * Date  : 2015 5:03:23 PM
 * Review: Create a thread by extending Thread class
 * Step 1: Override run() method available in Thread class.
 *         Put complete business logic inside this methods.
 * Step 2: Call start() method, which execute a call to run() method.
 */
package multithreading;

import java.util.Random;

class ExtendsThread extends Thread {
  private Thread t;
  private String threadName;
  
  ExtendsThread( String name) {
    threadName = name;
    System.out.println("Creating " + threadName);
  }
  public void run() {
    System.out.println("Running " + threadName);
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
  
  public void start() {
    System.out.println("Starting " + threadName);
    if (t == null) {
      t = new Thread(this, threadName);
      t.start();
    }
  }
}

public class ExtendsDemo {
  public static void main(String args[]) {
    System.out.println("Testing ExtendsDemo...");
    ExtendsThread T1 = new ExtendsThread("Thread-1");
    T1.start();
    ExtendsThread T2 = new ExtendsThread("Thread-2");
    T2.start();
  }
}
