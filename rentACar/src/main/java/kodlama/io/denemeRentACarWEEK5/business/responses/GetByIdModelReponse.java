package kodlama.io.denemeRentACarWEEK5.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetByIdModelReponse {

	private int id;
	private String name;
	private String brandName;
}
