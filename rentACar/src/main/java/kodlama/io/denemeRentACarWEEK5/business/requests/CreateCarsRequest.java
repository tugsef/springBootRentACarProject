package kodlama.io.denemeRentACarWEEK5.business.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarsRequest {
	
	private String dailyPrice;
	private int modelYear;
	private String plate;
	private int statu;
	
	@NotNull
	private int modelId;
	
	
}
