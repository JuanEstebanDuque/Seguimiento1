package ui;
import java.util.Scanner;
import exception.FullParkingException;
import exception.HourParkingIncorrectPlate;
import exception.ParkingDayIncorrectID;
import model.Parking;


public class Main {
	public static Scanner lector = new Scanner(System.in);
	public static Parking park;

	public static void main(String[] args) {
		park = new Parking();
		boolean continuing = true;
		while (continuing) {
			System.out.println("Choose the option that you prefer:\n" +
			"1. Check the car plate.\n" +
			"2. Check the bike plate.\n" +
			"9. Exit.\n"
			);
			int option = Integer.parseInt(lector.nextLine());
			switch (option) {
			case 1: checkCarPlate();
				break;
			case 2: checkBikePlate();
				break;
			case 9: System.out.println("Program successfully completed.");
					continuing = false;
					break;
			default: System.out.println("The selected option is incorrect.");
				break;
			}
		}
		
	}
	public static void checkCarPlate() {
		System.out.println("Write the plate according to the following ABC123:");
		String carPlate = lector.nextLine();
		//lector.nextLine();
		System.out.println("Enter the ID number with 10 characters. Only numbers.");
		String carID = lector.nextLine();
		//lector.nextLine();
		try {
			park.checkAddCar(carPlate, carID);
			park.addCar(carPlate, carID);
		} catch (FullParkingException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ParkingDayIncorrectID e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (HourParkingIncorrectPlate e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void checkBikePlate() {
		System.out.println("Write the plate according to the following ABC12D:");
		String bikePlate = lector.nextLine();
		//lector.nextLine();
		System.out.println("Enter the ID number with 10 characters. Only numbers.");
		String bikeID = lector.nextLine();
		//lector.nextLine();
		try {
			park.checkAddBike(bikePlate, bikeID);
			park.addBike(bikePlate, bikeID);
		} catch (FullParkingException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ParkingDayIncorrectID e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (HourParkingIncorrectPlate e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
