import java.util.*;
import java.util.stream.Collectors;

class Book {
    private String title;
    private String genre;
    private int pages;

    // constructor
    public Book(String title, String genre, int pages) {
        this.title = title;
        this.genre = genre;
        this.pages = pages;
    }

    // getters
    public String getGenre() {
        return genre;
    }

    public int getPages() {
        return pages;
    }
}

public class LibraryStatistics {
    public static void main(String[] args) {

        // list of books
        List<Book> books = List.of(
                new Book("Java Basics", "Education", 450),
                new Book("Advanced Java", "Education", 600),
                new Book("Mystery House", "Fiction", 320),
                new Book("Dark Night", "Fiction", 410),
                new Book("Startup Guide", "Business", 280)
        );

        Map<String, IntSummaryStatistics> statsByGenre =
                books.stream()
                        .collect(Collectors.groupingBy(
                                Book::getGenre,
                                Collectors.summarizingInt(Book::getPages)
                        ));

        // display
        statsByGenre.forEach((genre, stats) -> {
            System.out.println("\nGenre: " + genre);
            System.out.println("Total Pages: " + stats.getSum());
            System.out.println("Average Pages: " + stats.getAverage());
            System.out.println("Max Pages: " + stats.getMax());
        });
    }
}
