import java.util.Scanner;

public class ServiceOrderSystem {

    Scanner scanner = new Scanner(System.in);

    ServiceOrder[] orders = new ServiceOrder[100];

    int orderCount = 0;

    int nextOrderNumber = 1;


    public void run() {

        int choice;

        do {

            System.out.println();
            System.out.println("==============================================");
            System.out.println(" SERVICE ORDER AND MAINTENANCE TRACKING SYSTEM");
            System.out.println("==============================================");
            System.out.println("1. Create Service Order");
            System.out.println("2. View Service Orders");
            System.out.println("3. Update Job Status");
            System.out.println("4. Search Service Order");
            System.out.println("5. Maintenance Summary");
            System.out.println("6. Exit");
            System.out.println("==============================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    createOrder();
                    break;

                case 2:
                    viewOrders();
                    break;

                case 3:
                    updateStatus();
                    break;

                case 4:
                    searchOrder();
                    break;

                case 5:
                    summary();
                    break;

                case 6:
                    System.out.println();
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        scanner.close();
    }


    public void createOrder() {

        System.out.println();
        System.out.println("===== CREATE SERVICE ORDER =====");

        if (orderCount >= orders.length) {
            System.out.println("The system is full. Cannot create more orders.");
            return;
        }

        System.out.print("Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Contact Number: ");
        String contactNumber = scanner.nextLine();

        System.out.print("Service Type: ");
        String serviceType = scanner.nextLine();

        System.out.print("Problem: ");
        String problem = scanner.nextLine();

        System.out.print("Technician: ");
        String technician = scanner.nextLine();

        String orderNumber = "SO-" +
                String.format("%03d", nextOrderNumber);

        orders[orderCount] = new ServiceOrder(
                orderNumber,
                customerName,
                contactNumber,
                serviceType,
                problem,
                technician
        );

        orderCount++;
        nextOrderNumber++;

        System.out.println();
        System.out.println("Service order created successfully!");
        System.out.println("Order Number: " + orderNumber);
        System.out.println("Status: Pending");
    }


    public void viewOrders() {

        System.out.println();
        System.out.println("===== SERVICE ORDERS =====");

        if (orderCount == 0) {
            System.out.println("No service orders found.");
            return;
        }

        for (int i = 0; i < orderCount; i++) {

            System.out.println();
            System.out.println("Order " + (i + 1));

            orders[i].displayOrder();
        }
    }


    public void updateStatus() {

        System.out.println();
        System.out.println("===== UPDATE JOB STATUS =====");

        if (orderCount == 0) {
            System.out.println("No service orders found.");
            return;
        }

        System.out.print("Enter Order Number: ");
        String orderNumber = scanner.nextLine();

        for (int i = 0; i < orderCount; i++) {

            if (orders[i].getOrderNumber().equals(orderNumber)) {

                System.out.println();
                System.out.println("Select New Status:");
                System.out.println("1. Assigned");
                System.out.println("2. In Progress");
                System.out.println("3. Completed");
                System.out.println("4. Cancelled");

                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {

                    orders[i].setStatus("Assigned");

                } else if (choice == 2) {

                    orders[i].setStatus("In Progress");

                } else if (choice == 3) {

                    orders[i].setStatus("Completed");

                } else if (choice == 4) {

                    orders[i].setStatus("Cancelled");

                } else {

                    System.out.println("Invalid choice.");
                    return;
                }

                System.out.println();
                System.out.println("Job status updated successfully!");
                System.out.println("New Status: " + orders[i].getStatus());

                return;
            }
        }

        System.out.println("Order not found.");
    }


    public void searchOrder() {

        System.out.println();
        System.out.println("===== SEARCH SERVICE ORDER =====");

        if (orderCount == 0) {
            System.out.println("No service orders found.");
            return;
        }

        System.out.print("Enter Order Number: ");
        String orderNumber = scanner.nextLine();

        for (int i = 0; i < orderCount; i++) {

            if (orders[i].getOrderNumber().equals(orderNumber)) {

                System.out.println();
                System.out.println("===== ORDER FOUND =====");

                orders[i].displayOrder();

                return;
            }
        }

        System.out.println("Order not found.");
    }


    public void summary() {

        System.out.println();
        System.out.println("===== MAINTENANCE SUMMARY =====");

        int pending = 0;
        int assigned = 0;
        int inProgress = 0;
        int completed = 0;
        int cancelled = 0;

        for (int i = 0; i < orderCount; i++) {

            String status = orders[i].getStatus();

            if (status.equals("Pending")) {

                pending++;

            } else if (status.equals("Assigned")) {

                assigned++;

            } else if (status.equals("In Progress")) {

                inProgress++;

            } else if (status.equals("Completed")) {

                completed++;

            } else if (status.equals("Cancelled")) {

                cancelled++;
            }
        }

        System.out.println("Pending: " + pending);
        System.out.println("Assigned: " + assigned);
        System.out.println("In Progress: " + inProgress);
        System.out.println("Completed: " + completed);
        System.out.println("Cancelled: " + cancelled);

        System.out.println("-----------------------------");
        System.out.println("Total Orders: " + orderCount);
    }
}
