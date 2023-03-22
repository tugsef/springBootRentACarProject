package kodlama.io.denemeRentACarWEEK5.wepApi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.denemeRentACarWEEK5.business.abstracts.ModelService;
import kodlama.io.denemeRentACarWEEK5.business.requests.CreateModelsRequest;
import kodlama.io.denemeRentACarWEEK5.business.requests.UpdateModelRequest;
import kodlama.io.denemeRentACarWEEK5.business.responses.GetAllModelResponse;
import kodlama.io.denemeRentACarWEEK5.business.responses.GetByIdModelReponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelControllers {

	private ModelService modelService;
	
	@GetMapping
	public List<GetAllModelResponse> getAll() {
		return this.modelService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdModelReponse getById(@PathVariable int id) {
		return this.modelService.getById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateModelsRequest createModelsRequest) {
		this.modelService.add(createModelsRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.modelService.delete(id);
	}

	
	@PutMapping
	public void update(@RequestBody @Valid UpdateModelRequest updateModelRequest) {
		this.modelService.update(updateModelRequest);
	}
	
	
}
