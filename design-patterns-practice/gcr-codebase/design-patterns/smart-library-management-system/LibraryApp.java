public class LibraryApp {
    public static void main(String[] args) {
        LibraryCatalog catalog=LibraryCatalog.getInstance();

        User student=UserFactory.createUser("student", "Aman");
        User faculty=UserFactory.createUser("faculty", "Rahul");

        student.showRole();
        faculty.showRole();

        catalog.addObserver(student);
        catalog.addObserver(faculty);

        Book book=new Book.BookBuilder("Java").author("abc").edition("1st edition").genre("ghi").build();

        catalog.addBook(book);

    }   
}
