
public class UtilityCar extends Car{
	private boolean rearCoolingVents;

	public UtilityCar() {
		super();
	}

	public UtilityCar(long id,String name,boolean rearCoolingVents) {
		super();
		this.id = id;
		this.name=name;
		this.rearCoolingVents = rearCoolingVents;
	}

	public boolean isRearCoolingVents() {
		return rearCoolingVents;
	}

	public void setRearCoolingVents(boolean rearCoolingVents) {
		this.rearCoolingVents = rearCoolingVents;
	}

	@Override
	public double calculateDriveCost(double kmCovered) {
		// TODO Auto-generated method stub
		
		double cost = 18*kmCovered;
		
		return cost;
	}

}
