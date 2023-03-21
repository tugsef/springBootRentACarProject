package kodlama.io.denemeRentACarWEEK5.dataAccess.absracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.denemeRentACarWEEK5.entity.Brand;

public interface BrandsRepository extends JpaRepository<Brand, Integer> {

}
