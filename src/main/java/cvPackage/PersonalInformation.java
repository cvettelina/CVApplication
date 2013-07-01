/*
 * $Id$
 *
 * Copyright 2013 Moneybookers Ltd. All Rights Reserved.
 * MONEYBOOKERS PROPRIETARY/CONFIDENTIAL. For internal use only.
 */

package cvPackage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonalInformation {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Address address;
    private Date dateOfBirth;

    public PersonalInformation(String firstName, String lastName, String email, String phone, Address address, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "{\n\t\t firstname: " + firstName + ",\n\t\t lastname: " + lastName + ",\n\t\t email: " + email + ",\n\t\t phone: " + phone + ",\n\t\t address: " + address
                + ", \n\t\t dateOfBirth: "
                + getDateOfBirthAsSimpleDate() + "\n\t }";
    }

    public PersonalInformation() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDateOfBirthAsSimpleDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(dateOfBirth);

    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
