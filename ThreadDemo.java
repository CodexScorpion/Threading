/*
Name: Joshua Lobo
PRN: 21070126127
Batch: AIML B3

OS: Mac OS 12.2.1 Monterey
java Version: 19.0.1 2022-10-18
Java(TM) SE Runtime Environment (build 19.0.1+10-21)
Java HotSpot(TM) 64-Bit Server VM (build 19.0.1+10-21, mixed mode, sharing)
*/


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Import required packages
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Define a class that implements the Runnable interface
class MyRunnable implements Runnable {
    // Define a method that will be executed when the thread starts
    public void run() {
        // Print a message indicating that the thread has started
        System.out.println("Thread started: " + Thread.currentThread().getName());

        // Sleep for a random amount of time (up to 5 seconds) to simulate some work being done
        try {
            Thread.sleep((long) (Math.random() * 5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print a message indicating that the thread has finished
        System.out.println("Thread finished: " + Thread.currentThread().getName());
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        // Create a new instance of MyRunnable
        MyRunnable myRunnable = new MyRunnable();

        // Method 1: Create and start a thread directly
        Thread thread1 = new Thread(myRunnable);
        thread1.start();

        // Method 2: Create a thread using a ThreadFactory and start it
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(myRunnable);

        // Method 3: Create a thread using a ThreadPoolExecutor and start it
        ExecutorService executorService2 = Executors.newFixedThreadPool(2);
        executorService2.submit(myRunnable);
        executorService2.submit(myRunnable);

        // Method 4: Use a lambda expression to create and start a thread
        new Thread(() -> {
            // Print a message indicating that the thread has started
            System.out.println("Thread started: " + Thread.currentThread().getName());

            // Sleep for a random amount of time (up to 5 seconds) to simulate some work being done
            try {
                Thread.sleep((long) (Math.random() * 5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Print a message indicating that the thread has finished
            System.out.println("Thread finished: " + Thread.currentThread().getName());
        }).start();
    }
}

