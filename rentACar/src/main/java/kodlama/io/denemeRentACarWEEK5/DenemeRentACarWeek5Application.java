package kodlama.io.denemeRentACarWEEK5;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kodlama.io.denemeRentACarWEEK5.core.utilies.exception.BusinessException;
import kodlama.io.denemeRentACarWEEK5.core.utilies.exception.ProblemDetails;
import kodlama.io.denemeRentACarWEEK5.core.utilies.exception.ValidationProblemDetails;

@SpringBootApplication
@RestControllerAdvice
public class DenemeRentACarWeek5Application {

	public static void main(String[] args) {
		SpringApplication.run(DenemeRentACarWeek5Application.class, args);
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handlerBusiness(BusinessException businessException) {
		ProblemDetails problemdetails = new ProblemDetails();
		problemdetails.setMessage(businessException.getMessage());
		return problemdetails;
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ValidationProblemDetails handleValidationException(
			MethodArgumentNotValidException methodArgumentNotValidException) {
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setMessage("Validation.Exeption");
		validationProblemDetails.setValidationErrors(new HashMap<String, String>());
		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return validationProblemDetails;
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
