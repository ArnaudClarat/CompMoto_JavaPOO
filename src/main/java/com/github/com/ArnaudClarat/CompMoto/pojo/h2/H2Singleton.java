package com.github.com.ArnaudClarat.CompMoto.pojo.h2;

import org.h2.jdbcx.JdbcDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2Singleton {
    private static Connection connection;
    private static JdbcDataSource source;

    public static final String URL = "jdbc:h2:file:~/data/moto";
    public static final String USER = "SA";
    public static final String PASS = "";


    private static Connection getInstance() throws SQLException {
        if (connection == null) {
            // DB CONNECTION
            source = new JdbcDataSource();
            source.setURL(URL);
            source.setUser(USER);
            source.setPassword(PASS);
            connection = source.getConnection();
        }
        return connection;
    }

    private static void createDB() {
        try (Statement statement = getInstance().createStatement()) {
            createMotoTable();
            createMarqueTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createMotoTable() throws SQLException {
        String sql = "create table if not exists MOTO (" +
                "MOTO_ID identity primary key," +
                "MOTO_MARQUE varchar(50)," +
                "MOTO_MODELE varchar(50)," +
                "MOTO_PUISSANCE )";
        Statement statement = getInstance().createStatement();
        statement.execute(sql);
    }

    private static void createMarqueTable() throws SQLException {
        String sql = "create table if not exists MARQUES (" +
                "MAR_ID identity primary key," +
                "MAR_NAME varchar(50))";
        Statement statement = getInstance().createStatement();
        statement.execute(sql);
        String temp = "CREATE TABLE PLANETICKETS(\n" +
                "  DESTINATION VARCHAR(10) NOT NULL,\n" +
                "  TICKETPRICE NUMERIC(8,2) NOT NULL,\n" +
                "  TOURISTINFO_ID INT,\n" +
                "  foreign key (TOURISTINFO_ID) references touristinfo(TOURISTINFO_ID)\n" +
                ")";
    }



}
