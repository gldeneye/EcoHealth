package com.example.EcoHealth.Repositories;

import com.example.EcoHealth.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
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
             PreparedStatement ps = conn.prepareStatement("SELECT PASSWORD FROM CUSTOMER WHERE PERSNO = ?")) {
                ps.setString(1, persNo);
                ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = rs.getString("password").equals(password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public int calcCustomerTokens(String persNo) {
        int numOfTokens = 0;
        try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT SUM (NUMBEROFTOKENS) FROM AGREEMENT "+
                "INNER JOIN PRODUCT ON AGREEMENT.PRODUCTID = PRODUCT.ID " +
                "INNER JOIN CUSTOMER ON AGREEMENT.CUSTOMERID = CUSTOMER.ID " +
                "WHERE CUSTOMER.PERSNO =?")) {

            ps.setString(1,persNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                numOfTokens = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfTokens;
    }

    public boolean checkProduct(String persNo, String productType) {
        int flag = 0;
        boolean hasproduct = false;
        try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement("select count (*) " +
                "from agreement " +
                "inner join product on product.id = agreement.productid " +
                "inner join customer on agreement.customerid = customer.id " +
                "where customer.persNo = ? and product.name = ?")) {

            ps.setString(1,persNo);
            ps.setString(2,productType);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                flag = rs.getInt(1);
                if (flag > 0) {
                    hasproduct = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasproduct;
    }

    public Boolean getHasChildren(String persNo) {
        Boolean hasChildren = false;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT CHILDREN " +
                     "FROM CUSTOMERINFO " +
                     "INNER JOIN CUSTOMER ON CUSTOMERINFO.CUSTOMERID = CUSTOMER.ID " +
                     "WHERE CUSTOMER.PERSNO = ?")) {
            ps.setString(1, persNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                hasChildren = rs.getBoolean(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasChildren;
    }
//
    public String getMaritalOrAccommodationStatus(String persNo, String infoType) {
        //"maritalStatus" eller "accommodation" som andra in-parameter
        String type = "unknown";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT " + infoType + ".NAME " +
                     "FROM CUSTOMERINFO " +
                     "INNER JOIN CUSTOMER ON CUSTOMERINFO.CUSTOMERID = CUSTOMER.ID " +
                     "INNER JOIN " + infoType + " ON CUSTOMERINFO." + infoType + "ID = " + infoType + ".ID " +
                     "WHERE CUSTOMER.PERSNO = ?")) {

            ps.setString(1,persNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                type = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

    public String getEmail(String persNo) {
        String email = "unknown";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT EMAIL FROM CUSTOMER WHERE PERSNO = ?")) {

            ps.setString(1,persNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                email = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }

    public String getFullName(String persNo) {
        String firstName = "John";
        String lastName = "Doe";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT FIRSTNAME, LASTNAME FROM CUSTOMER WHERE PERSNO = ?")) {

            ps.setString(1,persNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                firstName = rs.getString(1);
                lastName = rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return firstName + "_" + lastName;
    }

    public int getNumberOfAgreements(String persNo) {
        int numOfAgreements = 0;
        try(Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT COUNT (*) " +
                "FROM AGREEMENT " +
                "INNER JOIN CUSTOMER ON CUSTOMER.ID = AGREEMENT.CUSTOMERID " +
                "WHERE CUSTOMER.PERSNO = ?")) {

            ps.setString(1,persNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                numOfAgreements = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfAgreements;
    }


}
