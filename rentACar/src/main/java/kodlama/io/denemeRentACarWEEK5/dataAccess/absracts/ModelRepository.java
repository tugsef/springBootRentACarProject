package kodlama.io.denemeRentACarWEEK5.dataAccess.absracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.denemeRentACarWEEK5.entity.Model;

public interface ModelRepository extends JpaRepository<Model , Integer>{
	boolean existsByName(String name);
}
