/**
 * 
 */
package main.java.com.model;

/**
 * @author rk
 *
 */


public class Task implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread Name-"+Thread.currentThread().getName());
	}
	
	
	
}
