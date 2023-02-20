import controllers.BookController;
import data.PostgreSQL;
import repositories.BookRepository;
import java.util.Scanner;

public class Main {
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PostgreSQL db = new PostgreSQL();
        BookRepository repo = new BookRepository(db);
        BookController controller = new BookController(repo);
        Menu menu = new Menu(controller);
        //login method
       Login login  = new Login();
       login.log();
        //menu method
        menu.go();
    }
}
