package kmitl.sci.cs.entp.rentalvehicle.model;

public class PatchVehicleRequest {

    private String status;
    private String owner;


    public PatchVehicleRequest() {
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
