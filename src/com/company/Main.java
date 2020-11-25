package com.company;

import java.sql.*;

public class Main {

    public static void main(String args[]) throws ClassNotFoundException {
        final String DATABASE_URL = "jdbc:sqlite:books.db";
        final String SELECT_QUERY =
                "SELECT authorID, firstName, lastName FROM authors";

        Class.forName("org.sqlite.JDBC");
        Statement statement = null;
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SELECT_QUERY);

            while (res.next()) {
                System.out.println(res.getInt("authorID"));
                System.out.println(res.getString("firstName"));
                System.out.println(res.getString("lastName"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
