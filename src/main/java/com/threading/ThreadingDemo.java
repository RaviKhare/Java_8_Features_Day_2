/**
 * 
 */
package main.java.com.threading;

import main.java.com.model.Task;

/**
 * @author rk
 *
 */
public class ThreadingDemo {

	public static void main(String[] args) {
	
		 Thread thread = new Thread(new Task());
		 thread.start();	
	}
	
	
}
