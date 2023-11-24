import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Car {
	private long id;                 
	private String name;          
	private String model;                         
	private int makeYear;       
	private String company; 
	private int comfortLevel;
	
	public Car() {
		super();
	}
	
	public Car(long id, String name, String model, Integer makeYear, String company, Integer comfortLevel) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.makeYear = makeYear;
		this.company = company;
		this.comfortLevel = comfortLevel;
	}
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getMakeYear() {
		return makeYear;
	}
	public void setMakeYear(Integer makeYear) {
		this.makeYear = makeYear;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Integer getComfortLevel() {
		return comfortLevel;
	}
	public void setComfortLevel(Integer comfortLevel) {
		this.comfortLevel = comfortLevel;
	}     
	 
	public static Car findCar(ArrayList<Car> carList,long id) {
		for(Car car : carList) {
			if(car.getId() == id)
				return car;
		}
		
		return null;
	}
	
	public static void createCar(ArrayList<Car> carList,String str) {
		String[] strArr =str.split(","); 
		long memberId = Long.parseLong(strArr[0]); 
		int year = Integer.parseInt(strArr[3]);
		int level = Integer.parseInt(strArr[5]);
	
		Car car = new Car(memberId,strArr[1],strArr[2],year,strArr[4],level); 
			
		carList.add(car);	
	}


}
