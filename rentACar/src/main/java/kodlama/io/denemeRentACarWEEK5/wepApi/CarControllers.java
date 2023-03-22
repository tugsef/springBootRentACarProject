package kodlama.io.denemeRentACarWEEK5.wepApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.denemeRentACarWEEK5.business.abstracts.CarService;
import kodlama.io.denemeRentACarWEEK5.business.requests.CreateCarsRequest;
import kodlama.io.denemeRentACarWEEK5.business.requests.UpdateCarRequest;
import kodlama.io.denemeRentACarWEEK5.business.responses.GetAllCarsResponse;
import kodlama.io.denemeRentACarWEEK5.business.responses.GetByIdCarResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarControllers {
	
	private CarService carService;
	
	@GetMapping
	public List<GetAllCarsResponse> getAll(){
		return this.carService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdCarResponse getById(@PathVariable int id) {
		return this.carService.getById(id);
	}
	
	
	@PostMapping
	public void add(@RequestBody @Valid CreateCarsRequest carsRequest) {
		this.carService.add(carsRequest);
	}
	
	@PutMapping
	public void update(@RequestBody UpdateCarRequest updateCarRequest) {
		this.carService.update(updateCarRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.carService.deleteById(id);
	}
	

}
