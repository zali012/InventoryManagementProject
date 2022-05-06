package dao;

import db.DbConnection;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements DAO<Customer>{

    @Override
    public void update(Customer customer){
        try
        {
            Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE customer SET name = ? WHERE id = ?") ;
            statement.setString(1, customer.getName());
            statement.setInt(2, customer.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> read() {
        List<Customer> customersModel = new ArrayList<>();

        try
        {
            Connection connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);

                customersModel.add(new Customer(id,name));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customersModel;
    }

    @Override
    public void print() {
        List<Customer> cutomerList = read();
        for(Customer customer:cutomerList)
            System.out.println(customer.toString());
    }


    @Override
    public void delete(int id) {
        try
        {
            Connection connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM customer WHERE id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Customer t) {
        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO customer(name) VALUES (?)");
            statement.setString(1, t.getName());
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
