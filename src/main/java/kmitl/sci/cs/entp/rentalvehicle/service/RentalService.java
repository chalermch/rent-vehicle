package kmitl.sci.cs.entp.rentalvehicle.service;

import java.util.List;

import kmitl.sci.cs.entp.rentalvehicle.model.Vehicle;

public interface RentalService {
    public List<Vehicle> getVehicles();
    public Vehicle getVehicle(long vehicleId);
    public void create(Vehicle vehicle);
    public void delete(long vehicleId);
    public void associate(long vehicleId, long ownerId);
    public void unAssociate(long vehicleId);

}
