import java.util.List;
import java.util.ArrayList;
import java.util.Map;
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
    public List<Contact> searchAcrossCity(String city){
        List<Contact> result=new ArrayList<>();
        for(AddressBook book:books.values()){
            result.addAll(book.searchByCity(city));
        }
        return result;
    }

    public List<Contact> searchAcrossState(String state){
        List<Contact> result=new ArrayList<>();
        for(AddressBook book: books.values()){
            result.addAll(book.searchByState(state));
        }
        return result;
    }

    //UC9: View across system
    public Map<String, List<Contact>> viewAcrossCity(){
        Map<String, List<Contact>> map=new HashMap<>();
        for (AddressBook book:books.values()){
            Map<String, List<Contact>> cityMap=book.viewByCity();
            for (Map.Entry<String, List<Contact>> entry:cityMap.entrySet()){
                String city=entry.getKey();
                List<Contact> contactsList=entry.getValue();
                if (!map.containsKey(city)){
                    map.put(city, new ArrayList<>());
                }
                map.get(city).addAll(contactsList);
            }
        }
        return map;
    }

    public Map<String, List<Contact>> viewAcrossState(){
        Map<String, List<Contact>> map=new HashMap<>();
        for(AddressBook book:books.values()){
            Map<String, List<Contact>> stateMap=book.viewByState();
            for(Map.Entry<String, List<Contact>> entry:stateMap.entrySet()){
                String state=entry.getKey();
                List<Contact> contactList=entry.getValue();
                if(!map.containsKey(state)){
                    map.put(state, new ArrayList<>());
                }
                map.get(state).addAll(contactList);
            }
        }
        return map;
    }

    // UC10: Count across system
    public int countAcrossCity(String city){
        return searchAcrossCity(city).size();
    }

    public int countAcrossState(String state){
        return searchAcrossState(state).size();
    }
}
