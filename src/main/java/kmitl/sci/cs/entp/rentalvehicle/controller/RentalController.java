package kmitl.sci.cs.entp.rentalvehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kmitl.sci.cs.entp.rentalvehicle.service.RentalService;
import kmitl.sci.cs.entp.rentalvehicle.model.Vehicle;

@RestController
@RequestMapping("/v1")
public class RentalController {
    @Autowired
    private RentalService service;

    @GetMapping("/vehicle")
    public List<Vehicle> getVehicles() {
        return service.getVehicles();
    }

    @PostMapping("/addVehicle")
    public void create(@RequestBody Vehicle vehicle) {
        service.create(vehicle);
    }

    @PostMapping("/{vehicleId}/users/{userId}")
    public void associate(@PathVariable(name = "vehicleId") long vehicleId,
            @PathVariable(name = "userId") long userId) {
        service.associate(vehicleId, userId);
    }

    @DeleteMapping("/{vehicleId}/users/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long vehicleId) {
        Vehicle vehicle = service.getVehicle(vehicleId);
		if (vehicle != null) {
            service.unAssociate(vehicleId);
        }
    }

}
