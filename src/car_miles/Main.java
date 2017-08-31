/**
 * 
 */
package car_miles;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * @author Craig Ballingall
 *
 */

public class Main {

	
	/**
	 * @param args
	 */

	public static void main(String[] args) {
	
		



// Setup the state of the car at purchase, purchase date was Jan 13, 2017 and the mileage on the contract was 15500
		
		
		int currentMileage = 0;
		int milesLeft = 0;
		
		int daysSincePurchase = getDaysSincePurcase();
		
		try {
		currentMileage = Integer.parseInt(getInput("Please enter the current mileage: "));
		} catch (NumberFormatException e ){
			System.err.println("An invalid mileage was entered - please use whole numbers only");
			System.exit(1);
		}
		
		
		milesLeft = milesRemain(currentMileage, daysSincePurchase);
		
		if (milesLeft >=0 ) {
			System.out.println("You have " + milesLeft + " Spare Miles");
		} else {
			NumberFormat nf = NumberFormat.getCurrencyInstance();
			System.err.println("!!You have exceeded milesage!!");
			System.out.println("Expect a charge of " + nf.format(forecastCharge(milesLeft, daysSincePurchase)));
		}
	}
	
	private static double forecastCharge(int overRun, int daysOwned) {
		int absOverRun = Math.abs(overRun);
		int costPerMile = 6;
		// calculate the average over use
		double overUse = absOverRun / (double)daysOwned;
		return (overUse * daysLeft()) * ((double)costPerMile / 100); 
		
		
	}
	private static int daysLeft() {
		LocalDate rd = LocalDate.of(2020, 01, 13);
		LocalDate nowDate = LocalDate.now();
		return  (int)ChronoUnit.DAYS.between(nowDate, rd);
		
	}
	
	private static int milesRemain(int currMiles, int daysSincePurchase) {
		int targetMiles = (19 * daysSincePurchase) + 15500;
		return targetMiles - currMiles;
		
	}
	
	
	private static int getDaysSincePurcase() {
		
		LocalDate ld = LocalDate.of(2017, 1, 13);
		LocalDate nowDate = LocalDate.now();
		
		return (int)ChronoUnit.DAYS.between(ld, nowDate); // Yes, this would fail if you've had the car for more than 2.7 Million years
		
		
		}
	
	private static String getInput(String label) {
		System.out.print(label);
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	

}
