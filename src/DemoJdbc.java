import java.sql.*;

public class DemoJdbc {
    public DemoJdbc() throws SQLException {
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String url = "jdbc:postgresql://localhost:5432/Demo";
        String username = "postgres";
        String password = "1234";
        String sql = "select * from student";

        Class.forName("org.postgresql.Driver");
        //connect jar to db
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
//        rs.next();
//        String name = rs.getString("sname");
//        System.out.println("Name of the student is " + name );

        while(rs.next()) {
            System.out.print(rs.getInt(1) + " - ");
            System.out.print(rs.getString(2) + " - ");
            System.out.println(rs.getInt(3));
        }

        con.close();
        System.out.println("connection is closed");
    }
}

