package project;

import java.util.GregorianCalendar;

public class Owner {
//owner class 
	// owner data members
	private String Name;
	private String RegisterionNo;
	private String Address;
	private String Tel;
	private GregorianCalendar DateOfRegistration;
	private boolean call;

	Owner() {// default constructor
	}
	// constructor (name)

	Owner(String Name) {
		this.Name = Name;

	}

	// another constructor foe owner
	Owner(String Name, String RegisterionNo, String Address, String Tel, GregorianCalendar DateOfRegistration) {

		this.Name = Name;
		this.RegisterionNo = RegisterionNo;
		this.Address = Address;
		this.Tel = Tel;
		this.DateOfRegistration = DateOfRegistration;
	}

	public String getName() {// getName method
		return Name;
	}

	public String getRegisterionNo() {// get Registerion Number method
		return RegisterionNo;
	}

	public String getAddress() {// get address method
		return Address;
	}

	public String getTel() { // get tel method
		return Tel;
	}

	public GregorianCalendar getDateOfRegistration() { // get Date Of Registration method
		return DateOfRegistration;
	}

	public void setName(String Name) { // set name method
		this.Name = Name;
	}

	public void setRegisterionNo(String RegisterionNo) { // set Registerion No method
		this.RegisterionNo = RegisterionNo;
	}

	public void setAddress(String Address) { // set Address method
		this.Address = Address;
	}

	public void setTel(String Tel) { // set Tel method
		this.Tel = Tel;
	}

	public void setDateOfRegistration(GregorianCalendar DateOfRegistration) { // set Date Of Registration method
		this.DateOfRegistration = DateOfRegistration;
	}

	public void callowner() {// additional method
		this.call = true;
		System.out.println("waiting reply");
	}

	public String toString() { // to string method
		return (" Name:" + Name + " RegisterionNo:" + RegisterionNo + " Address:" + Address + " Tel:" + Tel
				+ " DateOfRegistration:" + DateOfRegistration);
	}

}