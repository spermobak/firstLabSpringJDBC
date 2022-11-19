package firstLab.utils;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class ConnectionAgent {



    static {
        setDriver();
    }

    public static Connection getNewConnection(){
        try {
            return DriverManager.getConnection(
                    ConnectionProperties.getByKeyProperties("url"),
                    ConnectionProperties.getByKeyProperties("user"),
                    ConnectionProperties.getByKeyProperties("password")
            );
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    static void setDriver (){
        try {
            Class.forName(ConnectionProperties.getByKeyProperties("driver"));
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
