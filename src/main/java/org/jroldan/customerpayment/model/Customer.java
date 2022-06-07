package org.jroldan.customerpayment.model;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "IBAN_ENCRYPTED")
    private String ibanEncrypted;

    @Column(name = "HASH_IBAN")
    private String ibanHashed;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CONTRACT_ID")
    private Long contractId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIbanEncrypted() {
        return ibanEncrypted;
    }

    public void setIbanEncrypted(String ibanEncrypted) {
        this.ibanEncrypted = ibanEncrypted;
    }

    public String getIbanHashed() {
        return ibanHashed;
    }

    public void setIbanHashed(String ibanHashed) {
        this.ibanHashed = ibanHashed;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }
}
