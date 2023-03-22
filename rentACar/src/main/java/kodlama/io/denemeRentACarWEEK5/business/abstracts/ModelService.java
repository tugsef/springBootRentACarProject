package kodlama.io.denemeRentACarWEEK5.business.abstracts;

import java.util.List;

import kodlama.io.denemeRentACarWEEK5.business.requests.CreateModelsRequest;
import kodlama.io.denemeRentACarWEEK5.business.requests.UpdateModelRequest;
import kodlama.io.denemeRentACarWEEK5.business.responses.GetAllModelResponse;
import kodlama.io.denemeRentACarWEEK5.business.responses.GetByIdModelReponse;

public interface ModelService {

	List<GetAllModelResponse> getAll();
	GetByIdModelReponse getById(int id);
	void add(CreateModelsRequest createModelsRequest);
	void update(UpdateModelRequest updateModelRequest);
	void delete(int id);
	
}
