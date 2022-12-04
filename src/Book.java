public class Book {
    String name;
    String author;
    String genre;
    int datePublished;
    String dateBorrowed;
    String dateReturned;

    public Book(String name, String author, String genre, int datePublished, String dateBorrowed, String dateReturned) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.datePublished = datePublished;
        this.dateBorrowed = dateBorrowed;
        this.dateReturned = dateReturned;
    }

    public String toString() {
        return "(" + name + ", " + author + ", " + genre + ", " + datePublished + ", " + dateBorrowed + ", " + dateReturned + ")";
    }
}
