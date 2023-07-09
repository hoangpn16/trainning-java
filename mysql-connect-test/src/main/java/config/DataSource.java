package config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private static final String url;
    private static final String user;
    private static final String password;

    static {
        Config config = ConfigFactory.parseFile(new File("application.properties"));

        url = config.getString("sql_23122_url");
        user = config.getString("sql_23122_user");
        password = config.getString("sql_23122_pass");


        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {
            System.out.println("Can't load mysql driver" + e);
        }

    }

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
