package kodlama.io.denemeRentACarWEEK5.business.rules;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.denemeRentACarWEEK5.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
