package concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

  record Task(int id) {
    public void execute() throws InterruptedException {
      System.out.println("Task " + id + " starting...");
      Thread.sleep(1000L * id); // simulate work
      System.out.println("  Task " + id + " complete.");
    }
  }

  record TaskRunner(Task task, CountDownLatch latch) implements Runnable {
    @Override
    public void run() {
      try {
        task.execute();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      } finally {
        latch.countDown();
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    final int numTasks = 3;
    CountDownLatch latch = new CountDownLatch(numTasks); // wait for 3 tasks
    for (int id = 0; id < numTasks; id++) { new Thread(new TaskRunner(new Task(id), latch)).start(); }
    latch.await();  // block until all 3 task runners call countDown()
    System.out.println("All tasks complete.");
  }
}
