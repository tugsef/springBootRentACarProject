package kodlama.io.denemeRentACarWEEK5;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DenemeRentACarWeek5Application {

	public static void main(String[] args) {
		SpringApplication.run(DenemeRentACarWeek5Application.class, args);
	}
@Bean
public ModelMapper getModelMapper() {
	return new ModelMapper();
}
}
