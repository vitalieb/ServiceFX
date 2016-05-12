package servicecentermanagementfx.entities;

import javax.persistence.Entity;

@Entity
public class ContractorCompany extends Contractor {

    private String shortName;
    private String fullName;
    private String fiscalCode;
    private String VAT;
    private String bankName;
    private String bankAccount;

    public ContractorCompany(String shortName, String fullName, String fiscalCode, String VAT, String bankName, String bankAccount, Integer id, Boolean isCompany, String phoneNumber, String address) {
        super(id, isCompany, phoneNumber, address);
        this.shortName = shortName;
        this.fullName = fullName;
        this.fiscalCode = fiscalCode;
        this.VAT = VAT;
        this.bankName = bankName;
        this.bankAccount = bankAccount;
    }

    public ContractorCompany(String shortName, String fullName, String fiscalCode, String VAT, String bankName, String bankAccount, Boolean isCompany, String phoneNumber, String address) {
        super(isCompany, phoneNumber, address);
        this.shortName = shortName;
        this.fullName = fullName;
        this.fiscalCode = fiscalCode;
        this.VAT = VAT;
        this.bankName = bankName;
        this.bankAccount = bankAccount;
    }

    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public String getVAT() {
        return VAT;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    @Override
    public String toString() {
        return "ContractorCompany{id=" + super.getId()+" phone number=" + super.getPhoneNumber()+ " shortName=" + shortName + ", fullName=" + fullName + ", fiscalCode=" + fiscalCode + ", VAT=" + VAT + ", bankName=" + bankName + ", bankAccount=" + bankAccount + '}';
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public void setVAT(String VAT) {
        this.VAT = VAT;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

}
