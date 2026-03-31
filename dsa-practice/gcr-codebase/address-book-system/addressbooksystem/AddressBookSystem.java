import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;

public class AddressBookSystem{
    private Map<String, AddressBook> books;

    public AddressBookSystem(){
        books=new HashMap<>();
    }

    // UC6: Add multiple address books
    public void addbook(String name, AddressBook book){
        books.put(name, book);
    }

    public AddressBook getBook(String name){
        return books.get(name);
    }

    // UC8: Search across all address books
    public List<Contact> searchAcrossCity(String city) {
        return books.values().stream().flatMap(book -> book.searchByCity(city).stream())
                .collect(Collectors.toList());
    }

    public List<Contact> searchAcrossState(String state) {
        return books.values().stream().flatMap(book -> book.searchByState(state).stream())
            .collect(Collectors.toList());
    }

    //UC9: View across system
    public Map<String, List<Contact>> viewAcrossCity() {
        return books.values().stream().flatMap(book -> book.getContacts().stream())
                .collect(Collectors.groupingBy(Contact::getCity));
    }

    public Map<String, List<Contact>> viewAcrossState() {
        return books.values().stream().flatMap(book -> book.getContacts().stream())
                .collect(Collectors.groupingBy(Contact::getState));
    }

    // UC10: Count across system
    public int countAcrossCity(String city){
        return searchAcrossCity(city).size();
    }

    public int countAcrossState(String state){
        return searchAcrossState(state).size();
    }
}
