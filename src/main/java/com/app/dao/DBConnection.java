package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    public static Connection getConnection(){

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            return connection;
        }
        catch (ClassNotFoundException e){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        catch (SQLException e){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return connection;
    }
}
