import java.util.List;
import java.util.ArrayList;
import java.util.Map;
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
        for(int i=0;i<contacts.size();i++){
            Contact c=contacts.get(i);
            if(c.getFirstName().equalsIgnoreCase(firstName) && c.getLastName().equalsIgnoreCase(lastName)){
                contacts.remove(i);
                System.out.println("contact deleted: "+firstName+" "+lastName);
                return;
            }
        }
        System.out.println("Contact not found");
    }

    // UC5: Retrieve all contacts
    @Override
    public List<Contact> getContacts() {
        return contacts;
    }

    //UC8: Search by City & State
    public List<Contact> searchByCity(String city){
        List<Contact> result=new ArrayList<>();
        for(Contact c:contacts){
            if(c.getCity().equalsIgnoreCase(city)){
                result.add(c);
            }
        }
        return result;
    }

    public List<Contact> searchByState(String state){
        List<Contact> result=new ArrayList<>();
        for(Contact c:contacts){
            if(c.getState().equalsIgnoreCase(state)){
                result.add(c);
            }
        }
        return result;
    }

    // UC9: View Persons by City or State
    public Map<String, List<Contact>> viewByCity(){
        Map<String, List<Contact>> map=new HashMap<>();
        for (Contact c:contacts){
            String city=c.getCity();
            if(!map.containsKey(city)){
                map.put(city, new ArrayList<>());
            }
            map.get(city).add(c);
        }
        return map;
    }

    public Map<String, List<Contact>> viewByState(){
        Map<String, List<Contact>> map=new HashMap<>();
        for(Contact c:contacts){
            String state=c.getState();
            if(!map.containsKey(state)){
                map.put(state, new ArrayList<>());
            }
            map.get(state).add(c);
        }
        return map;
    }

    //UC10: Count Contacts by City or State
    public int countByCity(String city){
        return searchByCity(city).size();
    }

    public int countByState(String state){
        return searchByState(state).size();
    }

    //UC11 & UC12: Sorting Contacts
    public List<Contact> sortByName(){
        contacts.sort(Comparator.comparing(Contact::getFirstName));
        return contacts;
    }

    public List<Contact> sortByCity(){
        contacts.sort(Comparator.comparing(Contact::getCity));
        return contacts;
    }

    public List<Contact> sortByState(){
        contacts.sort(Comparator.comparing(Contact::getState));
        return contacts;
    }

    public List<Contact> sortByZip(){
        contacts.sort(Comparator.comparing(Contact::getZip));
        return contacts;
    }
}
