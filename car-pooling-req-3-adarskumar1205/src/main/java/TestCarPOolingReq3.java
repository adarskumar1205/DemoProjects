import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class TestCarPOolingReq3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("Menu:\n"
					+ "1) Valid Car registration Number\r\n"
					+ "2) Convert Car registration Number\r\n"
					+ "3) Valid Driving License\r\n"
					+ "Enter choice");
			
			int choice=scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
			case 1 : 
					validateCarRegistration(scanner);
					break;
			case 2 : 
					convertCarRegistration(scanner);
					break;
			case 3 :
					validateLicense(scanner);
					break;			
			default :
					return;
			}
		}
			
	}
	
	private static void validateCarRegistration(Scanner scanner) {
		System.out.println("car registration number:");
		String carRegistrationNumber=scanner.nextLine();
		
		boolean valid = Pattern.matches("[A-Z]{2}[-]{1}[0-9]{2}[-]{1}[A-Z]{2}[-]{1}[0-9]{4}", carRegistrationNumber);
		
		if(valid) {
			System.out.println(carRegistrationNumber + " is Valid");
		}
		else {
			System.out.println(carRegistrationNumber + " is Invalid");
		}
		
	}
	
	private static void convertCarRegistration(Scanner scanner) {
		System.out.println("car registration number:");
		String carRegistrationNumber=scanner.nextLine();
		
		carRegistrationNumber=carRegistrationNumber.toUpperCase();
		
		carRegistrationNumber=carRegistrationNumber.replaceAll("[^a-zA-Z0-9]", "-");
		
		System.out.println(carRegistrationNumber);	
	}
	
	private static void validateLicense(Scanner scanner) {
		System.out.println("driving license issue date:");
		String licenseIssueDate=scanner.nextLine();
		
		try {
			Date issueDate = new SimpleDateFormat("dd-MM-yyyy").parse(licenseIssueDate);
			Date currentDate = new SimpleDateFormat("dd-MM-yyyy").parse("15-06-2017");
			
			long diff_time = currentDate.getTime() - issueDate.getTime();
			
			long years = TimeUnit.MILLISECONDS.toDays(diff_time)/365l;
			long rem = TimeUnit.MILLISECONDS.toDays(diff_time)%365l;
			
			if(years<0) {
				System.out.println("Enter a valid issue date");
			}
			else if(years<10 || (years==10 && rem==0)) {
				System.out.println(years+" years old license - valid");
			}
			else {
				System.out.println(years+" years old license - expired");
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
