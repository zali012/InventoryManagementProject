package manager;

import dao.CustomerDAO;
import model.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerManager implements MenuManager{

    CustomerDAO customerDAO = new CustomerDAO();

    @Override
    public void showMenu() {

        String menu = "\n\n1.CREATE customer\n" +
                "2.UPDATE customer\n" +
                "3.READ customer\n" +
                "4.DELETE customer\n" +
                "5.Back Menu\n";

        System.out.println(menu);

        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();

        switch (in){

            case "1":

                System.out.println("Please enter name");
                String name = scanner.nextLine();
                customerDAO.create(new Customer(name));
                System.out.println("Customer created");

                showMenu();
                break;

            case "2":

                System.out.println("Please enter the id of the customer which needs to be updated");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Please enter name");
                name = scanner.nextLine();
                customerDAO.update(new Customer(id, name));
                System.out.println("Customer Updated");

                showMenu();
                break;

            case "3":
                customerDAO.print();

                showMenu();
                break;

            case "4":
                System.out.println("Please enter the id of the customer which needs to be deleted");
                id = Integer.parseInt(scanner.nextLine());

                customerDAO.delete(id);
                System.out.println("Customer deleted");
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
