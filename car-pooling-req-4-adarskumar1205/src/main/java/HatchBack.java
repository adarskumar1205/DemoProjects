
public class HatchBack extends Car {
	private boolean powerWindowsEnabled;
	private boolean automaticGear;
	
	public HatchBack() {
		super();
	}
	
	

	public HatchBack(long id,String name,boolean powerWindowsEnabled, boolean automaticGear) {
		super();
		this.id = id;
		this.name=name;
		this.powerWindowsEnabled = powerWindowsEnabled;
		this.automaticGear = automaticGear;
		System.out.println();
	}



	public boolean isPowerWindowsEnabled() {
		return powerWindowsEnabled;
	}



	public void setPowerWindowsEnabled(boolean powerWindowsEnabled) {
		this.powerWindowsEnabled = powerWindowsEnabled;
	}



	public boolean isAutomaticGear() {
		return automaticGear;
	}



	public void setAutomaticGear(boolean automaticGear) {
		this.automaticGear = automaticGear;
	}


	@Override
	public double calculateDriveCost(double kmCovered) {
		// TODO Auto-generated method stub
		double cost=0;
		
		if(this.automaticGear) {
			cost+=12 * kmCovered;
		}
		else {
			cost+=10 * kmCovered;
		}
		
		return cost;
	}

}
