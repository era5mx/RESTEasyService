package mx.com.extend.semarnat.foresta.util;

public class UnableToSaveException extends Exception {

	/**
	 * Constante de Serializacion
	 */
	private static final long serialVersionUID = 1L;

	public UnableToSaveException() {
		super();
	}

	public UnableToSaveException(Exception e) {
		super(e.getMessage(), e.getCause());
	}

	public UnableToSaveException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnableToSaveException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnableToSaveException(String message) {
		super(message);
	}

	public UnableToSaveException(Throwable cause) {
		super(cause);
	}

}
