package kodlama.io.denemeRentACarWEEK5.business.conceretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.denemeRentACarWEEK5.business.abstracts.CarService;
import kodlama.io.denemeRentACarWEEK5.business.requests.CreateCarsRequest;
import kodlama.io.denemeRentACarWEEK5.business.requests.UpdateCarRequest;
import kodlama.io.denemeRentACarWEEK5.business.responses.GetAllCarsResponse;
import kodlama.io.denemeRentACarWEEK5.business.responses.GetByIdCarResponse;
import kodlama.io.denemeRentACarWEEK5.business.rules.CarRepository;
import kodlama.io.denemeRentACarWEEK5.core.utilies.mapper.ModelMapparService;
import kodlama.io.denemeRentACarWEEK5.entity.Car;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class CarManager implements CarService{
	
	private CarRepository carRepository;
	private ModelMapparService modelMapparService;
	
	
	@Override
	public List<GetAllCarsResponse> getAll() {
		List<Car> cars = this.carRepository.findAll();
		List<GetAllCarsResponse> getAllCarsResponses = cars.stream().map(car -> this.modelMapparService
				.forReponse().map(car, GetAllCarsResponse.class)).collect(Collectors.toList());
		return getAllCarsResponses;
	}

	@Override
	public GetByIdCarResponse getById(int id) {
		Car car = this.carRepository.findById(id).orElseThrow();
		GetByIdCarResponse getByIdCarResponse = this.modelMapparService.forReponse().map(car, GetByIdCarResponse.class);
		return getByIdCarResponse;
	}

	@Override
	public void add(CreateCarsRequest createCarsRequest) {
		Car car = this.modelMapparService.forRequest().map(createCarsRequest, Car.class);
		this.carRepository.save(car);
		
	}

	@Override
	public void deleteById(int id) {
		this.carRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateCarRequest updateCarRequest) {
		Car car = this.modelMapparService.forRequest().map(updateCarRequest, Car.class);
		this.carRepository.save(car);
		
	}
	
}
