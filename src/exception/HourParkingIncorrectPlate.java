package exception;

public class HourParkingIncorrectPlate extends Exception{
	public HourParkingIncorrectPlate(int hour) {
		super("The entry time is incorrect, you must enter another time. Your login time is " + hour);
	}
}
