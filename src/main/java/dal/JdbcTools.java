package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import conf.Settings;

public class JdbcTools {
	private static String urldb;
	private static String userdb;
	private static String passworddb;
	static {
	urldb = Settings.getProperty("urldb");
	userdb = Settings.getProperty("userdb");
	passworddb = Settings.getProperty("passworddb");
	}
	public static Connection getConnection() throws SQLException{
	Connection connection = DriverManager.getConnection(urldb, userdb, passworddb);
	return connection;
}
}
