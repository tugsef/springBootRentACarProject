package kodlama.io.denemeRentACarWEEK5.core.utilies.exception;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationProblemDetails extends ProblemDetails {
	private Map<String, String> validationErrors;
	
	
	
}
