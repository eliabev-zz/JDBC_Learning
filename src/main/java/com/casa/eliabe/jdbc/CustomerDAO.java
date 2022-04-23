package com.casa.eliabe.jdbc;

import com.casa.eliabe.jdbc.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CustomerDAO extends DataAccessObject<Customer> {

    private static final String INSERT = "INSERT INTO  customer (first_name, last_name, email, " +
            "phone, address, city, state, zipcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public CustomerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Customer findById(long id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer update(Customer dto) {
        return null;
    }

    @Override
    public Customer create(Customer dto) {
        try (PreparedStatement stmt = this.connection.prepareStatement(INSERT);){
            stmt.setString(1, dto.getFirstName());
            stmt.setString(2, dto.getLastName());
            stmt.setString(3, dto.getEmail());
            stmt.setString(4, dto.getPhone());
            stmt.setString(5, dto.getAddress());
            stmt.setString(6, dto.getCity());
            stmt.setString(7, dto.getState());
            stmt.setString(8, dto.getZipCode());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
