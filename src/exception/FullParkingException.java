package exception;

public class FullParkingException extends Exception{
	public FullParkingException() {
		super("The parking lot is full.");
	}
}
