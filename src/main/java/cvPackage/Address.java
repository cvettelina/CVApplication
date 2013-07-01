package cvPackage;

public class Address {
    private String country;
    private String city;
    private String addressLine1;
    private String addressLine2;
    private String zip;

    public Address(String country, String city, String addressLine1, String addressLine2, String zip) {
        super();
        this.country = country;
        this.city = city;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.zip = zip;
    }

    public Address(String country, String city, String addressLine1, String zip) {
        super();
        this.country = country;
        this.city = city;
        this.addressLine1 = addressLine1;
        this.addressLine2 = null;
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "{\n\t\t\t country: " + country + ",\n\t\t\t city: " + city + ",\n\t\t\t address 1: " + addressLine1 + ",\n\t\t\t address 2:" + addressLine2 + ",\n\t\t\t zip:"
                + zip
                + "\n\t\t }";
    }

    public Address() {
    }

    // getters
    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getZip() {
        return zip;
    }

    // setters
    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

}
