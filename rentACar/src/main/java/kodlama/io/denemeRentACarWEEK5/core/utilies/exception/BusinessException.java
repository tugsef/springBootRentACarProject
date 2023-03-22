package kodlama.io.denemeRentACarWEEK5.core.utilies.exception;

import lombok.NoArgsConstructor;


@NoArgsConstructor

public class BusinessException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3715018079058310566L;
	
	public BusinessException(String message) {
		super(message);
	}
}
