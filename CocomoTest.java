import java.util.Scanner;
import org.nyanshak.cocomo.*;

public class CocomoTest {
	
	public static void main(String[] args){

		CocomoCalculator cocomoCalculator = new CocomoCalculator();
		boolean again = true;
		int choice = 1;
		Scanner reader = new Scanner(System.in);

		while (again) {

			System.out.println("Menu\n\t1) Current status\n\t2) Set KDSI\n\t3) Set cost per person hour" + 
								"\n\t4) Change other attributes\n\t5) Exit");
			System.out.print("Enter your choice (1, 2, 3, 4, 5): ");
			choice = reader.nextInt();

			if (choice == 1) {					// print current status
				cocomoCalculator.printStatus();
			} else if (choice == 2) {			// change KDSI
				System.out.print("Enter new KDSI: ");
				double k = reader.nextDouble();
				if (k <= 0){
					System.out.println("KDSI must be greater than 0.");
				} else {
					cocomoCalculator.setKDSI(k);
				}
			} else if (choice == 3) {			// change cost per person hour
				System.out.print("Enter new cost per person hour: ");
				double c = reader.nextDouble();
				if (c <= 0){
					System.out.println("Cost per person hour must be greater than 0.");
				} else {
					cocomoCalculator.setCPPH(c);
				}
			} else if (choice == 4) {			// change other attributes
				cocomoCalculator.printAttributeStatus();
				System.out.print("Number of attribute you would like to change: ");
				int attrNum = reader.nextInt();
				
				Attribute[] attributes = cocomoCalculator.getAttributes();
				
				while (attrNum < 0 || attrNum >= attributes.length) {
					System.out.println("Input " + attrNum + " is invalid (out of bounds).");
					System.out.print("Number of attribute you would like to change: ");
					attrNum = reader.nextInt();
				}
				String[] validValues = attributes[attrNum].getValidValues();
				System.out.println("Attribute: " + attributes[attrNum].getAttr() + " (" + attributes[attrNum].getStatus() + ")");
				System.out.println("Valid values: ");
				for (int i = 0; i < validValues.length; i++) {
					System.out.println("\t" + i + ") " + validValues[i]);
				}
				System.out.println("Input desired value for this attribute: ");
				
				boolean changed = false;
				
				while (!changed) {
					int in = reader.nextInt();
					try {
						cocomoCalculator.setAttribute(attrNum, in);
						changed = true;
					} catch (ArrayIndexOutOfBoundsException ex) {
						System.out.println(ex.toString());
					}
				}
			} else if (choice == 5) {			// exit
				again = false;
			} else {							// error
				System.out.println("\nInvalid choice. Try again.\n");
			}
		}

		System.out.println("\nThank you for using CocoCalc!");
	}
}
