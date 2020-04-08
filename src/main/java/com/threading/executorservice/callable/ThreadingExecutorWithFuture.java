/**
 * 
 */
package main.java.com.threading.executorservice.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import main.java.com.model.TaskWithCallable;

/**
 * @author rk
 *
 */
public class ThreadingExecutorWithFuture {

	public static void main(String[] args)  {
		
		 List<Future> allFuture = new ArrayList<>();
	 	 // create the pool
		 ExecutorService service = Executors.newFixedThreadPool(10);
		 
		 // submit the task or execution 
		 Future<Integer> future  = service.submit(new TaskWithCallable());
			 try {
					Integer result = future.get();
				} catch (InterruptedException | ExecutionException e1) {
					e1.printStackTrace();
				}
			 
		 
		 
		 for (int i=0; i< 100; i++){ 
			 Future<Integer> futureVal  = service.submit(new TaskWithCallable());
			 allFuture.add(futureVal);
		 }
		 
		 for (int i=0; i< 100; i++){ 
			 Future<Integer> futureObject = allFuture.get(i);
				 try {
					Integer resultVal = future.get();
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
		 	}
		 
		 for (int i=0; i< 100; i++){ 
			 Future<Integer> futureObject = allFuture.get(i);
				 try {
					Integer resultVal = future.get(1, TimeUnit.SECONDS);
				} catch (InterruptedException | ExecutionException | TimeoutException e) {
					e.printStackTrace();
				}
		 	}
		 
		 // submit the task or execution 
		 Future<Integer> futureObject  = service.submit(new TaskWithCallable());
		 futureObject.cancel(false);
		 if (futureObject.isCancelled()){
			 // operation 
		 }
		 
		 if (futureObject.isDone()){
			 // operation 
		 }
		 
		}
}	
