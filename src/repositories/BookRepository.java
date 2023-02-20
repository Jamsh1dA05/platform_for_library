package repositories;
import data.PostgreSQL;
import entities.Book;
import java.sql.*;
public class BookRepository {
    private final PostgreSQL db;
    public BookRepository(PostgreSQL db){this.db = db;}
    public Book getBook(int id){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT *  FROM books WHERE id = ?;"; // the string with request
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            System.out.println(rs);
            if(rs.next()) { // rs.next means that you will iterate row by row from the table books to find row with id
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getString("books_name"),
                        rs.getString("author"),
                        rs.getInt("year"));
                //System.out.println(book.toString());
                return book;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    public Book getBookByNameAndYear(String bookName, int year){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, books_name, author, year FROM books WHERE books_name = ? AND year = ?;";
            // the string with the request.
            // * means SELECT all columns FROM the table books WHERE bookName and year are inputted from console!
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, bookName);
            st.setInt(2, year);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getString("books_name"),
                        rs.getString("author"),
                        rs.getInt("year"));

                return book;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    public Book createBook(Book book) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO books (books_name,author,year) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, book.getBookName());
            st.setString(2, book.getAuthor());
            st.setInt(3, book.getYear());
            st.execute();
            return book;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }return null;
    }
    public boolean updateBook(int id, int year){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE books set year = ? WHERE id = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, year);
            st.setInt(2, id);
            st.executeUpdate();
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }return false;
    }
    public boolean deleteBook(int id){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE from books where id = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }return false;
    }
}
