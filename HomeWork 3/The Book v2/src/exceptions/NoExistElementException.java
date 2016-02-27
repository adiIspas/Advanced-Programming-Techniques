package exceptions;

public class NoExistElementException extends Throwable{
	
	private static final long serialVersionUID = 1L;
	String error;
	
	public NoExistElementException(){}
	
	public NoExistElementException(String error){
		this.error = error;
	}
}
