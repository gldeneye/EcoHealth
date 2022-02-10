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
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM CUSTOMER WHERE PERSNO = '"+persNo +"'")) {

            if (rs.next()) {
                Customer customer = new Customer(rs.getString("persNo"), rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"));

                if (customer.getPassword().equals(password)){
                    result = true;
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public Customer getCustomerInfo(String persNo){

        //custRepo.getCustomerInfo('931104-0125') -->
        Customer customer;

        try (Connection conn = dataSource.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM CUSTOMER WHERE PERSNO = '"+persNo +"' INNER JOIN CUSTOMERINFO ON CUSTOMER.Id = CUSTOMERINFO.CUSTOMERID")) {

            if (rs.next()) {
                customer = new Customer(rs.getString("persNo"), rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"));

                if/while ()){

                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;

    }
}
