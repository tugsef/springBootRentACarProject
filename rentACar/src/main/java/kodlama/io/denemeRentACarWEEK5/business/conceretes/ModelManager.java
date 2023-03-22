package kodlama.io.denemeRentACarWEEK5.business.conceretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.denemeRentACarWEEK5.business.abstracts.ModelService;
import kodlama.io.denemeRentACarWEEK5.business.requests.CreateModelsRequest;
import kodlama.io.denemeRentACarWEEK5.business.requests.UpdateModelRequest;
import kodlama.io.denemeRentACarWEEK5.business.responses.GetAllModelResponse;
import kodlama.io.denemeRentACarWEEK5.business.responses.GetByIdModelReponse;
import kodlama.io.denemeRentACarWEEK5.business.rules.ModelBusinessRules;
import kodlama.io.denemeRentACarWEEK5.core.utilies.mapper.ModelMapparService;
import kodlama.io.denemeRentACarWEEK5.dataAccess.absracts.ModelRepository;
import kodlama.io.denemeRentACarWEEK5.entity.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class ModelManager implements ModelService{

	private ModelRepository modelRepository;
	private ModelMapparService modelMapparService;
	private ModelBusinessRules modelBusinessRules;

	@Override
	public List<GetAllModelResponse> getAll() {
		List<Model> models = this.modelRepository.findAll();
		List<GetAllModelResponse> getAllModelResponses = models.stream()
				.map(model -> this.modelMapparService.forReponse()
						.map(model, GetAllModelResponse.class)).collect(Collectors.toList());
		return getAllModelResponses;
	}

	@Override
	public GetByIdModelReponse getById(int id) {
		Model model = this.modelRepository.findById(id).orElseThrow();
		GetByIdModelReponse getByIdModelReponse = this.modelMapparService.forRequest().map(model, GetByIdModelReponse.class);
		return getByIdModelReponse;
	}

	@Override
	public void add(CreateModelsRequest createModelsRequest) {
		this.modelBusinessRules.checkIfModelNameExists(createModelsRequest.getName());
		Model model = this.modelMapparService.forRequest().map(createModelsRequest, Model.class);
		this.modelRepository.save(model);
		
	}

	@Override
	public void update(UpdateModelRequest updateModelRequest) {
		Model model = this.modelMapparService.forRequest().map(updateModelRequest, Model.class);
		this.modelRepository.save(model);
	}

	@Override
	public void delete(int id) {
		this.modelRepository.deleteById(id);
		
	}
}
