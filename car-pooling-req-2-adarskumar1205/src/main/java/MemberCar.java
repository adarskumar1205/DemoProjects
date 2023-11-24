
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

}
