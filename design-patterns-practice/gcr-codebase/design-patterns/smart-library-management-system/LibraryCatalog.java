import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog {
    private static LibraryCatalog instance;
    private List<Observer> observers=new ArrayList<>();

    // Singleton access
    public static synchronized LibraryCatalog getInstance(){
        if(instance==null){
            instance=new LibraryCatalog();
        }
        return instance;
    }

    // Method to add observer
    public void addObserver(Observer observer){
        observers.add(observer);
    }

    // Method to notify observer
    public void notifyObserver(String message){
        for(Observer observer:observers){
            observer.update(message);
        }
    }

    // Method to add book
    public void addBook(Book book){
        notifyObserver("Book added: "+book.getTitle());
    }
}
