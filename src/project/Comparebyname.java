package project;

import java.util.Comparator;

class Comparebyname implements Comparator<Vehicles> {// Comparator to sort by name method

	@Override
	public int compare(Vehicles arg0, Vehicles arg1) {

		return arg0.getOwner().getName().compareTo(arg1.getOwner().getName());
	}

}

class Comparebybrandname implements Comparator<Vehicles> {// Comparator to compare by brand name method

	@Override
	public int compare(Vehicles arg0, Vehicles arg1) {

		return -(arg0.getBrand().compareTo(arg1.getBrand()));
	}

}
