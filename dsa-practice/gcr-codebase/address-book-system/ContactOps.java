import java.util.List;
import java.util.ArrayList;

interface ContactOps{
    void addContact(Contact contact);
    void editContact(String firstName, String lastName, Contact updatedContact);
    void deleteContact(String firstName, String lastName);
    List<Contact> getContacts();
}
