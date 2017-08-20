/**
 * 
 */
package car_miles;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Craig Ballingall
 *
 */


import java.time.temporal.ChronoUnit;


public class Main {

	
	/**
	 * @param args
	 */

	public static void main(String[] args) {
	
		
LocalDate nowDate = LocalDate.now();
		
		LocalDate ld = LocalDate.of(2017, 1, 13);
		
		long days = ChronoUnit.DAYS.between(ld, nowDate);
		String daysSincePurchage = Long.toString(days); 
		
		System.out.println("You have owed the car for " + daysSincePurchage + " Days");	
		
		int milesAtPurchase = 15550;
		int targetMiles = 0;
		
		if (days * 19 < Integer.MAX_VALUE) {
			targetMiles = (int)days * 19;
		} else {
			System.out.println("You have had the car too long, no body cares any more");
		}
	
		targetMiles = targetMiles + milesAtPurchase; 
		
		System.out.println("Mileage on the car today should be less than " + targetMiles );
		System.out.print("Please enter the current mileage for the car: ");
		
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		
		Locale loc = new Locale("en", "GB");
		
		System.out.println("You have driven : " + i + " Miles");
		int remainMiles = targetMiles - i;
		
		if (remainMiles > 0) {
			System.out.println("You are " + remainMiles + " in credit");
		} else {
			double chargeMiles = (targetMiles - remainMiles) * 0.06;
			NumberFormat nf = NumberFormat.getCurrencyInstance(loc);
			System.out.println(" You have a bill comming for " + nf.format(chargeMiles));
		}
		
		

	}

}
