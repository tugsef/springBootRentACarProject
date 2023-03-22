package kodlama.io.denemeRentACarWEEK5.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.denemeRentACarWEEK5.core.utilies.exception.BusinessException;
import kodlama.io.denemeRentACarWEEK5.dataAccess.absracts.BrandsRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class BrandBusinessRules {
	private BrandsRepository brandsRepository ;
	
	public void checkIfBrandNameExists(String name) {
		if(this.brandsRepository.existsByName(name))
			throw new BusinessException("Brand name already exists");
		
	}
}
