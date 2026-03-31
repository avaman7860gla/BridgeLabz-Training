import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Utility{
    private Map<String, List<Contact>> cityMap=new HashMap<>();
    private Map<String, List<Contact>> stateMap=new HashMap<>();

    public void updateMaps(AddressBook book){
        for(Contact c:book.getContacts()){
            String city=c.getCity();
            String state=c.getState();
            if(!cityMap.containsKey(city)){
                cityMap.put(city, new ArrayList<Contact>());
            }
            cityMap.get(city).add(c);

            if(!stateMap.containsKey(state)){
                stateMap.put(state, new ArrayList<Contact>());
            }
            stateMap.get(state).add(c);
        }
    }

    public List<Contact> getPersonByCity(String city){
        return cityMap.getOrDefault(city, new ArrayList<>());
    }

    public List<Contact> getPersonByState(String state){
        return stateMap.getOrDefault(state, new ArrayList<>());
    }

    public int countByCity(String city){
        return getPersonByCity(city).size();
    }

    public int countByState(String state){
        return getPersonByState(state).size();
    }
}
