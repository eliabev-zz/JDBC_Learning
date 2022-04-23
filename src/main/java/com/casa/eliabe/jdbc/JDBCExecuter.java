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
            Customer customer = new Customer();
            customer.setFirstName("Eduardo Carlos");
            customer.setLastName("Pereira de Magalhaes");
            customer.setEmail("eduardo.p@email.com");
            customer.setPhone("(55) 35 98765-4321");
            customer.setAddress("Rua Olimpia 37");
            customer.setState("MG");
            customer.setZipCode("08456-362");

            customerDAO.create(customer);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
