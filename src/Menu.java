import controllers.BookController;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final BookController controller;
    private final Scanner sc;

    public Menu(BookController controller) {
        this.controller = controller;
        sc = new Scanner(System.in);
    }

    public void go(){
        //Command pattern
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Get a book by id");
            System.out.println("2. Get a book by name and year");
            System.out.println("3. Create a book ");
            System.out.println("4. Update a book ");
            System.out.println("5. Delete a book");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter your  option : ");
                int option = sc.nextInt();
                if (option == 1) {
                    getBookMenu();
                } else if (option == 2) {
                    getBookByNameAndYearMenu();
                }
                else if(option == 3){
                    createBookMenu();
                }
                else if(option == 4){
                    updateBookMenu();
                }
                else if (option == 5) {
                    deleteBookMenu();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be number ");
                sc.nextLine();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("---------------------------------------");

        }
    }

    public void getBookMenu() throws SQLException {
        System.out.println("Enter the book ID :");
        int id = sc.nextInt();
        controller.getBook(id);
    }

    public void getBookByNameAndYearMenu() {
        System.out.println("Enter the book name:");
        sc.nextLine();
        String bookName = sc.nextLine();
        System.out.println("Enter the book year:");
        int year = sc.nextInt();
        controller.getBookByNameAndYear(bookName, year);
    }

    public void createBookMenu() {
        System.out.println("Enter  the book name:");
        sc.nextLine();
        String bookName = sc.nextLine();
        System.out.println("Enter the book author:");
        String author = sc.next();
        System.out.println("Input the book year:");
        int year = sc.nextInt();
        sc.nextLine();
        controller.createBook(bookName, author, year);
    }
    public void updateBookMenu() {
        System.out.println("Enter  the book id:");
        int id = sc.nextInt();
        System.out.println("Enter the book name:");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Enter the book year:");
        int year = sc.nextInt();
        controller.updateBook(id,name , year);
    }
    public void deleteBookMenu() {
        System.out.println("Enter  the book id:");
        int id = sc.nextInt();
        controller.deleteBook(id);
    }
}
