package exception;

@SuppressWarnings("serial")
public class LocalBusyException extends RuntimeException{
	public LocalBusyException(String msg){
		super(msg);
	}

}
