package imageorg.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectivity {
    private static Connection conn;
    private static final String DBURL="jdbc:h2:~/image";
    private static final String USER="suresh";
    private static final String PASSWORD="suresh";

    static{
        try{
            Class.forName("org.h2.Driver");
            conn=DriverManager.getConnection(DBURL,USER,PASSWORD);
        }catch(SQLException|ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private DatabaseConnectivity(){}

    public static Connection getConnection(){
        return conn;
    }

    public static void closeConnection(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
