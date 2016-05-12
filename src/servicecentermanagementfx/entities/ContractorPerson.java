package servicecentermanagementfx.entities;

import javax.persistence.Entity;

@Entity
public class ContractorPerson extends Contractor {

    private String name;
    private String surname;

    public ContractorPerson(String name, String surname, Integer id, Boolean isCompany, String phoneNumber, String address) {
        super(id, isCompany, phoneNumber, address);
        this.name = name;
        this.surname = surname;
    }

    public ContractorPerson(String name, String surname, Boolean isCompany, String phoneNumber, String address) {
        super(isCompany, phoneNumber, address);
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "ContractorPerson{" + "name=" + name + ", surname=" + surname + ", address = " + super.getAddress() + ", phone = " + super.getPhoneNumber() + '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
