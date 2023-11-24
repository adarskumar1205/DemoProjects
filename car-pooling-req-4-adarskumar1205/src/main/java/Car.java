
public abstract class Car {
	protected long id;
	
	protected String name;

	public Car() {
		super();
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

	public abstract double calculateDriveCost(double kmCovered);

}
