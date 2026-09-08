package asdf;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class FactorialService implements Callable<Long> {
    int number;

     FactorialService(int number) {
        this.number = number;
    }

    @Override
	public Long call() throws Exception {
        long result = 1;
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        // Simulate a long computation
        for (int i = 1; i <= number; i++) {
            result *= i;
            Thread.sleep(100); 
        }
        return result;
    }
}
public class Demo {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit the tasks and obtain Future objects
        Future<Long> future5 = executor.submit(new FactorialService(5));
        Future<Long> future10 = executor.submit(new FactorialService(10));

        // Do other things while the tasks are running...
        System.out.println("Main thread... doing other task");

        try {
            // Retrieve the results. 
            Long factorial5 = future5.get();
            System.out.println("5! = " + factorial5);

            Long factorial10 = future10.get();
            System.out.println("10! = " + factorial10);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            //Call the shutdown to terminate the threads
            executor.shutdown();
        }
	}

}
