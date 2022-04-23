package project;

import java.text.DecimalFormat;

public class Minivan extends Vehicles {// class mimivan
//mini van data members
	private int NumberOfSeats;

	private boolean airConditionON;
	private boolean hasAutoDoors;

	Minivan() {// defaule constructor

	}

//another constructor
	Minivan(String modelName, String ModelNo, String Brand, String engineType, double tunkSize, double Fuelconsumption,
			Owner Owner, int NumberOfSeats, boolean hasAutoDoors) throws IllegalArgumentException {
		String EngineType = checkengineType(engineType);// call check engine type method when set it
		this.modelName = modelName;
		this.ModelNo = ModelNo;
		this.Brand = Brand;
		this.engineType = EngineType;
		this.tunkSize = tunkSize;
		this.Fuelconsumption = Fuelconsumption;
		this.Owner = Owner;
		this.NumberOfSeats = NumberOfSeats;
		this.airConditionON = false;
		this.hasAutoDoors = hasAutoDoors;

	}

	DecimalFormat df = new DecimalFormat("#.00");// decimal format to put just 2 digit after .

	public void setNumberOfSeats(int NumberOfSeats) { // setNumberOfSeats method
		this.NumberOfSeats = NumberOfSeats;
	}

	public void setAirConditionON() {// setAirConditionON method
		this.airConditionON = true;
	}

	public void setAirConditionOff() {// setAirConditionOff method
		this.airConditionON = false;
	}

	public int getNumberOfSeats() { // getNumberOfSeats method
		return NumberOfSeats;
	}

	public boolean getairConditionON() { // getairConditionON method
		return airConditionON;
	}

	public boolean gethasAutoDoors() { // gethasAutoDoors method
		return hasAutoDoors;
	}

	public void sethasAutoDoors(boolean hasAutoDoors) {// sethasAutoDoors method
		this.hasAutoDoors = hasAutoDoors;
	}

	public double cosFor100Km(PetroleumType type) { // calculate cost for 100 km method
		double cosFor100Km = 0;
		if (this.engineType.equals("Diesel") || engineType.equals("diesel")) {// check engine type
			if (airConditionON == false) { // check condition
				cosFor100Km = (1 / this.Fuelconsumption) * 100 * (PetroleumType.getDieselPrice());
			} else if (airConditionON == true) {// check condition
				cosFor100Km = ((1 / (this.Fuelconsumption))
						+ (((1 / (this.Fuelconsumption)) * 0.2)) * 100 * PetroleumType.getDieselPrice());
			}
		} else if (this.engineType.equals("Gasoline") || engineType.equals("gasoline")) {// check engine type
			if (airConditionON == false) {// check condition
				cosFor100Km = (1 / Fuelconsumption) * 100 * (PetroleumType.getGasolinePrice());
			} else if (airConditionON == true) {// check condition
				cosFor100Km = ((1 / (this.Fuelconsumption))
						+ (((1 / (this.Fuelconsumption)) * 0.1)) * 100 * PetroleumType.getGasolinePrice());

			}
		} else if (this.engineType.equals("Hybrid") || engineType.equals("hybrid")) {// check engine type
			if (airConditionON == false) {// check condition
				cosFor100Km = (1 / this.Fuelconsumption) * 100 * PetroleumType.getGasolinePrice();
			} else if (airConditionON == true) {// check condition
				cosFor100Km = ((1 / (this.Fuelconsumption))
						+ (((1 / (this.Fuelconsumption)) * 0.1)) * 100 * PetroleumType.getGasolinePrice());
			}
		}
		return cosFor100Km;

	}

	public void setengineType(String engineType) throws IllegalArgumentException {// setengineType method
		checkengineType(engineType);
		String EngineType = checkengineType(engineType);
		this.engineType = EngineType;

	}

	public String checkengineType(String engineType) throws IllegalArgumentException {// checkengineType method
		if (engineType.equals("gasoline") || engineType.equals("Gasoline") || engineType.equals("diesel")
				|| engineType.equals("Diesel") || engineType.equals("Hybrid") || engineType.equals("hybrid")) {
			return engineType;
		} else {
			throw new IllegalArgumentException(" mismatch filling type of Petroleum");
		}

	}

	public String toString() {
		PetroleumType type = new PetroleumType();

		return (super.toString() + " NumberOfSeats: " + NumberOfSeats + " Movable distance: " + this.Movabledistance()
				+ "cosFor100Km: " + df.format(this.cosFor100Km(type)) + "NIS");

	}

	public String aboutfuelconsumption(double Fuelconsumption) {// additional method to know more about fuelconsumption
		String aboutfuelconsumption = null;
		if (this.Fuelconsumption < 80) {
			aboutfuelconsumption = "low fuelconsumption";

		} else if (this.Fuelconsumption >= 80) {
			aboutfuelconsumption = "hight fuelconsumption";

		}
		return aboutfuelconsumption;
	}
}
