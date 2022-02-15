package com.example.EcoHealth.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ProductRepository {

    @Autowired
    private DataSource dataSource;

    public int getTokens(String productType){
        int tokens = 0;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT NumberOfTokens FROM PRODUCT WHERE NAME = ?")) {

            ps.setString(1, productType);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tokens = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tokens;
    }
}
