package kodlama.io.denemeRentACarWEEK5.business.abstracts;

import java.util.List;

import kodlama.io.denemeRentACarWEEK5.business.requests.CreateBrandsRequests;
import kodlama.io.denemeRentACarWEEK5.business.requests.UpdateBrandsRequests;
import kodlama.io.denemeRentACarWEEK5.business.responses.GetAllBrandsResponse;
import kodlama.io.denemeRentACarWEEK5.business.responses.GetByIdBrandResponse;

public interface BrandService {

	List<GetAllBrandsResponse> getAll();
	GetByIdBrandResponse getById(int id);
	void add(CreateBrandsRequests createBrandsRequests); 
	void deleteById(int id);
	void update(UpdateBrandsRequests updateBrandsRequests);
	
	
	
}
