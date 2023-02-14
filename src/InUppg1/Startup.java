package InUppg1;

import java.util.*;

public class Startup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Are you a Customer or an Employee? (c/e)");
            String reply = sc.nextLine().trim();

            if (reply.equalsIgnoreCase("c")) {
                CustomerDashBoard cdb = new CustomerDashBoard();
            }
            if (reply.equalsIgnoreCase("e")) {
                EmployeeDashBoard edb = new EmployeeDashBoard();
            }
            if (reply.equalsIgnoreCase("0")) {
                System.exit(0);
            }
        }

    }
}