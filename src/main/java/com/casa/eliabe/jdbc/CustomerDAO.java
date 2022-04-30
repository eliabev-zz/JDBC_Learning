package com.casa.eliabe.jdbc;

import com.casa.eliabe.jdbc.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerDAO extends DataAccessObject<Customer> {

    private static final String INSERT = "INSERT INTO  customer (first_name, last_name, email, " +
            "phone, address, city, state, zipcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String GET_ONE = "SELECT customer_id, first_name, last_name, email, " +
            "phone, address, city, state, zipcode FROM customer WHERE customer_id = ?" ;

    private static final String UPDATE = "UPDATE customer SET first_name = ?, " +
            "last_name = ?, email = ?, phone = ?, address = ?, city = ?, state = ?, zipcode = ? WHERE customer_id = ?";

    private static final String DELETE = "DELETE FROM customer WHERE customer_id = ?";

    public CustomerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Customer findById(long id) {
        Customer customer = new Customer();
        try (PreparedStatement stmt = this.connection.prepareStatement(GET_ONE)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                customer.setId(rs.getLong("customer_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getString("phone"));
                customer.setAddress(rs.getString("address"));
                customer.setCity(rs.getString("city"));
                customer.setState(rs.getString("state"));
                customer.setZipCode(rs.getString("zipcode"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer update(Customer dto) {
        Customer customer = null;
        try(PreparedStatement stmt = this.connection.prepareStatement(UPDATE)) {
            stmt.setString(1, dto.getFirstName());
            stmt.setString(2, dto.getLastName());
            stmt.setString(3, dto.getEmail());
            stmt.setString(4, dto.getPhone());
            stmt.setString(5, dto.getAddress());
            stmt.setString(6, dto.getCity());
            stmt.setString(7, dto.getState());
            stmt.setString(8, dto.getZipCode());
            stmt.setLong(9, dto.getId());
            stmt.execute();
            customer = this.findById(dto.getId());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return customer;
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
            long id = this.getLastVal(CUSTOMER_SEQUENCE);
            return this.findById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {
        try (PreparedStatement statement = this.connection.prepareStatement(DELETE);) {
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
