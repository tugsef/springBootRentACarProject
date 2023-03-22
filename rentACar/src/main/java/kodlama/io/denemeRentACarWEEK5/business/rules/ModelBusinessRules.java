package kodlama.io.denemeRentACarWEEK5.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.denemeRentACarWEEK5.core.utilies.exception.BusinessException;
import kodlama.io.denemeRentACarWEEK5.dataAccess.absracts.ModelRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelBusinessRules {
	private ModelRepository modelRepository;
	
	public void checkIfModelNameExists(String name) {
		if(this.modelRepository.existsByName(name))
			throw new BusinessException("Model name already exists.");
	}
}
