package entities;

public class Book {
    //NULL OBJECT PATTERN
    public static final Book NULL_BOOK = new Book("", "", 0);
    //ENDS
    private int id;
    private String bookName;
    private String author;
    private int year;
    public Book(int id, String bookName, String author, int year) {
        setId(id);
        setBookName(bookName);
        setAuthor(author);
        setYear(year);
    }
    public Book(String bookName, String author, int year){
        setBookName(bookName);
        setAuthor(author);
        setYear(year);
    }
    public Book(int id, int year){
        setId(id);
        setYear(year);
    }
    public Book(int id){
        setId(id);
    }
    public int getId() {return id;}
    public String getBookName() {return bookName;}
    public String getAuthor() {return author;}
    public int getYear() {return year;}

    public void setId(int id) {this.id = id;}
    public void setYear(int year) {this.year = year;}
    public void setAuthor(String author) {this.author = author;}
    public void setBookName(String bookName) {this.bookName = bookName;}
    @Override
    public String toString() {
        return "Book{" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
