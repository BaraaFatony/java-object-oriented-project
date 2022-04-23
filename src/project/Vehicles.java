package project;

import java.util.Comparator;

public abstract class Vehicles implements Comparable<Vehicles>, Cloneable {

	// vechicle data members
	protected String modelName;

	protected String ModelNo;

	protected String Brand;
	protected String engineType;
	protected double tunkSize;
	protected double Fuelconsumption;
	public Owner Owner;
	private boolean breakdown;// additional data type

	public Vehicles() {// default constructer

	}

	@Override
	public Object clone() throws CloneNotSupportedException {// clone method override from cloneable interface
		Vehicles vClone = (Vehicles) super.clone();
		vClone.Owner = null;// make owner null
		return vClone;
	}

	public String getmodelName() {// get model name method

		return modelName;

	}

	public void setmodelName(String modelName) {// set model name method

		this.modelName = modelName;

	}

	public void setModelNo(String ModelNo) {// set model name method

		this.ModelNo = ModelNo;

	}

	public String getModelNo() { // get model nomber method

		return ModelNo;

	}

	public void setBrand(String Brand) {// set brand method

		this.Brand = Brand;

	}

	public String getBrand() {// get brand method

		return Brand;

	}

	public abstract void setNumberOfSeats(int NumberOfSeats); // abstract set number of seats method

	public String getengineType() {// get engine type method

		return engineType;

	}

	public void settunkSize(double tunkSize) {// set tunksize method

		this.tunkSize = tunkSize;

	}

	public double gettunkSize() {// get tunk size method

		return tunkSize;

	}

	public void setFuelconsumption(double Fuelconsumption) {// set fuel consumption method

		this.Fuelconsumption = Fuelconsumption;

	}

	public double getFuelconsumption() {// get fuel consumption method

		return Fuelconsumption;

	}

	public void setOwner(Owner Owner) { // set owner method

		this.Owner = Owner;

	}

	public Owner getOwner() { // get owner method

		return Owner;

	}

	@Override
	public int compareTo(Vehicles v) { // compareto method that compare cost for 100km of vehicles
		PetroleumType type = new PetroleumType();
		return Double.compare(this.cosFor100Km(type), v.cosFor100Km(type));
	}

	public abstract double cosFor100Km(PetroleumType type);// abstract cost for 100km method

	public double Movabledistance() { // method to return movable distance method
		return (tunkSize * Fuelconsumption);

	}

	public abstract void setAirConditionON();// abstract set air condition on

	public abstract void setAirConditionOff();// abstract set air condition off

	public abstract String checkengineType(String engineType);// abstract to check engine type (additional method)

	public String toString() {// to string method
		String s;
		if (this.getOwner() == null) {// check if owner = null
			s = ("ModelName: " + modelName + " Brand: " + Brand + " Owner: " + this.Owner.getName() + " EngineType: "
					+ engineType + " tankSize: " + tunkSize + " Fuelconsumption: " + Fuelconsumption + " Name: null");

		} else {
			s = ("modelName: " + modelName + " ModelNo: " + ModelNo + " Brand: " + Brand + " engineType: " + engineType
					+ " tunkSize: " + tunkSize + " Fuelconsumption: " + Fuelconsumption + " Name: "
					+ this.getOwner().getName());
		}
		return s;
	}

	public void hasbreakdown() {// addtional when vehicle has break down
		this.breakdown = true;

	}

	public void hasnotbreakdown() {// addtional when vehicle has break down
		this.breakdown = false;

	}

	public abstract String aboutfuelconsumption(double Fuelconsumption);// addtional method

	protected abstract void setengineType(String string);// abstract set engine type method

}