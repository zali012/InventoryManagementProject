import dao.CustomerDAO;
import manager.CustomerManager;
import manager.ItemManager;
import manager.MenuManager;
import manager.OrderManager;
import model.Customer;
import model.Order;

import java.util.List;
import java.util.Scanner;

public class Main implements MenuManager {

    MenuManager customerManager = new CustomerManager();
    MenuManager itemManager = new ItemManager();
    OrderManager orderManager = new OrderManager();

    @Override
    public void showMenu() {
        String menu = "\n1.Customers\n" +
                "2.Items\n" +
                "3.Orders\n" +
                "4.Exit";

        System.out.println(menu);

        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();

        switch (in){

            case "1":
                customerManager.showMenu();

                showMenu();
                break;

            case "2":
                itemManager.showMenu();

                showMenu();
                break;

            case "3":
                orderManager.showMenu();

                showMenu();
                break;

            case "4":
                System.out.println("Thanks for using application!\nExiting now");
                System.exit(-1);
                break;
            default:
                System.out.println("Invalid input!. Try again\n");
                showMenu();

                break;
        }
    }

    public static void main(String[] args){

        Main main = new Main();
        main.showMenu();


    }


}
