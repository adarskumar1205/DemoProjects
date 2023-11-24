
public class Sedan extends Car {
	private boolean absEnabled;
	private int bootSpace;
	
	public Sedan() {
		super();
	}

	public Sedan(long id,String name,boolean absEnabled, int bootSpace) {
		super();
		this.id = id;
		this.name=name;
		this.absEnabled = absEnabled;
		this.bootSpace = bootSpace;
	}

	public boolean isAbsEnabled() {
		return absEnabled;
	}

	public void setAbsEnabled(boolean absEnabled) {
		this.absEnabled = absEnabled;
	}

	public int getBootSpace() {
		return bootSpace;
	}

	public void setBootSpace(int bootSpace) {
		this.bootSpace = bootSpace;
	}

	@Override
	public double calculateDriveCost(double kmCovered) {
		// TODO Auto-generated method stub
		double cost = 15* kmCovered;
		
		if(this.bootSpace > 600) {
			cost+= cost*(0.2);
		}
		
		return cost;
	}

}
