package com.pj.banking_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // basic info
    private String name;

    @Column(unique = true)
    private String email;      // gmail ya koi bhi email

    private String phone;      // phone number
    private String address;    // full address

    // government id
    @Enumerated(EnumType.STRING)
    private GovernmentIdType governmentIdType;   // PAN / AADHAAR / DRIVING_LICENSE

    private String governmentIdNumber;           // id ka number

    public Customer() {}

    public Customer(String name,
                    String email,
                    String phone,
                    String address,
                    GovernmentIdType governmentIdType,
                    String governmentIdNumber) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.governmentIdType = governmentIdType;
        this.governmentIdNumber = governmentIdNumber;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public GovernmentIdType getGovernmentIdType() { return governmentIdType; }
    public void setGovernmentIdType(GovernmentIdType governmentIdType) {
        this.governmentIdType = governmentIdType;
    }

    public String getGovernmentIdNumber() { return governmentIdNumber; }
    public void setGovernmentIdNumber(String governmentIdNumber) {
        this.governmentIdNumber = governmentIdNumber;
    }
}
