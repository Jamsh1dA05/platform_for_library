package data;

import java.sql.Connection;
import java.sql.SQLException;
public interface IDB {
    Connection getConneciton() throws SQLException, ClassNotFoundException;

}

