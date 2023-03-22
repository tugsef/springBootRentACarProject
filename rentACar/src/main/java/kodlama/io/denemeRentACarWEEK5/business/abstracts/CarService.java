package kodlama.io.denemeRentACarWEEK5.business.abstracts;

import java.util.List;

import kodlama.io.denemeRentACarWEEK5.business.requests.CreateCarsRequest;
import kodlama.io.denemeRentACarWEEK5.business.requests.UpdateCarRequest;
import kodlama.io.denemeRentACarWEEK5.business.responses.GetAllCarsResponse;
import kodlama.io.denemeRentACarWEEK5.business.responses.GetByIdCarResponse;

public interface CarService {
	List<GetAllCarsResponse> getAll();
	GetByIdCarResponse getById(int id);
	void update(UpdateCarRequest updateCarRequest);
	void add(CreateCarsRequest createCarsRequest);
	void deleteById(int id);
}

