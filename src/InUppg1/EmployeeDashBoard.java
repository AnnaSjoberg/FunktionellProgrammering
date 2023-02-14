package InUppg1;

import InUppg1.POJOs.*;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class EmployeeDashBoard {
    final Scanner sc = new Scanner(System.in);
    final Repository repo = new Repository();
    List<String> choices;
    final List<Order> allOrders = repo.getAllOrders();
    final List<Cartcontent> allCartcontent = repo.getAllCartContent();


    public EmployeeDashBoard() {

        while (true) {
            int reportNo = chooseReport();
            switch (reportNo) {
                case 1 -> {
                    System.out.println("Orders per Customer:");
                    printOrdersGroupedByCustomerName();
                }
                case 2 -> {
                    System.out.println("Sum of orders based on customer:");
                    printSpentSum(socSecNum);
                }
                case 3 -> {
                    System.out.println("Sum of orders based on Location:");
                    printSpentSum(Locale);
                }
                case 4 -> {
                    System.out.println("Items sold per product:");
                    printMostSoldProducts();
                }
                default -> System.exit(0);
            }
            System.out.println();
            System.out.println("Dou you want to review something else? (y/n)");
            String reply = sc.next().trim();
            if (!reply.equalsIgnoreCase("y")) {
                System.exit(0);
            }
        }
    }

    public int chooseReport() {
        choices = List.of("Orders per Customer.",
                "Sum of orders per Customer", "Sum of orders per Location", "Most sold Products");
        System.out.println("Which report do you want to review?");
        choices.stream().map(s -> (choices.indexOf(s) + 1) + " " + s).forEach(System.out::println);
        int reply = sc.nextInt();
        return reply;
    }

    public void printOrdersGroupedByCustomerName() {
        Map<String, List<Order>> result = allOrders.stream().collect(groupingBy(o -> o.getCustomer().getSocialSecurityNumber()));
        result.forEach((i, o) -> System.out.println(i + ": " + o.size()));
    }

    public void printMostSoldProducts() {
        Map<String, List<Cartcontent>> result = allCartcontent.stream().
                collect(groupingBy(cc -> cc.getProduct().reportString()));
        result.forEach((k, v) -> System.out.println("Items sold: "
                + result.get(k).stream().mapToInt(cc -> cc.getOrderedAmount()).sum() + "\t\t" + k));
    }

    public void printSpentSum(SpendingInterface si) {

        Map<String, List<Cartcontent>> result = allCartcontent.stream().
                collect(groupingBy(cc -> si.spender(cc)));
        result.forEach((k, v) -> System.out.println(k + ": " + result.get(k).stream().mapToInt
                (cc -> (cc.getProduct().getModel().getPrice() * cc.getOrderedAmount())).sum()));
    }

    SpendingInterface socSecNum = (cc) -> cc.getOrder().getCustomer().getSocialSecurityNumber();
    SpendingInterface Locale = (cc) -> cc.getOrder().getCustomer().getAddress();
}