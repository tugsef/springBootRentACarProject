package kodlama.io.denemeRentACarWEEK5.business.conceretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.denemeRentACarWEEK5.business.abstracts.BrandService;
import kodlama.io.denemeRentACarWEEK5.business.requests.CreateBrandsRequests;
import kodlama.io.denemeRentACarWEEK5.business.requests.UpdateBrandsRequests;
import kodlama.io.denemeRentACarWEEK5.business.responses.GetAllBrandsResponse;
import kodlama.io.denemeRentACarWEEK5.business.responses.GetByIdBrandResponse;
import kodlama.io.denemeRentACarWEEK5.business.rules.BrandBusinessRules;
import kodlama.io.denemeRentACarWEEK5.core.utilies.mapper.ModelMapparService;
import kodlama.io.denemeRentACarWEEK5.dataAccess.absracts.BrandsRepository;
import kodlama.io.denemeRentACarWEEK5.entity.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

	private BrandsRepository brandsRepository;
	private ModelMapparService modelMapparService;
	private BrandBusinessRules brandBusinessRules;


	@Override
	public List<GetAllBrandsResponse> getAll() {
		List<Brand> brands = brandsRepository.findAll();
		List<GetAllBrandsResponse> getAllBrandsResponses = 
				brands.stream().map(brand -> this.modelMapparService
											     .forReponse().map(brand, GetAllBrandsResponse.class))
				.collect(Collectors.toList());
		
		return getAllBrandsResponses;
	}

	@Override
	public void add(CreateBrandsRequests createBrandsRequests) {
	 this.brandBusinessRules.checkIfBrandNameExists(createBrandsRequests.getName());
		Brand brand = this.modelMapparService.forRequest().map(createBrandsRequests, Brand.class);
		brandsRepository.save(brand);
		}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand =this.brandsRepository.findById(id).orElseThrow();
		GetByIdBrandResponse getByIdBrandsResponse = this.modelMapparService.forReponse().map(brand, GetByIdBrandResponse.class);
		return getByIdBrandsResponse;
	}

	@Override
	public void deleteById(int id) {
		 this.brandsRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateBrandsRequests updateBrandsRequests) {
		Brand brand = this.modelMapparService.forRequest().map(updateBrandsRequests, Brand.class);
		this.brandsRepository.save(brand);
		
	}
	
	
	
	
	
}
