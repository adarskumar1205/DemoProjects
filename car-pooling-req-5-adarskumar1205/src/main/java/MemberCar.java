import java.util.ArrayList;

public class MemberCar {
	private long id;                 
	private Member member;          
	private Car car;                              
	private String carRegistrationNumber; 
	private String carColor;
	
	public MemberCar() {
		super();
	}
	
	
	public MemberCar(long id, Member member, Car car, String carRegistrationNumber, String carColor) {
		super();
		this.id = id;
		this.member = member;
		this.car = car;
		this.carRegistrationNumber = carRegistrationNumber;
		this.carColor = carColor;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getCarRegistrationNumber() {
		return carRegistrationNumber;
	}
	public void setCarRegistrationNumber(String carRegistrationNumber) {
		this.carRegistrationNumber = carRegistrationNumber;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	
	public static void createMemberCar(ArrayList<MemberCar> memberCarList,
			ArrayList<Car> carList,ArrayList<Member> memberList,String str) {
		String[] strArr =str.split(","); 
		long memberCarId = Long.parseLong(strArr[0]); 
		int memberId = Integer.parseInt(strArr[1]);
		int carId = Integer.parseInt(strArr[2]);
	
		Member member1 = Member.findMember(memberList,memberId);
		Car car1 = Car.findCar(carList,carId);
		
		if(member1==null) {
			System.out.println("Member with id: "+memberId+" doesn't exist.\nPlease add a member first then assign a car.");
		}
		
		MemberCar memberCar = new MemberCar(memberCarId,member1,car1,strArr[3],strArr[4]); 
			
		memberCarList.add(memberCar);	
	}


}
