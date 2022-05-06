package model;


import java.util.List;

public class Order {

    private int id;
    private int customerId;
    private int itemId;

    private Customer customer;
    private List<Item> items;

    public Order(){}

    public Order(int id, int customerId, int itemId) {
        this.id = id;
        this.customerId = customerId;
        this.itemId = itemId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", itemId=" + itemId +
                '}';
    }
}
