package br.com.bara.sistema_os.infraestrutura.base;

public class BaseException extends RuntimeException{
	
	private static final long serialVersionUID = 3993713222178435623L;
	
	public BaseException(String message) {
		super(message);
		setStackTrace(new StackTraceElement[] {});
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

}
