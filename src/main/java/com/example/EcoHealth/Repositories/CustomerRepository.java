package com.example.EcoHealth.Repositories;

import com.example.EcoHealth.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerRepository {

    private List<Customer> customers;

    @Autowired
    private DataSource dataSource;

//    public List <Customer> getCustomers() {
//        customers = new ArrayList<>();
//        try (Connection conn = dataSource.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT * from CUSTOMER")) {
//
//            while (rs.next()) {
//                customers.add(rs(rs));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return forumUsers;
//    }

}
