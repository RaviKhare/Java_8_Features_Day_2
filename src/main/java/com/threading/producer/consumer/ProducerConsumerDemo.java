/**
 * 
 */
package main.java.com.threading.producer.consumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author rk
 *
 */
public class ProducerConsumerDemo {

	public static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
			
	public static void main(String[] args)  {
		
		Thread producedThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
			}
			
		});
		
		Thread consumerThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
				try {
					consumer();
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
			}
			
		});
		
		producedThread.start();
		consumerThread.start();
	}
	
	
	public static void producer() throws InterruptedException {
		Random random = new Random();
		while(true){
				Thread.sleep(2000);
				int produced = random.nextInt(100);
				queue.put(produced);
				System.out.println("Produced --"+produced);
		}
	}
	
	
	public static void consumer() throws InterruptedException {
			while(true) {
				Thread.sleep(2000);
				Integer consume = queue.take();
				System.out.println("Consumed --"+consume);
			}
		}
	
	
}	
