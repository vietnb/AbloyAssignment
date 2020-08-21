package abloy.assignment.dblayer.connection;

import abloy.assignment.appexception.DbAccessException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDbAccess implements IDbAccess<Connection> {

    private String username;
    private String pwd;

    public MysqlDbAccess(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public Connection connect() throws DbAccessException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new DbAccessException(e.getMessage());
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sonoo", this.username, this.pwd);
        } catch (SQLException e) {
            throw new DbAccessException(e.getMessage());
        }
        return conn;
    }
}
