package InUppg1;

import InUppg1.POJOs.Purchase;
import InUppg1.POJOs.Customer;
import InUppg1.POJOs.Model;
import InUppg1.POJOs.Product;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Startup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    while(true) {
        System.out.println("Are you a Customer or an Employee? (c/e)");
        String reply = sc.nextLine().trim();

        if (reply.equalsIgnoreCase("c")) {
            CustomerDashBoard cdb = new CustomerDashBoard();
        }
        if (reply.equalsIgnoreCase("e")) {
            EmployeeDashBoard edb = new EmployeeDashBoard();
        }
    }

    }


}