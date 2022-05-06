package manager;

import dao.CustomerDAO;
import dao.ItemDAO;
import dao.OrderDAO;
import model.Customer;
import model.Item;
import model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManager implements MenuManager{

    OrderDAO orderDAO = new OrderDAO();

    @Override
    public void showMenu() {

        String menu = "\n\n1.CREATE order\n" +
                "2.UPDATE order\n" +
                "3.READ order\n" +
                "4.DELETE order\n" +
                "5.Back Menu\n";

        System.out.println(menu);

        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();

        switch (in){

            case "1":

                CustomerDAO customerDAO = new CustomerDAO();
                customerDAO.print();

                System.out.println("Please choose customer id from above Customers");
                int customerId = Integer.parseInt(scanner.nextLine());


                ItemDAO itemDAO = new ItemDAO();
                itemDAO.print();

                List<Item> itemsList = new ArrayList<>();

                System.out.println("Please choose item id from above Items and press quit to stop adding items in order");
                String choice = scanner.nextLine();
                while (!choice.equalsIgnoreCase("quit")){

                    itemsList.add(new Item(Integer.parseInt(choice)));

                    System.out.println("\nItem with "+choice+" added to orders");

                    System.out.println("Please choose item id from above Items and press quit to stop adding items in order");
                    choice = scanner.nextLine();
                }

                Order order = new Order();
                order.setCustomer(new Customer(customerId));
                order.setItems(itemsList);

                orderDAO.create(order);
                System.out.println("Order created");

                showMenu();
                break;

            case "2":

                System.out.println("\na.ADD items in existing order\n" +
                        "b.REMOVE items from existing order\n");

                String updateChoice = scanner.nextLine();

                itemsList = new ArrayList<>();

                if(updateChoice.equalsIgnoreCase("a")){
                    System.out.println("Please enter the id of the order which needs to be updated");
                    int order_id = Integer.parseInt(scanner.nextLine());

                    itemDAO = new ItemDAO();
                    itemDAO.print();

                    System.out.println("Please choose item id from above Items and press quit to stop adding items in order");
                    choice = scanner.nextLine();
                    while (!choice.equalsIgnoreCase("quit")){

                        itemsList.add(new Item(Integer.parseInt(choice)));

                        System.out.println("\nItem with "+choice+" added to orders");

                        System.out.println("Please choose item id from above Items and press quit to stop adding items in order");
                        choice = scanner.nextLine();
                    }

                    orderDAO.addItemInOrder(order_id,itemsList);
                    System.out.println("Order created");


                }else if(updateChoice.equalsIgnoreCase("b")){

                    System.out.println("Please enter the id of the order which needs to be updated");
                    int order_id = Integer.parseInt(scanner.nextLine());

                    itemDAO = new ItemDAO();
                    itemDAO.print();

                    System.out.println("Please choose item id from above Items and press quit to stop removing items in order");
                    choice = scanner.nextLine();
                    while (!choice.equalsIgnoreCase("quit")){

                        itemsList.add(new Item(Integer.parseInt(choice)));

                        System.out.println("\nItem with "+choice+" removed from orders");

                        System.out.println("Please choose item id from above Items and press quit to stop removing items in order");
                        choice = scanner.nextLine();
                    }

                    orderDAO.removeItemsFromOrder(order_id,itemsList);
                    System.out.println("Order updated");


                }
                showMenu();
                break;

            case "3":
                orderDAO.print();
                showMenu();
                break;

            case "4":
                System.out.println("Please enter the id of the order which needs to be deleted");
                int id = Integer.parseInt(scanner.nextLine());

                orderDAO.delete(id);
                System.out.println("Order deleted");
                showMenu();
                break;

            case "5":
                return;

            default:
                System.out.println("Invalid input!. Try again\n");
                showMenu();
                break;

        }

    }

}
