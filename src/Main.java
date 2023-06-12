import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
       // insertData();
      // getData();
      //  deleteData();
        UpdateeData();

    }

    public static Connection getconnection() {

        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String databaseUrl = "jdbc:mysql://localhost:3306/java";
            String userName = "root";
            String password = "Pass@619";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(databaseUrl, userName, password);
            System.out.println("Connected Successfully");
            return conn;
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return null;
    }

    public static void getData() {
        try {
            Statement statement = getconnection().createStatement();
            ResultSet result = statement.executeQuery("Select * from user");
            while (result.next()) {
                System.out.println(result.getString("Name"));
                System.out.println(result.getString("Email"));
                System.out.println(result.getString("id"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public static void insertData() {

        try {
            Statement statement = getconnection().createStatement();
            int result = statement.executeUpdate("insert into user (id,Name,Email) values(3,'Sumit','sumit@gmail.com')");
            System.out.println(result);
            if (result == 1) {
                System.out.println("Data Inserted");
            } else {
                System.out.println("some error in inserting data");
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }

    public static void deleteData(){

        try{
            Statement statement = getconnection().createStatement();
            int result = statement.executeUpdate("delete from user where id=3");
            if (result == 1) {
                System.out.println("Data Deleted");
            } else {
                System.out.println("some error in deleteing data");
            }
        }catch (Exception e){
            System.out.println("error in delete data"+e);
        }

    }
    public static void UpdateeData() {

    try{
        Statement statement = getconnection().createStatement();
        int result = statement.executeUpdate("update user set name ='Prashant Mandlik' where id =2");
        if (result == 1) {
            System.out.println("Data Updated");
        } else {
            System.out.println("some error in updaing data");
        }
    }catch (Exception e) {
        System.out.println("Data Not Updated" + e);
    }
    }
}