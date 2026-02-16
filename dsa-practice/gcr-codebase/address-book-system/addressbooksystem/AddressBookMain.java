import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System");

        // Address book creation
        AddressBookSystem system = new AddressBookSystem();
        AddressBook personalBook = new AddressBook("Personal", new ArrayList<>());
        // addding book to system
        system.addbook("Personal", personalBook);


        // adding contacts
        personalBook.addContact(new Contact("Aman", "Verma", "Kheria Mod","Agra", "UP", "282001", "9876543210", "aman@abc.com"));
        personalBook.addContact(new Contact("Ravi", "Kumar", "Arjun Nagar","Chhata", "UP", "281403", "9123456780", "ravi@abc.com"));

        System.out.println("\nAdded contacts:");
        for (Contact c : personalBook.getContacts()) {
            System.out.println(c);
        }


        // updating contact
        Contact updatedRavi = new Contact("Ravi", "Kumar", "Street 22", "Agra", "UP", "282001", "9000000000", "ravi_new@example.com");
        // editing contact
        personalBook.editContact("Ravi", "Kumar", updatedRavi);

        System.out.println("\nAfter editing Ravi:");
        for (Contact c : personalBook.getContacts()) {
            System.out.println(c);
        }


        System.out.println();
        // deleting contact
        personalBook.deleteContact("Aman", "Verma");

        System.out.println("\nAfter deleting Aman:");
        for (Contact c : personalBook.getContacts()) {
            System.out.println(c);
        }


        AddressBook workBook = new AddressBook("Work", new ArrayList<>());
        system.addbook("Work", workBook);
        workBook.addContact(new Contact("Suresh", "Agarwal", "Office", "abc", "Delhi", "110002", "9111111111", "suresh@abc.com"));

        System.out.println("\nWork book contacts:");
        for (Contact c : workBook.getContacts()) {
            System.out.println(c);
        }


        System.out.println("\nSearch across city Delhi:");
        for (Contact c : system.searchAcrossCity("Delhi")) {
            System.out.println(c);
        }

        System.out.println("\nSearch across state UP:");
        for (Contact c : system.searchAcrossState("UP")) {
            System.out.println(c);
        }


        System.out.println("\nView by City in Personal book:");
        for (Map.Entry<String, List<Contact>> entry : personalBook.viewByCity().entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


        System.out.println("\nView by State across system:");
        for (Map.Entry<String, List<Contact>> entry : system.viewAcrossState().entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


        System.out.println("\nCount in Personal book by city Chhata: "+personalBook.countByCity("Chhata"));
        System.out.println("Count across system by state UP: " +system.countAcrossState("UP"));


        System.out.println("\nSorting by Name in Personal book:");
        for (Contact c : personalBook.sortByName()) {
            System.out.println(c);
        }

        System.out.println("\nSorting by City in Personal book:");
        for (Contact c : personalBook.sortByCity()) {
            System.out.println(c);
        }

        System.out.println("\nSorting by State in Personal book:");
        for (Contact c : personalBook.sortByState()) {
            System.out.println(c);
        }

        System.out.println("\nSorting by Zip in Personal book:");
        for (Contact c : personalBook.sortByZip()) {
            System.out.println(c);
        }

        Utility util = new Utility();
        util.updateMaps(personalBook);
        util.updateMaps(workBook);

        System.out.println("\nUtility: Persons in city Delhi: " + util.getPersonByCity("Delhi"));
        System.out.println("Utility: Count in state UP: " + util.countByState("UP"));

        // UC13 to 15
        FileIOService.write(personalBook,"contacts.txt");
        CSVService.write(personalBook,"contacts.csv");
        JSONService.write(personalBook,"contacts.json");

        // UC16
        RESTService.send(personalBook.getContacts().get(0));

        // UC17
        AsyncService async=new AsyncService();
        async.save(personalBook);
        async.shutdown();

        // UC18
        SyncService.syncToServer(personalBook);
    }
}