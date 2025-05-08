import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class DbConnection {
    public static void readData() throws Exception {
        String url = "jdbc:mysql://localhost:3306/buspass";
        String userName = "root";
        String Password = "12345";
        String query = "select * from passengerdetail";
        Connection con = DriverManager.getConnection(url, userName, Password);

        Statement st = con.createStatement();
        ResultSet rt = st.executeQuery(query);
        while (rt.next()) {
            System.out.println("ID: " + rt.getInt(1));
            System.out.println("Name: " + rt.getString(2));
            System.out.println("Phone Number: " + rt.getInt(3));
            System.out.println("Address " + rt.getString(4));
            System.out.println("Source: " + rt.getString(5));
            System.out.println("Destination: " + rt.getString(6));
        }
        con.close();
    }

    public static void insertData() throws Exception {
        String url = "jdbc:mysql://localhost:3306/buspass";
        String userName = "root";
        String Password = "12345";
        String query = "insert into passengerdetail values(9,'swathi',9788062,'ambedkar street','karur','coimbatore')";
        Connection con = DriverManager.getConnection(url, userName, Password);

        Statement st = con.createStatement();
        int row = st.executeUpdate(query);
        System.out.println("Number of rows affected : " + row);
    }

    public static void insertVar() throws Exception {
        String url = "jdbc:mysql://localhost:3306/buspass";
        String userName = "root";
        String Password = "12345";
        int id = 7;
        String name = "ramya";
        String address = "gandhinagar";
        int phone_num = 987765478;
        String source = "kangeyam";
        String destination = "karur";
        String query = "insert into passengerdetail values(?,?,?,?,?,?)";
        Connection con = DriverManager.getConnection(url, userName, Password);

        // Statement st = con.createStatement();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, id);
        pst.setString(2, name);
        pst.setInt(3, phone_num);
        pst.setString(4, address);
        pst.setString(5, source);
        pst.setString(6, destination);

        int row = pst.executeUpdate();
        System.out.println("Number of rows affected : " + row);
        con.close();
    }

    public static void updateData() throws Exception {
        String url = "jdbc:mysql://localhost:3306/buspass";
        String userName = "root";
        String Password = "12345";
        int id = 3;
        String name = "aadhvik";
        String query = "update passengerdetail set name=? where id=?";
        Connection con = DriverManager.getConnection(url, userName, Password);

        // Statement st = con.createStatement();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, name);
        pst.setInt(2, id);
        int row = pst.executeUpdate();
        System.out.println(row);
    }

    public static void deleteData() throws Exception {
        String url = "jdbc:mysql://localhost:3306/buspass";
        String userName = "root";
        String Password = "12345";
        String query = "delete from passengerdetail  where id=?";

        int id = 7;
        Connection con = DriverManager.getConnection(url, userName, Password);
        // Statement st = con.createStatement();
        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1, id);
        int row = pst.executeUpdate();
        System.out.println("deleted " + row);
        con.close();

    }

}
