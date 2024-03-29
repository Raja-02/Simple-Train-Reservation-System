import java.util.Scanner;
import java.util.Date;

public class reservation {

	private static int[] seats = new int[12];

	public static void main(String args[]) {
		System.out.println("Welcome to the  train reservation system ");
		System.out.println();
		

		for (int i = 0; i < 12; i++) {
			seats[i] = 0;
		}

		Scanner s = new Scanner(System.in);
		int choice = 1;

		System.out.print("Please enter 1 for window, 2 for aisle, or 0 to exit: ");
		choice = s.nextInt();

		while (choice != 0) {
			int seatnumber = 0;


		
			if (choice == 1) {
				seatnumber = bookWindow();



				if (seatnumber == -1) {
					seatnumber = bookAisle();
				
					if (seatnumber != -1) {
						System.out.println("we were not able to find a window seat avalible. But we do have an aisle seat.");
						printBoardingPass(seatnumber);
					}
				}
				else {
					
					System.out.println("we have a window seat available!");
					printBoardingPass(seatnumber);
				}
			}
			else if (choice == 2) {

				
				seatnumber = bookAisle();
			
				
				if (seatnumber == -1) {
					seatnumber = bookWindow();

					if (seatnumber != -1) {
						System.out.println("Sorry, we were not able to find  an aisle seat availble. But we do have a window seat.");
						printBoardingPass(seatnumber);
					}
				}
				else {
					
					System.out.println("we have an aisle seat available!");
					printBoardingPass(seatnumber);
				}
			}
			else {
				
				System.out.println("Invalid choice made. Please try again!");
				choice = 0;
			}


			 
			if (seatnumber == -1) {
				System.out.println("Oops ! , there are no window or aisle seats available.");
				System.out.println();
			}


			System.out.print("Please enter 1 for window, 2 for aisle, or 0 to exit: ");
			choice = s.nextInt();
		}

			
	}


	private static int bookWindow() {
		for (int i = 0; i < 6; i++) {
			if (seats[i] == 0) {
				seats[i] = 1;
				return i + 1;
			}
		}
		return -1;
	}


	private static int bookAisle() {
		for (int i = 6; i < 12; i++) {
			if (seats[i] == 0) {
				seats[i] = 1;
				return i + 1;
			}
		}
		return -1;

	}

	private static void printBoardingPass(int seatnumber) {
		Date timenow = new Date();
		System.out.println();
		System.out.println("Date: " + timenow.toString());
		System.out.println("seat number: " + seatnumber);
		System.out.println("The ticket is non-refundable and non-transferable.");
	}
}
