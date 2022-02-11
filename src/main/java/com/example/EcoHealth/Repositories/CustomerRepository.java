package com.example.EcoHealth.Repositories;

import com.example.EcoHealth.Customer;
import org.springframework.beans.factory.annotation.Autowired;
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

//    public Boolean getHasChildrenFromDB(String persNo) {
//        Boolean hasChildren = false;
//        try (Connection conn = dataSource.getConnection();
//             Statement statement = conn.createStatement();
//             ResultSet rs = statement.executeQuery("SELECT CUSTOMER.ID, CUSTOMERINFO.Children\n" +
//                     "FROM CUSTOMER \n" +
//                     "LEFT JOIN CUSTOMERINFO \n" +
//                     "ON CUSTOMER.ID = CUSTOMERINFO.CUSTOMERID\n" +
//                     "WHERE CUSTOMER.PERSNO = '" + persNo + "'")) {
//            if (rs.next()) {
//                hasChildren = rs.getBoolean("Children");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return hasChildren;
//    }
//
//    public String getInfoType(String persNo, String infoType) {
//        String type = "unknown";
//        try (Connection conn = dataSource.getConnection();
//             PreparedStatement ps = conn.prepareStatement("SELECT CUSTOMERINFO.?" +
//                     "FROM CUSTOMER " +
//                     "LEFT JOIN CUSTOMERINFO  " +
//                     "ON CUSTOMER.ID = CUSTOMERINFO.CUSTOMERID " +
//                     "WHERE CUSTOMER.PERSNO = ?")) {
//
//            ps.setString(1,infoType);
//            ps.setString(2,persNo);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                type = rs.getString(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return type;
//    }
//
//    public String getTypeOfLivingFromDB(String persNo) {
//        String typeOfLiving = "unknown";
//        try (Connection conn = dataSource.getConnection();
//             Statement statement = conn.createStatement();
//             ResultSet rs = statement.executeQuery("SELECT CUSTOMER.ID, CUSTOMERINFO.ACCOMMODATION\n" +
//                     "FROM CUSTOMER \n" +
//                     "LEFT JOIN CUSTOMERINFO \n" +
//                     "ON CUSTOMER.ID = CUSTOMERINFO.CUSTOMERID\n" +
//                     "WHERE CUSTOMER.PERSNO = '" + persNo + "'")) {
//            if (rs.next()) {
//                typeOfLiving = rs.getString("ACCOMMODATION");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return typeOfLiving;
//    }
//
//    public String getEmailFromDB(String persNo) {
//        String email = "unknown";
//        try (Connection conn = dataSource.getConnection();
//             Statement statement = conn.createStatement();
//             ResultSet rs = statement.executeQuery("SELECT EMAIL FROM CUSTOMER WHERE PERSNO= '" + persNo + "'")) {
//            if (rs.next()) {
//                email = rs.getString("email");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return email;
//    }
}
