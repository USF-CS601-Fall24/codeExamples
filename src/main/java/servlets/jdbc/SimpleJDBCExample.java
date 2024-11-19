package servlets.jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.sql.ResultSetMetaData;

/**
 * The example is modified from the example by Prof. Engle.
 * This class demonstrates how to access your MySql database from the Java program using JDBC. 
 * You need to have a database.properties file with username, password, database, and hostname in the project
 * directory. Need to change the file depending on whether you are on campus or off campus.
 * You must also have the tunnel to stargate.cs.usfca.edu running if you running code off-campus.
 */
public class SimpleJDBCExample {

	/**
	 * URI to use when connecting to database. Should be in the format:
	 * jdbc:subprotocol://hostname/database
	 */
	public String uri = "";

	/**
	 * Attempts to load properties file with database configuration. Must
	 * include username, password, database, and hostname.
	 *
	 * @param configPath
	 *            path to database properties file
	 * @return database properties
	 * @throws IOException
	 *             if unable to properly parse properties file
	 *
	 */
	private Properties loadConfig(String configPath) throws IOException {
		Properties config = new Properties();
		config.load(new FileReader(configPath));

		return config;
	}

	/** Connect to the database and send a simple query.  Assumes the database
	 * has a students table.
	 */
	public void connectToDatabase() {
		try {
			Properties config = loadConfig("database.properties");

			// Create database URI:
			String uri = "jdbc:mysql://"+ config.getProperty("hostname") + "/" + config.getProperty("database") + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			System.out.println("uri = " + uri);

			PreparedStatement sql;
			try (Connection dbConnection = DriverManager.getConnection(uri, config.getProperty("username"), config.getProperty("password"))) {
				sql = dbConnection.prepareStatement("select * from students where id>? and GPA >= ?");
				sql.setInt(1, 2);  
				sql.setDouble(2, 3.9);

				ResultSet results = sql.executeQuery();
				ResultSetMetaData rsmd = results.getMetaData();
				int columnsNumber = rsmd.getColumnCount(); // number of columns
				while (results.next()) { // iterate over rows
					for (int i = 1; i <= columnsNumber; i++) // go over columns
					  System.out.print(results.getString(i) + " ");
					  System.out.println();
				}
			}
		} catch (Exception e) {
			System.err.println("Unable to connect to the database.");
			System.err.println(e.getMessage());
		}
	}


	public static void main(String[] args) {
		SimpleJDBCExample test = new SimpleJDBCExample();
		test.connectToDatabase();
	}
}
