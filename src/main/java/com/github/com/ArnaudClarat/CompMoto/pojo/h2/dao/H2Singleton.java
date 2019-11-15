package com.github.com.ArnaudClarat.CompMoto.pojo.h2.dao;

import org.h2.jdbcx.JdbcDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class H2Singleton {
    private static Connection connection;
    private static JdbcDataSource source;

    public static final String URL = "jdbc:h2:file:~/data/moto";
    public static final String USER = "SA";
    public static final String PASS = "";


    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            // DB CONNECTION
            source = new JdbcDataSource();
            try {
                source.setURL(URL + ";IFEXISTS=TRUE");
                source.setUser(USER);
                source.setPassword(PASS);
                connection = source.getConnection();
            } catch(final Exception e) {
                source.setURL(URL);
                source.setUser(USER);
                source.setPassword(PASS);
                connection = source.getConnection();
                createDB();
            }
        }
        return connection;
    }

    private static void createDB() {
        try {
            createMarqueTable();
            createMotoTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createMotoTable() throws SQLException {
        String sql = "create table if not exists MOTO (" +
                "MOTO_ID identity primary key," +
                "MOTO_MARQUE varchar(50)," +
                "MOTO_MODELE varchar(50)," +
                "MOTO_PUISSANCE decimal," +
                "MOTO_CONSO decimal," +
                "MOTO_RESERV decimal," +
                "MOTO_AUTONOMIE decimal," +
                "MOTO_PRIX decimal," +
                "MOTO_NOTE-PERSO decimal," +
                "MOTO_NOTE-TOTALE decimal," +
                "foreign key (MOTO_MARQUE) references MARQUE(MAR_NAME))";
        Statement statement = getInstance().createStatement();
        statement.execute(sql);
    }

    private static void createMarqueTable() throws SQLException {
        String sql = "create table if not exists MARQUES (" +
                "MAR_ID identity primary key," +
                "MAR_NAME varchar(50))";
        Statement statement = getInstance().createStatement();
        statement.execute(sql);
    }
}
