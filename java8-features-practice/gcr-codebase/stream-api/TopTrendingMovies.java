import java.util.*;
import java.util.stream.*;

class Movie {
    String name;
    double rating;
    int releaseYear;

    // getters
    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return rating;
    }

    // constructor
    Movie(String name, double rating, int releaseYear) {
        this.name = name;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    

    // override toString method
    @Override
    public String toString() {
        return name + " , Rating: " + rating + " , Year: " + releaseYear;
    }
}

public class TopTrendingMovies {
    public static void main(String[] args) {
        // list of movies with rating and year
        List<Movie> movies = List.of(
                new Movie("Movie A", 8.5, 2023),
                new Movie("Movie B", 9.0, 2024),
                new Movie("Movie C", 9.0, 2022),
                new Movie("Movie D", 7.8, 2021),
                new Movie("Movie E", 8.9, 2025),
                new Movie("Movie F", 9.2, 2024)
        );

        // use stream and display
        movies.stream().sorted(Comparator
                        .comparing(Movie::getRating).reversed()
                        .thenComparing(Movie::getReleaseYear, Comparator.reverseOrder()))
                .limit(5)
                .forEach(System.out::println);
    }
}
