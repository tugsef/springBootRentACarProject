package kodlama.io.denemeRentACarWEEK5.wepApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import kodlama.io.denemeRentACarWEEK5.business.abstracts.BrandService;
import kodlama.io.denemeRentACarWEEK5.business.requests.CreateBrandsRequests;
import kodlama.io.denemeRentACarWEEK5.business.requests.UpdateBrandsRequests;
import kodlama.io.denemeRentACarWEEK5.business.responses.GetAllBrandsResponse;
import kodlama.io.denemeRentACarWEEK5.business.responses.GetByIdBrandResponse;


@RestController
@RequestMapping("/api/brands")
public class BrandContollers {

	private BrandService brandService;
	
	@Autowired
	public BrandContollers(BrandService brandService) {
		this.brandService =brandService;
	}
	
	@GetMapping
	public List<GetAllBrandsResponse> getAll(){
		
		return brandService.getAll();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(CreateBrandsRequests createBrandsRequests) {
		this.brandService.add(createBrandsRequests);
	}
	
	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id) {
	return	this.brandService.getById(id);
	}
	
	@PutMapping
	public void update(@RequestBody UpdateBrandsRequests updateBrandsRequests) {
		this.brandService.update(updateBrandsRequests);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.brandService.deleteById(id);
	}
}
