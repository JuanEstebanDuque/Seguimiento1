package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import exception.FullParkingException;
import exception.HourParkingIncorrectPlate;
import exception.ParkingDayIncorrectID;

public class Parking {
	//attributes
	public static final int CARQUOTALIMIT = 100;
	public static final int BIKEQUOTALIMIT = 200;
	
	//relations
	private CarRegistration[] carQuota;
	private BikeRegistration[] bikeQuota;
	
	//methods
	public Parking() {
		carQuota = new CarRegistration[CARQUOTALIMIT];
		bikeQuota = new BikeRegistration[BIKEQUOTALIMIT];
	}
	
	public String Hour(int option) {
		SimpleDateFormat sdf = new SimpleDateFormat("E:HH:mm:ss");
		Date d = new Date();
		String hour = sdf.format(d);
		String[] partsHour = hour.split(":");
		if(option == 0) {
			return partsHour[1];
		} else {
			return partsHour[0];
		}
		
	}
	
	public void addCar(String carPlate, String carID)  throws FullParkingException{
		int freeSpaceCar = spaceCarPark();
		if(freeSpaceCar != -1) {
			carQuota[freeSpaceCar]=new CarRegistration(carPlate, carID);
			System.out.println("Car added correctly.");
		} else {
			throw new FullParkingException();
		}
	}
	
	public void addBike(String bikePlate, String bikeID) throws FullParkingException{
		int freeSpaceBike = spaceBikePark();
		if (freeSpaceBike != -1) {
			bikeQuota[freeSpaceBike] = new BikeRegistration(bikePlate, bikeID);
			System.out.println("Bike added correctly.");
		} else {
			throw new FullParkingException();
		}

	}
	
	public int spaceCarPark() {
		int spaceCarRegistration = -1;
		boolean exit = false;
		for (int i=0;i<carQuota.length && exit == false;i++) {
			if (carQuota[i]==null) {
				spaceCarRegistration = i;
				exit = true;
			} 
		}
		return spaceCarRegistration;
	}
	
	public int spaceBikePark() {
		int spaceBikeRegistration = -1;
		boolean exit = false;
		for (int i=0;i<bikeQuota.length && exit == false;i++) {
			if (carQuota[i] == null) {
				spaceBikeRegistration = i;
				exit = true;
			}
		}
		return spaceBikeRegistration;
	}
	
	public String checkDay (char lastLetterID,String day) throws ParkingDayIncorrectID{
		String message = "";
		if(lastLetterID == '0' || lastLetterID == '1') {
			if(day.equalsIgnoreCase("lun")) {
				throw new ParkingDayIncorrectID();
			} else {
				message = "You can enter the parking lot";
			}
		} else if (lastLetterID == '2' || lastLetterID == '3') {
			if(day.equalsIgnoreCase("mar")) {
				throw new ParkingDayIncorrectID();
			} else {
				message = "You can enter the parking lot";
			}
		} else if (lastLetterID == '4' || lastLetterID == '5') {
			if(day.equalsIgnoreCase("mié")) {
				throw new ParkingDayIncorrectID();				
			} else {
				message = "You can enter the parking lot";
			}
		} else if (lastLetterID == '6' || lastLetterID == '7') {
			if(day.equalsIgnoreCase("jue")) {
				throw new ParkingDayIncorrectID();		
			} else {
				message = "You can enter the parking lot";		
			}
		} else if (lastLetterID == '8' || lastLetterID == '9') {
			if(day.equalsIgnoreCase("vie")) {
				throw new ParkingDayIncorrectID();	
			} else {
				message = "You can enter the parking lot";			
			}
		}
		return message;
	}
	
	public void checkAddCar(String carPlate,String carID) throws ParkingDayIncorrectID, HourParkingIncorrectPlate {
		char firstLetterCar = carPlate.charAt(0);
		if ((firstLetterCar >= 'a' && firstLetterCar <= 'm') || (firstLetterCar >= 'A' && firstLetterCar <= 'M')) {
			String hour = Hour(0);
			int hourCheck = Integer.parseInt(hour);
			if(hourCheck > 7 && hourCheck < 14) {
				String day = Hour(1);
				char lastLetterID = carID.charAt(carID.length()-1);
				String messagePark = checkDay(lastLetterID, day);
				System.out.println(messagePark);
			} else {
				throw new HourParkingIncorrectPlate(hourCheck);
			}
		} else if ((firstLetterCar >= 'n' && firstLetterCar <= 'z') || (firstLetterCar >= 'N' && firstLetterCar <= 'Z')) {
			String hour = Hour(0);
			int hourCheck = Integer.parseInt(hour);
			if(hourCheck > 14 && hourCheck < 22) {
				String day = Hour(1);
				char lastLetterID = carID.charAt(carID.length()-1);
				String messagePark = checkDay(lastLetterID, day);
				System.out.println(messagePark);
			} else {
				throw new HourParkingIncorrectPlate(hourCheck);
			}
		}
	}
	
	public void checkAddBike(String bikePlate,String bikeID) throws ParkingDayIncorrectID, HourParkingIncorrectPlate {
		char firstNumberBike = bikePlate.charAt(3);
		if(firstNumberBike >= '0' && firstNumberBike <= '4') {
			String hour = Hour(0);
			int hourCheck = Integer.parseInt(hour);
			if(hourCheck > 7 && hourCheck < 14) {
				String day = Hour(1);
				char lastLetterID = bikeID.charAt(bikeID.length()-1);
				String messagePark = checkDay(lastLetterID, day);
				System.out.println(messagePark);
			} else {
				throw new HourParkingIncorrectPlate(hourCheck);
			}
		} else if(firstNumberBike >= '5' && firstNumberBike <= '9') {
			String hour = Hour(0);
			int hourCheck = Integer.parseInt(hour);
			if(hourCheck > 14 && hourCheck < 22) {
				String day = Hour(1);
				char lastLetterID = bikeID.charAt(bikeID.length()-1);
				String messagePark = checkDay(lastLetterID, day);
				System.out.println(messagePark);
			} else {
				throw new HourParkingIncorrectPlate(hourCheck);
			}
		}
	}
}
