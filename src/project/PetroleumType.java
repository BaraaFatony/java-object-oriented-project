package project;

public class PetroleumType {// PetroleumType class
	public static final int DIESEL = 1;
	public static final int GASOLINE = 2;

	private static double GasolinePrice = 5.23;// defualt value
	private static double DieselPrice = 4.02;

	public static double getGasolinePrice() {// getGasolinePrice method
		return GasolinePrice;
	}

	public static void setGasolinePrice(double gasolinePrice) {// setGasolinePrice method
		PetroleumType.GasolinePrice = gasolinePrice;
	}

	public static double getDieselPrice() {// getDieselPrice method
		return DieselPrice;
	}

	public static void setDieselPrice(double DieselPrice) {// setDieselPrice method
		PetroleumType.DieselPrice = DieselPrice;
	}
	public String aboutDieselPrice(double DieselPrice) {// additional method to know more about DieselPrice
		String aboutDieselPrice = null;
		if (DieselPrice < 5) {
			aboutDieselPrice = "low DieselPrice";

		} else if (DieselPrice >= 5) {
			aboutDieselPrice = "hight fuelconsumption";

		}
		return aboutDieselPrice;
	}
	public String aboutGasolinePrice(double GasolinePrice) {// additional method to know more about GasolinePrice
		String aboutGasolinePrice = null;
		if (GasolinePrice < 7) {
			aboutGasolinePrice = "low DieselPrice";

		} else if (GasolinePrice >= 7) {
			aboutGasolinePrice = "hight GasolinePrice";

		}
		return aboutGasolinePrice;
	}

}