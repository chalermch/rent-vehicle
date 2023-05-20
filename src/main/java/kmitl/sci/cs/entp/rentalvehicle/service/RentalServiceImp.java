package kmitl.sci.cs.entp.rentalvehicle.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kmitl.sci.cs.entp.rentalvehicle.model.Vehicle;
import kmitl.sci.cs.entp.rentalvehicle.repository.RentalRepository;

@Service
@Transactional
public class RentalServiceImp implements RentalService {

    @Autowired
    private RentalRepository repo;

    @Override
    public List<Vehicle> getVehicles() {
        return repo.findAll();
    }

    @Override
    public Vehicle getVehicle(long vehicleId) {
       return repo.findByVehicleId(vehicleId);
    }

    @Override
    public void create(Vehicle vehicle) {
        repo.save(vehicle);
    }

    @Override
    public void delete(long vehicleId) {
        repo.deleteByVehicleId(vehicleId);
    }

    @Override
    public void associate(long vehicleId, long ownerId) {
        Vehicle vehicle = repo.findByVehicleId(vehicleId);
        vehicle.setOwner(ownerId);
        vehicle.setStatus("ASSOCIATED");
        vehicle.setAssociationDate(new Date());
        repo.save(vehicle);
    }


    @Override
    public void unAssociate(long vehicleId) {
        Vehicle vehicle = repo.findByVehicleId(vehicleId);
        vehicle.resetOwner();
        vehicle.setStatus("AVAILABLE");
        vehicle.setAssociationDate(null);
        repo.save(vehicle);
    }

    
}
