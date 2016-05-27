package servicecentermanagementfx;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataSource {

    private static final Logger LOG = Logger.getLogger(DataSource.class.getName());

    private static DataSource instance;

    public static DataSource getInstance() {

        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    private DataSource() {
        try {
            loadProperties();
            LOG.info("Proprietatile incarcate cu succes!");
            loadDriver();
            LOG.info("Driver incarcat cu succes!");
            createConnection();
            LOG.info("Conexiunea creata cu succes!");
        } catch (IOException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadProperties() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("jdbc.properties"));

        driverName = props.getProperty("jdbc.drivername");
        urldb = props.getProperty("jdbc.urldb");
        db = props.getProperty("jdbc.db");
        userdb = props.getProperty("jdbc.userdb");
        password = props.getProperty("jdbc.password");

    }

    private void loadDriver() throws ClassNotFoundException {
        Class.forName(driverName);
    }

    private void createConnection() throws SQLException {
        conn = DriverManager.getConnection(urldb+db, userdb, password);
    }

    public Connection getConnection() throws SQLException {
        if (conn == null || (conn != null && conn.isClosed())) {
            createConnection();
        }
        return conn;
    }

    public void closeConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();

        }
    }

    private Connection conn;
    private String driverName;
    private String urldb;
    private String userdb;
    private String password;
    private String db;
}
