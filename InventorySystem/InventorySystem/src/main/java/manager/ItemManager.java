package manager;

import dao.ItemDAO;
import model.Customer;
import model.Item;

import java.util.List;
import java.util.Scanner;

public class ItemManager implements MenuManager{

    ItemDAO itemDAO = new ItemDAO();

    @Override
    public void showMenu() {

        String menu = "\n\n1.CREATE item\n" +
                "2.UPDATE item\n" +
                "3.READ items\n" +
                "4.DELETE item\n" +
                "5.Back Menu\n";

        System.out.println(menu);

        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();

        switch (in){

            case "1":

                System.out.println("Please enter name");
                String name = scanner.nextLine();
                System.out.println("Please enter value");
                String value = scanner.nextLine();
                itemDAO.create(new Item(name,value));
                System.out.println("Item created");

                showMenu();
                break;

            case "2":

                System.out.println("Please enter the id of the Item which needs to be updated");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Please enter name");
                name = scanner.nextLine();
                System.out.println("Please enter value");
                value = scanner.nextLine();
                itemDAO.update(new Item(id,name,value));
                System.out.println("Item Updated");

                showMenu();
                break;

            case "3":

                itemDAO.print();
                showMenu();
                break;

            case "4":
                System.out.println("Please enter the id of the item which needs to be deleted");
                id = Integer.parseInt(scanner.nextLine());

                itemDAO.delete(id);
                System.out.println("Item deleted");
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
