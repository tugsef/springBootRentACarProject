package kodlama.io.denemeRentACarWEEK5.core.utilies.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor


public class ModelMapperManager implements ModelMapparService {
	
	private ModelMapper modelMapper;

	@Override
	public ModelMapper forReponse() {
		this.modelMapper
			.getConfiguration().setAmbiguityIgnored(true)
			.setMatchingStrategy(MatchingStrategies.LOOSE);
		return this.modelMapper;
	}

	@Override
	public ModelMapper forRequest() {
		this.modelMapper
			.getConfiguration()
			.setAmbiguityIgnored(true)
			.setMatchingStrategy(MatchingStrategies.STANDARD);
		return this.modelMapper;
	}

}
