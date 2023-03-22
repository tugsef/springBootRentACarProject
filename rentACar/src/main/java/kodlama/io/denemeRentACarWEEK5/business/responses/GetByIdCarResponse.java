package kodlama.io.denemeRentACarWEEK5.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetByIdCarResponse {
	private String dailyPrice;
	private int modelYear;
	private int modelName;
}
