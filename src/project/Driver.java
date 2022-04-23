package project;

import project.*;
import java.io.*;
import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Driver {// driver

	static List<Vehicles> vehicles;

	public static void main(String[] args) throws IOException, CloneNotSupportedException {

		int option;
		List<Vehicles> vehiclesList = new ArrayList<>();// ArrayList of vehicles

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);// scanner to take choice
		System.out.println("Choose An Option: ");
		System.out.println("1. Read the data about objects from the file “inputdata.txt” and store them in Arraylist.");
		System.out.println("2. Set prices of petroleum.");
		System.out.println("3. print vehicles in ascending order base on cost for100km");
		System.out.println("4. print vehicles in ascending order base on owner name");
		System.out.println("5. print vehicles in descending order based on brand");
		System.out.println("6. Clone Vehicle without owner");
		System.out.println("7. turn air-conditions on");
		System.out.println("8. Write Output on the “output.txt” file after sort them");
		System.out.println("9. exit");
		while (true) {
			option = in.nextInt();

			switch (option) {// switch on option
			case 1 -> {// case 1 in menue
				// take data from inputdata file and split it by line and by , and save it in
				// array list of vehicle objects
				StringBuilder data = readFile("inputdata.txt");
				String data1 = data.toString();
				data1 = data1.replaceAll(" ", "");

				String[] vehicle = data1.split("\n");
				try {
					for (String Vehicles : vehicle) {
						if (Vehicles.length() > 0) {
							String[] vehicleData = Vehicles.split(",");
							Vehicles v;
							if (vehicleData[0].equals("Car")) {
								v = new Car();
							} else if (vehicleData[0].equals("MiniVan")) {
								v = new Minivan();
							} else if (vehicleData[0].equals("Truck")) {
								v = new Truck();
								((Truck) v).setpower(Integer.parseInt(vehicleData[9]));
							} else {
								throw new IllegalArgumentException();
							}

							v.setmodelName(vehicleData[1]);
							v.setModelNo(vehicleData[2]);
							v.setBrand(vehicleData[3]);
							Owner owner = new Owner(vehicleData[4]);
							v.setOwner(owner);
							v.setengineType(vehicleData[5]);
							v.settunkSize(Double.parseDouble(vehicleData[6]));
							v.setFuelconsumption(Double.parseDouble(vehicleData[7]));
							v.setNumberOfSeats(Integer.parseInt(vehicleData[8]));

							if (vehicleData.length > 9
									&& (vehicleData[9].equals("true") || vehicleData[9].equals("false"))) {
								if (vehicleData[9].equals("true")) {
									v.setAirConditionON();
								}
							}

							vehiclesList.add(v);

						}
					}
				} catch (IllegalArgumentException ex) {
					ex.printStackTrace();
				}
				System.out.println("input readed successfully");
				System.out.println("Choose An Option: ");
				System.out.println(
						"1. Read the data about objects from the file “inputdata.txt” and store them in Arraylist.");
				System.out.println("2. Set prices of petroleum.");
				System.out.println("3. print vehicles in ascending order base on cost for100km");
				System.out.println("4. print vehicles in ascending order base on owner name");
				System.out.println("5. print vehicles in descending order based on brand");
				System.out.println("6. Clone Vehicle without owner");
				System.out.println("7. turn air-conditions on");
				System.out.println("8. Write Output on the “output.txt” file after sort them");
				System.out.println("9. exit");
			}
			case 2 -> { // case 2 in menu
				// set gasoline and diesel price
				System.out.println(" Gasoline price: ");
				double price1 = in.nextDouble();
				PetroleumType.setGasolinePrice(price1);
				System.out.println(" Diesel price: ");
				double price2 = in.nextDouble();
				PetroleumType.setDieselPrice(price2);
				System.out.println("the price  set successfully");
				System.out.println("Choose An Option: ");
				System.out.println(
						"1. Read the data about objects from the file “inputdata.txt” and store them in Arraylist.");
				System.out.println("2. Set prices of petroleum.");
				System.out.println("3. print vehicles in ascending order base on cost for100km");
				System.out.println("4. print vehicles in ascending order base on owner name");
				System.out.println("5. print vehicles in descending order based on brand");
				System.out.println("6. Clone Vehicle without owner");
				System.out.println("7. turn air-conditions on");
				System.out.println("8. Write Output on the “output.txt” file after sort them");
				System.out.println("9. exit");
			}
			case 3 -> {// case 3 in menu
				// sort vehicles by cost of 100km and compare to method
				Collections.sort(vehiclesList);
				showVehicles(vehiclesList);
				System.out.println("sorted successfully");
				System.out.println("Choose An Option: ");
				System.out.println(
						"1. Read the data about objects from the file “inputdata.txt” and store them in Arraylist.");
				System.out.println("2. Set prices of petroleum.");
				System.out.println("3. print vehicles in ascending order base on cost for100km");
				System.out.println("4. print vehicles in ascending order base on owner name");
				System.out.println("5. print vehicles in descending order based on brand");
				System.out.println("6. Clone Vehicle without owner");
				System.out.println("7. turn air-conditions on");
				System.out.println("8. Write Output on the “output.txt” file after sort them");
				System.out.println("9. exit");
			}
			case 4 -> {// case 4 in menu
				// Print sorted order Vehicles in an ascending order based on owner name
				Collections.sort(vehiclesList, new Comparebyname());
				showVehicles(vehiclesList);
				System.out.println("sorted successfully");
				System.out.println("Choose An Option: ");
				System.out.println(
						"1. Read the data about objects from the file “inputdata.txt” and store them in Arraylist.");
				System.out.println("2. Set prices of petroleum.");
				System.out.println("3. print vehicles in ascending order base on cost for100km");
				System.out.println("4. print vehicles in ascending order base on owner name");
				System.out.println("5. print vehicles in descending order based on brand");
				System.out.println("6. Clone Vehicle without owner");
				System.out.println("7. turn air-conditions on");
				System.out.println("8. Write Output on the “output.txt” file after sort them");
				System.out.println("9. exit");
			}
			case 5 -> {// case 5 in menu
				// ) Print sorted order Vehicles in an descending order based on vehicle brand.
				Collections.sort(vehiclesList, new Comparebybrandname());
				showVehicles(vehiclesList);
				System.out.println("sorted successfully");
				System.out.println("Choose An Option: ");
				System.out.println(
						"1. Read the data about objects from the file “inputdata.txt” and store them in Arraylist.");
				System.out.println("2. Set prices of petroleum.");
				System.out.println("3. print vehicles in ascending order base on cost for100km");
				System.out.println("4. print vehicles in ascending order base on owner name");
				System.out.println("5. print vehicles in descending order based on brand");
				System.out.println("6. Clone Vehicle without owner");
				System.out.println("7. turn air-conditions on");
				System.out.println("8. Write Output on the “output.txt” file after sort them");
				System.out.println("9. exit");
			}
			case 6 -> {// case 6 in menu
				// Clone Vehicle without owner. (Ask user to choice one object for cloning from
				// Arraylist, after Listing them to user )
				showVehicles(vehiclesList);
				System.out.println("select vehicle to clone: ");
				int index = in.nextInt();
				while (true) {
					if (index >= vehiclesList.size()) {
						System.out.println("vehicle not exist!");
						System.out.println("select vehicle to clone: ");
						index = in.nextInt();
						continue;
					}
					Vehicles vClone = (Vehicles) vehiclesList.get(index - 1).clone();
					vehiclesList.add(vClone);
					System.out.println("vehicle cloned successfully");
					System.out.println("Choose An Option: ");
					System.out.println(
							"1. Read the data about objects from the file “inputdata.txt” and store them in Arraylist.");
					System.out.println("2. Set prices of petroleum.");
					System.out.println("3. print vehicles in ascending order base on cost for100km");
					System.out.println("4. print vehicles in ascending order base on owner name");
					System.out.println("5. print vehicles in descending order based on brand");
					System.out.println("6. Clone Vehicle without owner");
					System.out.println("7. turn air-conditions on");
					System.out.println("8. Write Output on the “output.txt” file after sort them");
					System.out.println("9. exit");
					showVehicles(vehiclesList);

					break;

				}

			}
			case 7 -> {// case 7 in menu
				// Turn air-condition on
				for (Vehicles vehicle : vehiclesList) {
					vehicle.setAirConditionON();
				}
				System.out.println("the air-conditioning have turned on successfully");
				System.out.println("Choose An Option: ");
				System.out.println(
						"1. Read the data about objects from the file “inputdata.txt” and store them in Arraylist.");
				System.out.println("2. Set prices of petroleum.");
				System.out.println("3. print vehicles in ascending order base on cost for100km");
				System.out.println("4. print vehicles in ascending order base on owner name");
				System.out.println("5. print vehicles in descending order based on brand");
				System.out.println("6. Clone Vehicle without owner");
				System.out.println("7. turn air-conditions on");
				System.out.println("8. Write Output on the “output.txt” file after sort them");
				System.out.println("9. exit");
			}
			case 8 -> {// case 8 in menu
				// Write Output on the “output.txt” file after sort them.
				StringBuilder output = new StringBuilder();
				for (Vehicles vehicle : vehiclesList) {
					output.append(vehicle.toString() + "\n");
				}
				writeFile(output, "output1.txt");
				System.out.println("data wrote to file successfully");
				System.out.println("Choose An Option: ");
				System.out.println(
						"1. Read the data about objects from the file “inputdata.txt” and store them in Arraylist.");
				System.out.println("2. Set prices of petroleum.");
				System.out.println("3. print vehicles in ascending order base on cost for100km");
				System.out.println("4. print vehicles in ascending order base on owner name");
				System.out.println("5. print vehicles in descending order based on brand");
				System.out.println("6. Clone Vehicle without owner");
				System.out.println("7. turn air-conditions on");
				System.out.println("8. Write Output on the “output.txt” file after sort them");
				System.out.println("9. exit");
			}
			case 9 -> {
				System.exit(1);
			}
			}
		}
	}

	public static void showVehicles(List<Vehicles> vehiclesList) throws IOException {// show vehicle information method
		System.out.println("Vehicles: ");
		int index = 1;
		for (Vehicles v : vehiclesList) {
			System.out.println(index + ". " + v.toString());
			index++;
		}
	}

	public static StringBuilder readFile(String fileName) throws IOException { // read from input file method
		StringBuilder data = new StringBuilder("");// using string builder

		try {
			File input = new File(fileName);
			Scanner Reader = new Scanner(input);
			while (Reader.hasNextLine()) {
				data.append(Reader.nextLine());
				data.append("\n");
			}
			Reader.close();
		} catch (FileNotFoundException ex) {
			System.out.println(" error in reading file.");
			ex.printStackTrace();
		}
		return data;
	}

	public static void writeFile(StringBuilder input, String fileName) throws IOException {// write in output file
																							// method
		System.out.println(input);
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));// buffer writting
		writer.write(new String(input));
		writer.close();
	}

}
