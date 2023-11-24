import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestCarPoolingReq5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<Member> memberList = new ArrayList<>();
		ArrayList<Car> carList = new ArrayList<>();
		ArrayList<MemberCar> memberCarList = new ArrayList<>();
		
		Member.createMember(memberList,"1,joe,root,joe.root@a.com,1234567890,AH1,12-12-2001,12-12-2010");
		Member.createMember(memberList,"2,ben,stokes,ben.stokes@a.com,2345678901,AH2,12-12-2002,12-12-2011");
		Member.createMember(memberList,"3,virat,kohli,virat.kohli@a.com,3456789012,AH3,12-12-2003,12-12-2012");
		
		Car.createCar(carList,"1,i10,sports,2007,Hyundai,8");
		Car.createCar(carList,"2,alto,kx1,2008,Maruti,6");
		Car.createCar(carList,"3,polo,topline,2010,Volks,5");
		Car.createCar(carList,"4,kwid,lxi,2010,Renault,5");
		
		System.out.println("color to search:");
		String carColor=scanner.nextLine();
		
		System.out.println("Number of member cars");
		int memberCars=scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter the member car details");
		while(memberCars-->0) {
			String membercar=scanner.nextLine();
			
			MemberCar.createMemberCar(memberCarList,carList,memberList,membercar);
		}
		
		Map<String, List<MemberCar>> colorMembercar = groupByColor(carList, memberList, memberCarList);
		
		
		System.out.println(carColor + " car registration numbers:");
		
		for(MemberCar memberCar : colorMembercar.get(carColor)) {
			System.out.println(memberCar.getCarRegistrationNumber());
		}
		
	}

	public static Map<String, List<MemberCar>> groupByColor(ArrayList<Car> carList,
			ArrayList<Member> memberList, ArrayList<MemberCar> memberCarList){
		
		Map<String, List<MemberCar>> colorMembercar = new HashMap<>();
		
		for(MemberCar memberCar : memberCarList) {
			
			String mapKey=memberCar.getCarColor();
			if(colorMembercar.containsKey(mapKey)) {
				colorMembercar.get(mapKey).add(memberCar);
				
			}
			else {
				List<MemberCar> list = new ArrayList<>();
				list.add(memberCar);
				
				colorMembercar.put(mapKey, list);
			}
		}
		
		return colorMembercar;
	}
}
