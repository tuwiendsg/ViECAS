package at.ac.tuwien.dsg.scu.crowd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import at.ac.tuwien.dsg.scu.common.Util;

public class CrowdDatabase {

  // constants
  private static final String PROP_FILE = CrowdGenerator.PROP_FILE;

  private Connection connection = null;
  private static CrowdDatabase db = null;
  
  public static CrowdDatabase getInstance() {
    if (db==null) {
      db = new CrowdDatabase();
    }
    if (db.connection==null) {
      db.open();
    }
    return db;
  }
  
  public static void closeInstance() {
    if (db!=null) {
      db.close();
    }
  }

  public void open() {
    if (connection==null) {
      // load the JDBC driver using the current class loader
      try {
        Class.forName(Util.getProperty(PROP_FILE, "jdbc_driver"));
      } catch (ClassNotFoundException e1) {
        e1.printStackTrace();
      }
      // create a database connection
      try {
        String url = Util.getProperty(PROP_FILE, "jdbc_url");
        String user = Util.getProperty(PROP_FILE, "jdbc_user");
        String password = Util.getProperty(PROP_FILE, "jdbc_password");
        connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
  
  public void close() {
    try {
      if(connection != null) {
        connection.close();
        connection = null;
      }
    } catch(SQLException e)  {
      // connection close failed.
      e.printStackTrace();
    }
  }

  public Statement getStatement() {
    Statement statement = null;
    try {
      statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return statement;
  }
  
}
