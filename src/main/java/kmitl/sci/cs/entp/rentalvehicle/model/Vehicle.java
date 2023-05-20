package kmitl.sci.cs.entp.rentalvehicle.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonInclude(Include.NON_NULL)
public class Vehicle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long vehicleId;
    @Column(length = 40)
    private String status;
    @Column(length = 40)
    private String owner;

	@JsonIgnore
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
    private Date associationDate;


    public Vehicle() {
        super();
        this.status = "AVAILABLE";
        this.owner = null;
        this.associationDate = null;
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

    public void setOwner(long ownerId) {
        this.owner = Long.toString(ownerId);
    }

    public void resetOwner(){
        this.owner = null;
    }

    public Date getAssociationDate() {
        return this.associationDate;
    }

    public void setAssociationDate(Date associationDate) {
        this.associationDate = associationDate;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }
    
}
