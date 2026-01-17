import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;

class Book{
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn){
        this.title=title;
        this.author=author;
        this.isbn=isbn;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getIsbn(){
        return isbn;
    }

    public String toString(){
        return "Title: "+title+", Author: "+author+", Isbn: "+isbn;
    }
}

interface Library{
    public void addBook(String genre, Book book);
    public Book borrowBook(String genre, String isbn);
    public void returnBook(String genre, Book book);
    public List<Book> getBookByGenre(String genre);
}

class BookShelf implements Library{
    private Map<String, LinkedList<Book>> genreCatalog=new HashMap<>();
    
    @Override
    public void addBook(String genre, Book book){
        genreCatalog.putIfAbsent(genre, new LinkedList<>());
        genreCatalog.get(genre).add(book);
    }

    @Override
    public Book borrowBook(String genre, String isbn){
        LinkedList<Book> books=genreCatalog.get(genre);
        if(books!=null){
            for(Book book:books){
                if(book.getIsbn().equals(books)){
                    books.remove();
                    return book;
                }
            }
        }
        return null;
    }

    @Override
    public void returnBook(String genre, Book book){
        genreCatalog.putIfAbsent(genre, new LinkedList<>());
        genreCatalog.get(genre).add(book);
    }

    @Override
    public List<Book> getBookByGenre(String genre){
        return genreCatalog.get(genre);
    }
}

class LibrarySystem extends BookShelf{
    private Map<String, BookShelf> shelves=new HashMap<>();

    public void addShelf(String genre, BookShelf shelf){
        shelves.put(genre, shelf);
        System.out.println("Shelf added for genre: "+genre);
    }

    public BookShelf getShelf(String genre){
        return shelves.get(genre);
    }

    public void displayCatalog(){
        for(Map.Entry<String, BookShelf> e:shelves.entrySet()){
            String genre=e.getKey();
            BookShelf shelf=e.getValue();
            System.out.println("Genre: "+genre);
            List<Book> books=shelf.getBookByGenre(genre);
            if(books!=null){
                for(Book book:books){
                    System.out.println(book);
                }
            }
            else{
                System.out.println("No books available");
            }
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LibrarySystem lib=new LibrarySystem();
        while(true){
            System.out.println("1.Add Shelf");
            System.out.println("2.Add Book");
            System.out.println("3.Borrow Book");
            System.out.println("4.Return Book");
            System.out.println("5.Display Catalog");
            System.out.println("6.Exit");

            System.out.println("Enter choice: ");
            int choice=sc.nextInt();
            if(choice==6){
                System.out.println("Exit");
                break;
            }
            switch(choice){
                case 1:
                    System.out.println("Enter genre: ");
                    String genre=sc.next();
                    lib.addShelf(genre, new BookShelf());
                    break;
                case 2:
                    System.out.println("Enter genre: ");
                    genre=sc.next();
                    System.out.println("Enter title: ");
                    String title=sc.next();
                    System.out.println("Enter author: ");
                    String author=sc.next();
                    System.out.println("Enter isbn: ");
                    String isbn=sc.next();
                    Book book=new Book(title, author, isbn);
                    BookShelf shelf=lib.getShelf(genre);
                    if(shelf!=null){
                        shelf.addBook(genre, book);
                        System.out.println("Book added");
                    }
                    else{
                        System.out.println("Shelf not added");
                    }
                    break;
                case 3:
                    System.out.println("Enter genre: ");
                    genre=sc.next();
                    System.out.println("Enter isbn: ");
                    isbn=sc.next();
                    shelf=lib.getShelf(genre);
                    if(shelf!=null){
                        book=shelf.borrowBook(genre, isbn);
                        if(book!=null){
                            System.out.println("Book borrowed: "+book);
                        }
                        else{
                            System.out.println("Book not available");
                        }
                    }
                    else{
                        System.out.println("Shelf not found");
                    }
                    break;
                case 4:
                    System.out.println("Enter genre: ");
                    genre=sc.next();
                    System.out.println("Enter title: ");
                    title=sc.next();
                    System.out.println("Enter author: ");
                    author=sc.next();
                    System.out.println("Enter isbn: ");
                    isbn=sc.next();
                    book=new Book(title, author, isbn);
                    shelf=lib.getShelf(genre);
                    if(shelf!=null){
                        shelf.returnBook(genre, book);
                        System.out.println("Book returned");
                    }
                    else{
                        System.out.println("Shelf not found");
                    }
                    break;
                case 5:
                    lib.displayCatalog();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

    }    
}
