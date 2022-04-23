package com.casa.eliabe.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecuter {
    public static void main(String[] args) {
        DataBaseConnectionManager dcm = new DataBaseConnectionManager("localhost",
                "hplussport", "postgres", "password");
        try {
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            Customer customer = customerDAO.findById(10000);
            System.out.println(customer.getFirstName() +" "+ customer.getLastName() +" "+ customer.getEmail());
            customer.setEmail("eduardo.pm@reverendosegramaticosassociation.com");
            customer = customerDAO.update(customer);
            System.out.println(customer.getFirstName() +" "+ customer.getLastName() +" "+ customer.getEmail());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
