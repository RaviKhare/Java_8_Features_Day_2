/**
 * 
 */
package main.java.com.threading.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import main.java.com.model.Task;

/**
 * @author rk
 *
 */
public class ThreadingExecutorService {

	public static void main(String[] args) {
	
	 ExecutorService service = Executors.newFixedThreadPool(10);
	  
	 for (int i=0; i< 10; i++){ 
		 service.execute(new Task()); 
	 }
		
	 int cpuCore = Runtime.getRuntime().availableProcessors();
	// fixThread pool
	 ExecutorService fixThreadServiceObj = Executors.newFixedThreadPool(cpuCore);
		  
	 for (int i=0; i< 10; i++){ 
		 fixThreadServiceObj.execute(new Task());
	 }
	 
	 // cachedThread pool 
	 ExecutorService cacheServiceObj = Executors.newCachedThreadPool();
	  
	 for (int i=0; i< 10; i++){ 
		 cacheServiceObj.execute(new Task());
	 }
	 
	// scheduledThread pool 
	 ScheduledExecutorService scheduleServiceObj = Executors.newScheduledThreadPool(10);
	
	 	// task to run after 10 seconds delay  
	 scheduleServiceObj.schedule(new Task(), 10, TimeUnit.SECONDS);
	  
		// task to run repeatedly every 15 seconds   
	 scheduleServiceObj.scheduleAtFixedRate(new Task(), 30, 15, TimeUnit.SECONDS);
	
	 // task to run repeatedly every 15 seconds after previous task complete
	 scheduleServiceObj.scheduleWithFixedDelay(new Task(), 30, 15, TimeUnit.SECONDS);
	 
	// singleThread pool 
	 ExecutorService singleThreadServieObj = Executors.newSingleThreadExecutor();
		
	 for (int i=0; i< 10; i++){ 
		 singleThreadServieObj.execute(new Task());
	 }
	 
	}
}	
