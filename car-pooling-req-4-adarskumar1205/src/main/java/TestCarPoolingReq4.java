import java.util.Scanner;

public class TestCarPoolingReq4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
				
		System.out.println("id:");
		long id=scanner.nextLong();
		scanner.nextLine();
		
		System.out.println("name:");
		String name=scanner.nextLine();
		
		System.out.println("type:");
		String type=scanner.nextLine();
		
		System.out.println("distance:");
		double distance=scanner.nextDouble();
		scanner.nextLine();
		
		
			switch(type) {
			case "hatchback" : 
						hatchBack(scanner,distance,id,name);
						break;
			case "sedan" : 
						sedanCar(scanner,distance,id,name);
						break;
			case "utility" :
						utilityCar(scanner,distance,id,name);
						break;			
			default : 
					System.out.println("Enter a valid type of car:");		
		}
			
	}
	
	private static void hatchBack(Scanner scanner,double distance,long id,String name) {
		System.out.println("power windows:");
		boolean powerWindows=scanner.nextBoolean();
		
		System.out.println("automatic:");
		boolean automaticGear=scanner.nextBoolean();
		
		HatchBack car = new HatchBack(id,name,powerWindows,automaticGear);
		
		System.out.format("%.0f", car.calculateDriveCost(distance));
		
	}
	
	private static void sedanCar(Scanner scanner,double distance,long id,String name) {
		System.out.println("abs enabled:");
		boolean absEnabled=scanner.nextBoolean();
		
		System.out.println("boot space:");
		int bootSpace=scanner.nextInt();
		
		Sedan car = new Sedan(id,name,absEnabled,bootSpace);
		
		System.out.format("%.0f", car.calculateDriveCost(distance));
	}
	
	private static void utilityCar(Scanner scanner,double distance,long id,String name) {
		System.out.println("rear cooling vents:");
		boolean rearCoolingVents=scanner.nextBoolean();
		
		UtilityCar car = new UtilityCar(id,name,rearCoolingVents);
		
		System.out.format("%.0f", car.calculateDriveCost(distance));
	}

}
