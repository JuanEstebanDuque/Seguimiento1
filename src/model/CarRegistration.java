package model;

public class CarRegistration {
	//attributes
	private String carPlate;
	private String carId;
	
	//relations
	
	//methods
	public CarRegistration(String carPlate, String id) {
		this.carPlate = carPlate;
		this.carId = id;
	}

	public String getCarPlate() {
		return carPlate;
	}

	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}
	
	
}
