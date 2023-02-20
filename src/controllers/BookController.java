package controllers;

import entities.Book;
import repositories.BookRepository;

public class BookController {
    private final BookRepository repo;
    public BookController(BookRepository repo) {
        this.repo = repo;
    }
    public void getBook(int id) {
        Book book = repo.getBook(id);
        if(book == Book.NULL_BOOK){
            System.out.println("Book was not found!");
        }
        else System.out.println(book.toString());
    }
    public void getBookByNameAndYear(String bookName, int year) {
        Book book = repo.getBookByNameAndYear(bookName, year);
        if(book == Book.NULL_BOOK){
            System.out.println("Book was not found!");
        }
        else System.out.println("A book is found by name and year " + book.toString());
    }
    public void createBook(String bookName, String author, int year) {
        Book book = new Book(bookName, author, year);
        book = repo.createBook(book);
        if(book == Book.NULL_BOOK){
            System.out.println("A book creation is failed");
        }
        else {
            System.out.println("A book is created " + book.toString());
        }
    }
    public void updateBook(int id, String name, int year) {
       boolean updated = repo.updateBook(id, year);
        if(updated == false){
            System.out.println("A book update is failed");
        }
        else System.out.println("A book is updated ");

    }
    public void deleteBook(int id) {
        boolean deleted = repo.deleteBook(id);
        if(deleted == false){
            System.out.println("A book delete is failed!");
            System.out.println("Please try again!");
        }
        else System.out.println("A book is deleted! ");
    }
}
