package com.example.EcoHealth.Repositories;

import com.example.EcoHealth.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerRepository {

    @Autowired
    private DataSource dataSource;

    // ingen constructor dvs en tom default

    public List<Customer> getCustomers(){
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM CUSTOMER")) {

           while (rs.next()) {
                Customer customer = new Customer(rs.getString("persNo"), rs.getString("firstName"), rs.getString("lastName"));
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public Boolean checkPassword(String persNo, String password){
        Boolean result = false;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM CUSTOMER WHERE PERSNO = '"+persNo +"'")) {
                ps.setString(1, persNo);
                ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
