package exception;

public class ParkingDayIncorrectID extends Exception{
	public ParkingDayIncorrectID () {
		super("You cannot enter the parking lot because it is your pico y cédula day.");
	}
}
