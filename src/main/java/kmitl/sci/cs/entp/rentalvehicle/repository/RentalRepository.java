package kmitl.sci.cs.entp.rentalvehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kmitl.sci.cs.entp.rentalvehicle.model.Vehicle;

@Repository
public interface RentalRepository extends JpaRepository<Vehicle, Long>{

    Vehicle findByVehicleId(long id);
    void deleteByVehicleId(long id);
}
