import java.util.Scanner;

public class TestHeartRates {

	public static void main(String[] args) {
		
		HeartRates test = new HeartRates(null, null, 0);
		String first;
		String last;
		int yearOfBirth;

		Scanner scanner = new Scanner(System.in);
		
		// Input
		System.out.print("Person's First Name: ");
		first = scanner.nextLine();
		
		test.setFirstName(first);
		
		System.out.print("Person's Last Name: ");
		last = scanner.nextLine();
		test.setLastName(last);
		
		System.out.print("Person's Year of birth: ");
		yearOfBirth = scanner.nextInt();
		test.setYearOfBirth(yearOfBirth);
	
		// Output
		System.out.printf("\nFirst Name: %s", test.getFirstName() );
		System.out.printf("\nLast Name: %s", test.getLastName());
		System.out.printf("\nAge: %d", test.calculateAge());
		System.out.printf("\nMaximum Heart Rate: %d", test.maxHeartRate());
		
		System.out.printf("\nTarget heart rate range: %s", test.targetHeartRate());
		
		scanner.close();
	}

}
