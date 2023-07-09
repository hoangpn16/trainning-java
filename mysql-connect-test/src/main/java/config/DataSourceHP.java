package config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceHP {
    private static Config configInfor = ConfigFactory.parseFile(new File("application.properties"));
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setPoolName("Hikari-MySQL-Pool");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl(configInfor.getString("sql_23122_url"));
        config.setUsername(configInfor.getString("sql_23122_user"));
        config.setPassword(configInfor.getString("sql_23122_pass"));
        config.setAutoCommit(true);
        config.setMaximumPoolSize(20);
        config.setMinimumIdle(2);
        config.setConnectionTimeout(30000);
        config.setMaxLifetime(30000);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("useServerPrepStmts", true);
        config.addDataSourceProperty("allowLoadLocalInfile", true);
        ds = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
