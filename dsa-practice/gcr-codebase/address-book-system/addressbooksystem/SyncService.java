// UC18:Sync
public class SyncService{
    public static void syncToServer(AddressBook book){
        book.getContacts().forEach(RESTService::send);
        System.out.println("Sync Completed");
    }
}