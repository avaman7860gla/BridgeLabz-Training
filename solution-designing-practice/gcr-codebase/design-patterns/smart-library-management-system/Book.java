public class Book {

    // Nested class
    public static class BookBuilder{
        private String title;
        private String author;
        private String edition;
        private String genre;

        // Constructor
        public BookBuilder(String title){
            this.title=title;
        }

        public BookBuilder author(String author){
            this.author=author;
            return this;
        }

        public BookBuilder edition(String edition){
            this.edition=edition;
            return this;
        }

        public BookBuilder genre(String genre){
            this.genre=genre;
            return this;
        }

        // Method to build
        public Book build(){
            return new Book(this);
        }
    }

    private String title;
    private String author;
    private String edition;
    private String genre;
    
    // Constructor
    public Book(BookBuilder builder){
        this.title=builder.title;
        this.author=builder.author;
        this.author=builder.author;
        this.edition=builder.edition;
        this.genre=builder.genre;
    }

    // Getter
    public String getTitle(){
        return title;
    }
}
