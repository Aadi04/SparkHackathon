package javaFiles.util;

import java.sql.*;

public class DbConnection
{
    private static Connection connection = null;
    public static Connection connection() throws SQLException
    {
        if(connection == null)
        {
            connection = DriverManager.getConnection("jdbc:sqlite:HackathonDatabase.db");
        }
        else
        {
            connection.close();
            connection = DriverManager.getConnection("jdbc:sqlite:HackathonDatabase.db");
        }

        return connection;
//        try
//        {
//            Class.forName("org.sqlite.JDBC");
//
//            return DriverManager.getConnection("jdbc:sqlite:EmailStorageSystemDatabase.db");
//        }
//        catch (SQLException | ClassNotFoundException e)
//        {
//            System.out.println(e);
//            return null;
//        }
    }

}

