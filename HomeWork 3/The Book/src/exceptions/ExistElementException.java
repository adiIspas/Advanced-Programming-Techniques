package exceptions;

public class ExistElementException extends Throwable{
	
	private static final long serialVersionUID = 1L;
	String error;
	
	public ExistElementException(){}
	
	public ExistElementException(String error){
		this.error = error;
	}

}
