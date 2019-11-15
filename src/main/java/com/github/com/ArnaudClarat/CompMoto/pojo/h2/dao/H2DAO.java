package com.github.com.ArnaudClarat.CompMoto.pojo.h2.dao;

import com.github.com.ArnaudClarat.CompMoto.pojo.h2.DAO;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class H2DAO<T> implements DAO<T> {
    public Connection connection;

    {
        try {
            connection = H2Singleton.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
