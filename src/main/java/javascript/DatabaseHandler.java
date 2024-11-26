package javascript;


import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Random;

public class DatabaseHandler {

    private static DatabaseHandler dbHandler = new DatabaseHandler("database.properties"); // singleton pattern
    private Properties config; // a "map" of properties
    private String uri = null; // uri to connect to mysql using jdbc

    /**
     * DataBaseHandler is a singleton, we want to prevent other classes
     * from creating objects of this class using the constructor
     */
    private DatabaseHandler(String propertiesFile){
        this.config = loadConfigFile(propertiesFile);
        this.uri = "jdbc:mysql://"+ config.getProperty("hostname") + "/" + config.getProperty("database") + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        //System.out.println("uri = " + uri);
    }

    /**
     * Returns the instance of the database handler.
     * @return instance of the database handler
     */
    public static DatabaseHandler getInstance() {
        return dbHandler;
    }


    /** Load info from config file database.properties
     *
     * @param propertyFile file with database info
     * @return properties
     */
    public Properties loadConfigFile(String propertyFile) {
        Properties config = new Properties();
        try (FileReader fr = new FileReader(propertyFile)) {
            config.load(fr);
        }
        catch (IOException e) {
            System.out.println(e);
        }

        return config;
    }

    /** Connect to the database and send a simple query about student. Get the result back (graduation
     * date and average GPA)
     */
    public String getStudentInfo(String studentName) {
        String s = "";

        try {

            PreparedStatement sql;
            try (Connection dbConnection = DriverManager.getConnection(uri, config.getProperty("username"), config.getProperty("password"))) {
                System.out.println("Opened connection");
                sql = dbConnection.prepareStatement("select * from students where name = ?");
                sql.setString(1, studentName);

                ResultSet results = sql.executeQuery();
                if (results.next()) { // go along rows using the iterator
                    double GPA = results.getDouble("GPA");
                    s = s + " GPA: " + GPA;
                }

            }
        } catch (Exception e) {
            System.err.println("Unable to connect properly to database.");
            System.err.println(e.getMessage());
        }
        return s;
    }
}

