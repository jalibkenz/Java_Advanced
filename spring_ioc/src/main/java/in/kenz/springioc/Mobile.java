package in.kenz.springioc;

public class Mobile {

	//Airtel airtel = new Airtel();
	Airtel airtel;

	void activate() {
		
		airtel.use();
		System.out.println("Mobile Activated.");
	}

	public Airtel getAirtel() {
		return airtel;
	}

	public void setAirtel(Airtel airtel) { //not utilized
		this.airtel = airtel;
	}
	
	
}
