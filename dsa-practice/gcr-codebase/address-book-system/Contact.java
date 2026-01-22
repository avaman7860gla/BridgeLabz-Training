import java.util.Objects;

public class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNo;
    private String email;

    // UC1: Constructor to initialize contact details
    public Contact(String firstName, String lastName, String address, String city, String state, String zip, String phoneNo, String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.phoneNo=phoneNo;
        this.email=email;
    }

    // use getter and setter
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getAddress(){
        return address;
    }

    public String getPhoneNo(){
        return phoneNo;
    }

    public String getEmail(){
        return email;
    }

    public String getState(){
        return state;
    }

    public String getCity(){
        return city;
    }

    public String getZip(){
        return zip;
    }

    //UC7: Prevent duplicate contacts
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(firstName, contact.firstName) && Objects.equals(lastName, contact.lastName) && Objects.equals(address, contact.address) && Objects.equals(city, contact.city) && Objects.equals(state, contact.state) && Objects.equals(zip, contact.zip) && Objects.equals(phoneNo, contact.phoneNo) && Objects.equals(email, contact.email);
    }

    // toString method
    @Override
    public String toString() {
        return "firstName= " + firstName +
                ", lastName= " + lastName  +
                ", address= " + address  +
                ", city= " + city  +
                ", state= " + state  +
                ", zip= " + zip  +
                ", phoneNo= " + phoneNo  +
                ", email= " + email;
    }

    //UC3: Edit existing contact
    public void editdetails(String address, String city, String state, String zip, String phoneNo, String email){
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.phoneNo=phoneNo;
        this.email=email;
    }
}
