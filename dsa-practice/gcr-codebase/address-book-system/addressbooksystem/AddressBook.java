import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Comparator;

public class AddressBook implements ContactOps{

    private String name;
    private List<Contact> contacts;

    // constructor
    public AddressBook(String name, List<Contact> contacts){
        this.name=name;
        this.contacts=new ArrayList<>();
    }

    //UC2 & UC7: Add contact with duplicate check
    @Override
    public void addContact(Contact contact) {
        if(!contacts.contains(contact)){
            contacts.add(contact);
        }
        else{
            System.out.println("Duplicate contact: "+contact.getFirstName());
        }
    }

    //UC3: Edit contact using first and last name
    @Override
    public void editContact(String firstName, String lastName, Contact updatedContact) {
        for(Contact c:contacts){
            if(c.getFirstName().equalsIgnoreCase(firstName) && c.getLastName().equalsIgnoreCase(lastName)){
                c.editdetails(updatedContact.getAddress(), updatedContact.getCity(),updatedContact.getState(),updatedContact.getZip(),
                        updatedContact.getPhoneNo(), updatedContact.getEmail());
                return;
            }
        }
        System.out.println("Contact not found");
    }

    //UC4: Delete contact using name
    @Override
    public void deleteContact(String firstName, String lastName) {
        boolean removed=contacts.removeIf(c ->c.getFirstName().equalsIgnoreCase(firstName)
                        && c.getLastName().equalsIgnoreCase(lastName));
        if (removed){
            System.out.println("Contact deleted: " + firstName + " " + lastName);
        }  
        else{
            System.out.println("Contact not found");
        }
    }
        
    // UC5: Retrieve all contacts
    @Override
    public List<Contact> getContacts() {
        return contacts;
    }

    //UC8: Search by City & State
    public List<Contact> searchByCity(String city) {
        return contacts.stream().filter(c -> c.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<Contact> searchByState(String state) {
        return contacts.stream().filter(c -> c.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }

    // UC9: View Persons by City or State
    public Map<String, List<Contact>> viewByCity() {
        return contacts.stream().collect(Collectors.groupingBy(Contact::getCity));
    }

    public Map<String, List<Contact>> viewByState() {
        return contacts.stream().collect(Collectors.groupingBy(Contact::getState));
    }

    //UC10: Count Contacts by City or State
    public long countByCity(String city) {
        return contacts.stream().filter(c -> c.getCity().equalsIgnoreCase(city)).count();
    }

    public long countByState(String state) {
        return contacts.stream().filter(c -> c.getState().equalsIgnoreCase(state)).count();
    }

    //UC11 & UC12: Sorting Contacts
    public List<Contact> sortByName() {
        return contacts.stream().sorted(Comparator.comparing(Contact::getFirstName))
            .collect(Collectors.toList());
    }

    public List<Contact> sortByCity() {
        return contacts.stream().sorted(Comparator.comparing(Contact::getCity))
                .collect(Collectors.toList());
    }

    public List<Contact> sortByState() {
        return contacts.stream().sorted(Comparator.comparing(Contact::getState))
                .collect(Collectors.toList());
    }

    public List<Contact> sortByZip() {
        return contacts.stream().sorted(Comparator.comparing(Contact::getZip))
                .collect(Collectors.toList());
    }
}
