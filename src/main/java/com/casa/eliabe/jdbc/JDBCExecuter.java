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
            customer.setFirstName("Nelson");
            customer.setLastName("Rodrigues");
            customer.setEmail("n.rodrigues@email.com");
            customer.setAddress("000 Rua Nao Sei");
            customer.setCity("Rio de Janeiro Talvez");
            customer.setState("RJT");
            customer.setPhone("21977889973");
            customer.setZipCode("004587-789");

            Customer dbCustomer = customerDAO.create(customer);
            System.out.println(dbCustomer);
            dbCustomer = customerDAO.findById(dbCustomer.getId());
            System.out.println(dbCustomer);
            dbCustomer.setEmail("nelson.r@email.com");
            dbCustomer = customerDAO.update(dbCustomer);
            System.out.println(dbCustomer);
            customerDAO.delete(dbCustomer.getId());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
