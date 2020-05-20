
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi
{
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost/responsipbo";
        Connection conn = DriverManager.getConnection(url, "root", "");
        return conn;
    }
}
