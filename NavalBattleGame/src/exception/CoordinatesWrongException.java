package exception;

@SuppressWarnings("serial")
public class CoordinatesWrongException extends RuntimeException{
	public CoordinatesWrongException(String msg){
		super(msg);
	}
}
