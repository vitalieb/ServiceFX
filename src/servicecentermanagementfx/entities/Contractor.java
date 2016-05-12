package servicecentermanagementfx.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Contractor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean isCompany;
    private String phoneNumber;
    private String address;

    public Contractor() {
    }

    public Contractor(Integer id, Boolean isCompany, String phoneNumber, String address) {
        this.id = id;
        this.isCompany = isCompany;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
        public Contractor(Boolean isCompany, String phoneNumber, String address) {
        this.isCompany = isCompany;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Boolean getIsCompany() {
        return isCompany;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIsCompany(Boolean isCompany) {
        this.isCompany = isCompany;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    

}
