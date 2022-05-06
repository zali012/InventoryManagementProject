package dao;

import db.DbConnection;
import model.Item;
import model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderDAO implements DAO<Order>{

    @Override
    public void create(Order t) {
        Random random = new Random();
        int order_id = random.nextInt(100000);

        List<Item> itemList = t.getItems();

        for(Item item: itemList) {
            try {
                Connection connection = DbConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement("Insert INTO Orders(order_id,customer_id,item_id) VALUES (?, ?,?)");
                statement.setInt(1, order_id);
                statement.setInt(2, t.getCustomer().getId());
                statement.setInt(3, item.getId());
                statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Order t) {

    }

    @Override
    public void delete(int t) {
        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Orders WHERE order_id = ?");
            statement.setLong(1, t);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> read(){
        List<Order> orderList = new ArrayList<>();

        try
        {
            Connection connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int cust_id = Integer.parseInt(resultSet.getString(2));
                int order_id= Integer.parseInt(resultSet.getString(3));

                orderList.add(new Order(id,cust_id,order_id));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public void print() {
        List<Order> orders = read();
        for(Order order:orders)
            System.out.println(order.toString());
    }

    public void addItemInOrder(int order_id, List<Item> itemList) {
        int custId = 0;
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Orders where order_id=?");
            statement.setInt(1,order_id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                custId = Integer.parseInt(resultSet.getString("customer_id"));
            }
            

            for(Item item: itemList) {
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("Insert INTO Orders(order_id,customer_id,item_id) VALUES (?, ?,?)");
                    preparedStatement.setInt(1, order_id);
                    preparedStatement.setInt(2, custId);
                    preparedStatement.setInt(3, item.getId());
                    preparedStatement.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public void removeItemsFromOrder(int order_id, List<Item> itemList) {
        try {
            Connection connection = DbConnection.getConnection();
            for(Item item: itemList) {
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Orders WHERE order_id=? AND item_id=?");
                    preparedStatement.setInt(1, order_id);
                    preparedStatement.setInt(2, item.getId());
                    preparedStatement.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
