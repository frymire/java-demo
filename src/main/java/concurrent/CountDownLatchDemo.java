package concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

  public static void main(String[] args) throws InterruptedException {

    CountDownLatch latch = new CountDownLatch(3);  // wait for 3 tasks

    // Start 3 worker threads
    for (int i = 0; i < 3; i++) {

      final int taskId = i;

      new Thread(() -> {
        try {
          System.out.println("Task " + taskId + " starting...");
          Thread.sleep(1000 * taskId); // simulate work
          System.out.println("  Task " + taskId + " completed!");
          latch.countDown(); // thread-safe way to signal completion
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }).start();

    }

    System.out.println("Waiting for all tasks to complete...");
    latch.await(); // block until all 3 tasks call countDown()
    System.out.println("All tasks completed!");
  }
}
