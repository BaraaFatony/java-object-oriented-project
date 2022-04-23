package project;

import java.text.DecimalFormat;

public class Truck extends Vehicles {// class truck
//truck data member
	private int NumberOfSeats;

	private boolean airConditionON;
	private int power;

	Truck() {// default constructer

	}

	// another consteructor
	Truck(String modelName, String ModelNo, String Brand, String engineType, double tunkSize, double Fuelconsumption,
			Owner Owner, int NumberOfSeats, int power) throws IllegalArgumentException {
		String EngineType = checkengineType(engineType);// call check engine type ehen set it
		this.modelName = modelName;
		this.ModelNo = ModelNo;
		this.Brand = Brand;
		this.engineType = EngineType;
		this.tunkSize = tunkSize;
		this.Fuelconsumption = Fuelconsumption;
		this.Owner = Owner;
		this.NumberOfSeats = NumberOfSeats;
		this.power = power;
		this.airConditionON = false;

	}

	public void setNumberOfSeats(int NumberOfSeats) { // set Number Of Seats method
		this.NumberOfSeats = NumberOfSeats;
	}

	public void setAirConditionON() {// set air condition on method
		this.airConditionON = true;
	}

	public void setAirConditionOff() {// setAir Condition Off method
		this.airConditionON = false;
	}

	public int getNumberOfSeats() { // get Number Of Seats method
		return NumberOfSeats;
	}

	public boolean getairConditionON() { // get air Condition ON method
		return airConditionON;
	}

	public int getpower() { // get power method
		return power;
	}

	public void setpower(int power) {// set power method
		this.power = power;
	}

	public double cosFor100Km(PetroleumType type) { // calculate cost for 100 km method
		double cosFor100Km = 0;
		if (engineType.equals("Diesel") || engineType.equals("diesel")) {// check engine type
			if (airConditionON == false) {// check condition
				cosFor100Km = (1 / this.Fuelconsumption) * 100 * (PetroleumType.getDieselPrice());
			} else if (airConditionON == true) {// check condition
				cosFor100Km = ((1 / (this.Fuelconsumption))
						+ (((1 / (this.Fuelconsumption)) * 0.1)) * 100 * PetroleumType.getDieselPrice());
			}
		}

		return cosFor100Km;

	}

	public void setengineType(String engineType) throws IllegalArgumentException {// set engine Type method
		String EngineType = checkengineType(engineType);// call check engine type method
		this.engineType = EngineType;

	}

	public String checkengineType(String engineType) throws IllegalArgumentException {// check engine type method
		if (engineType.equals("Diesel") || engineType.equals("diesel")) {
			return engineType;
		} else {
			throw new IllegalArgumentException(" mismatch filling type of Petroleum");
		}

	}

	DecimalFormat df = new DecimalFormat("#.00");// decimal format to put just 2 digit after .

	public String toString() {// to string method
		PetroleumType type = new PetroleumType();

		return (super.toString() + " NumberOfSeats: " + NumberOfSeats + " Movable distance: " + this.Movabledistance()
				+ "cosFor100Km: " + df.format(this.cosFor100Km(type)) + "NIS" + " power: " + this.power);

	}

	public String aboutpower(int power) {// additional method to know more about power
		String aboutpower = null;
		if (this.power < 300) {
			aboutpower = "low power";

		} else if (this.power >= 300) {
			aboutpower = "hight power";

		}
		return aboutpower;
	}

	public String aboutfuelconsumption(double Fuelconsumption) {// additional method to know more about fuelconsumption
		String aboutfuelconsumption = null;
		if (this.Fuelconsumption < 100) {
			aboutfuelconsumption = "low fuelconsumption";

		} else if (this.Fuelconsumption >= 100) {
			aboutfuelconsumption = "hight fuelconsumption";

		}
		return aboutfuelconsumption;
	}
}
