package servicecentermanagementfx.datamodels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public final class ContractorsViewModel {

    public ContractorsViewModel(Integer id, String name, String surname, String shortName, String fiscalCode, String vat, String phoneNumber) {
        setId(id);
        setName(name);
        setSurname(surname);
        setShortName(shortName);
        setFiscalCode(fiscalCode);
        setVat(vat);
        setPhoneNumber(phoneNumber);
    }

    public ContractorsViewModel(Integer id, String shortName, String fiscalCode, String vat, String phoneNumber) {
        setId(id);
        setShortName(shortName);
        setFiscalCode(fiscalCode);
        setVat(vat);
        setPhoneNumber(phoneNumber);
    }

    public ContractorsViewModel(Integer id, String name, String surname, String phoneNumber) {
        setId(id);
        setName(name);
        setSurname(surname);
        setPhoneNumber(phoneNumber);
    }

    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty surname = new SimpleStringProperty();
    private final StringProperty shortName = new SimpleStringProperty();
    private final StringProperty fiscalCode = new SimpleStringProperty();
    private final StringProperty vat = new SimpleStringProperty();
    private final StringProperty phoneNumber = new SimpleStringProperty();
    private final IntegerProperty id = new SimpleIntegerProperty();

    public int getId() {
        return id.get();
    }

    public int getIdValue() {
        return id.getValue();
    }

    public void setId(int value) {
        id.set(value);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String value) {
        phoneNumber.set(value);
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public String getVat() {
        return vat.get();
    }

    public void setVat(String value) {
        vat.set(value);
    }

    public StringProperty vatProperty() {
        return vat;
    }

    public String getFiscalCode() {
        return fiscalCode.get();
    }

    public void setFiscalCode(String value) {
        fiscalCode.set(value);
    }

    public StringProperty fiscalCodeProperty() {
        return fiscalCode;
    }

    public String getShortName() {
        return shortName.get();
    }

    public void setShortName(String value) {
        shortName.set(value);
    }

    public StringProperty shortNameProperty() {
        return shortName;
    }

    public String getSurname() {
        return surname.get();
    }

    public void setSurname(String value) {
        surname.set(value);
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }

    public StringProperty nameProperty() {
        return name;
    }

    @Override
    public String toString() {
        return "ContractorsViewModel{" + "name=" + name + ", surname=" + surname + ", shortName=" + shortName + ", fiscalCode=" + fiscalCode + ", vat=" + vat + ", phoneNumber=" + phoneNumber + ", id=" + id + '}';
    }

}
