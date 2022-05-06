package dao;

import db.DbConnection;
import model.Customer;
import model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO implements DAO<Item>{
    @Override
    public void create(Item t) {
        try{
            Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("Insert INTO item(item_name,item_value) VALUES (?, ?)");
            statement.setString(1, t.getName());
            statement.setString(2, t.getValue());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Item t) {
        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE item SET item_name = ?, item_value = ? WHERE item_id = ?");
            statement.setString(1, t.getName());
            statement.setString(2, t.getValue());
            statement.setInt(3, t.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int t) {
        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM item WHERE item_id = ?");
            statement.setLong(1, t);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> read() {
        List<Item> itemsList = new ArrayList<>();

        try
        {
            Connection connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM item");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String value = resultSet.getString(3);

                itemsList.add(new Item(id,name,value));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return itemsList;
    }

    @Override
    public void print() {
        List<Item> tems = read();
        for(Item item: tems)
            System.out.println(item.toString());
    }
}
