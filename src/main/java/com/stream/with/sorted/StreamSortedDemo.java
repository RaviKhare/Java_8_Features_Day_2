/**
 * 
 */
package main.java.com.stream.with.sorted;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;

import main.java.com.model.ProductDetails;

/**
 * @author rk
 *
 */
public class StreamSortedDemo  {
 
	public static void main(String[] args) throws IOException {
	
	    System.out.println("\n 1-  Stream with map() , sorted  - ");	
	    Map<ProductDetails,Integer> productMap = ProductDetails.getProductDetailsMap(); 
	    
	    productMap.entrySet()
				.stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(ProductDetails::getProductPrice)));
				
		
	}

}
