package project;

import java.text.DecimalFormat;

public class Car extends Vehicles {// class car

	private int NumberOfSeats; // car data members

	private boolean airConditionON;

	Car() {// default constructor

	}

	// another car constructor
	Car(String modelName, String ModelNo, String Brand, String engineType, double tunkSize, double Fuelconsumption,
			Owner Owner, int NumberOfSeats) throws IllegalArgumentException {
		String EngineType = checkengineType(engineType);// call checkengineType method
		this.modelName = modelName;
		this.ModelNo = ModelNo;
		this.Brand = Brand;
		this.engineType = EngineType;
		this.tunkSize = tunkSize;
		this.Fuelconsumption = Fuelconsumption;
		this.Owner = Owner;
		this.NumberOfSeats = NumberOfSeats;
		this.airConditionON = false;// set condition off by default

	}

	@Override

	public void setNumberOfSeats(int NumberOfSeats) { // set Number Of Seats method
		this.NumberOfSeats = NumberOfSeats;
	}

	public void setAirConditionON() {// set Air Condition ON method
		this.airConditionON = true;
	}

	public void setAirConditionOff() {// set Air Condition Off method
		this.airConditionON = false;
	}

	public int getNumberOfSeats() { // get Number Of Seats
		return NumberOfSeats;
	}

	public boolean getairConditionON() { // get air Condition ON method
		return airConditionON;
	}

	public double cosFor100Km(PetroleumType type) { // cost for 100km method
		double cosFor100Km = 0;

		if (engineType.equals("Gasoline")) { // check if gasoline
			if (airConditionON == false) {// check condition
				cosFor100Km = (1 / this.Fuelconsumption) * 100 * (PetroleumType.getGasolinePrice());
			} else if (airConditionON == true) {// check condition
				cosFor100Km = ((1 / (this.Fuelconsumption))
						+ (((1 / (this.Fuelconsumption)) * 0.1)) * 100 * PetroleumType.getDieselPrice());

			}
			if (engineType.equals("Hybrid")) {// check if hybrid
				if (airConditionON == false) {// check condition
					cosFor100Km = (1 / this.Fuelconsumption) * 100 * PetroleumType.getGasolinePrice();
				} else if (airConditionON == true) {// check condition
					cosFor100Km = ((1 / (this.Fuelconsumption))
							+ (((1 / (this.Fuelconsumption)) * 0.1)) * 100 * PetroleumType.getGasolinePrice());
				}
			}
		}
		return cosFor100Km;
	}

	@Override
	public void setengineType(String engineType) throws IllegalArgumentException {// set engine Type method
		checkengineType(engineType);// call check engine type method
		String EngineType = checkengineType(engineType);
		this.engineType = EngineType;

	}

	public String checkengineType(String engineType) throws IllegalArgumentException {// check engine type method
		if (engineType.equals("gasoline") || engineType.equals("Gasoline") || engineType.equals("Hybrid")
				|| engineType.equals("hybrid")) {
			return engineType;
		} else {
			throw new IllegalArgumentException(" mismatch filling type of Petroleum");

		}
	}

	DecimalFormat df = new DecimalFormat("#.00");// decimal format to take just 2 digit after . in cos100km

	public String toString() { // tostrinf method
		PetroleumType type = new PetroleumType();
		return (super.toString() + " NumberOfSeats: " + NumberOfSeats + " Movable distance: " + this.Movabledistance()
				+ "cosFor100Km: " + df.format(this.cosFor100Km(type)) + "NIS");

	}

	public String aboutfuelconsumption(double Fuelconsumption) {// additional method to know more about fuelconsumption
		String aboutfuelconsumption = null;
		if (this.Fuelconsumption < 60) {
			aboutfuelconsumption = "low fuelconsumption";

		} else if (this.Fuelconsumption >= 60) {
			aboutfuelconsumption = "hight fuelconsumption";

		}
		return aboutfuelconsumption;
	}

}
