import dao.CustomerDAO;
import dao.ItemDAO;
import dao.OrderDAO;
import db.DbConnection;
import model.Customer;
import model.Item;
import model.Order;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class InventorySystemTest {

    @Test
    public void ATest(){
        try {
            DbConnection.getConnection();
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }


    @Test
    public void BTest(){
        try {
            CustomerDAO customerDAO = new CustomerDAO();
            customerDAO.create(new Customer("user-2"));
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void CTest(){
        try {
            CustomerDAO customerDAO = new CustomerDAO();
            List<Customer> customerList = customerDAO.read();
            int length = customerList.size()-1;
            customerDAO.delete(customerList.get(length).getId());

            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void DTest(){
        try {
            ItemDAO itemDAO = new ItemDAO();
            itemDAO.create(new Item("item-1","40"));
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void ETest(){
        try {
            ItemDAO itemDAO = new ItemDAO();
            List<Item> itemList = itemDAO.read();
            int length = itemList.size()-1;
            itemDAO.delete(itemList.get(length).getId());

            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void FTest(){
        try{

            ItemDAO itemDAO = new ItemDAO();
            List<Item> itemList = itemDAO.read();

            CustomerDAO customerDAO = new CustomerDAO();
            List<Customer> customerList = customerDAO.read();

            int customerLength = customerList.size()-1;

            OrderDAO orderDAO = new OrderDAO();
            Order order = new Order();
            order.setItems(itemList);
            order.setCustomer(customerList.get(customerLength));

            orderDAO.create(order);

            Assert.assertTrue(true);
        }catch (Exception ex){
            Assert.assertTrue(false);
        }
    }

}
