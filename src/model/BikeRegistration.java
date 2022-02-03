package model;

public class BikeRegistration {
	//attributes
	private String bikePlate;
	private String motorcycleId;
	
	//relations
	
	//methods
	public BikeRegistration(String bikePlate, String motorcycleId) {
		super();
		this.bikePlate = bikePlate;
		this.motorcycleId = motorcycleId;
	}

	public String getBikePlate() {
		return bikePlate;
	}

	public void setBikePlate(String bikePlate) {
		this.bikePlate = bikePlate;
	}

	public String getMotorcycleId() {
		return motorcycleId;
	}

	public void setMotorcycleId(String motorcycleId) {
		this.motorcycleId = motorcycleId;
	}
	
	
}