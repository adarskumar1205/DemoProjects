import java.util.ArrayList;

public class Car {
	private long id;                 
	private String name;          
	private String model;                         
	private Integer makeYear;       
	private String company; 
	private Integer comfortLevel;
	
	public static ArrayList<Car> cars = new ArrayList<>();
	
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
	 
	public static Car findCar(long id) {
		for(Car car : cars) {
			if(car.getId() == id)
				return car;
		}
		
		return null;
	}

}
