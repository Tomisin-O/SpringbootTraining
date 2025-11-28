import java.sql.*;

public class DemoJdbc {
    public DemoJdbc() throws SQLException {
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String url = "jdbc:postgresql://localhost:5432/Demo";
        String username = "postgres";
        String password = "1234";
        String sql = "select sname from student where sid = 1";

        Class.forName("org.postgresql.Driver");
        //connect jar to db
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        String name = rs.getString("sname");

        System.out.println("Name of the student is " + name );
        con.close();
        System.out.println("connection is closed");
    }
}

