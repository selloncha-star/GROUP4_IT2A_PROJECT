public class ServiceOrder {

    private String orderNumber;
    private String customerName;
    private String contactNumber;
    private String serviceType;
    private String problem;
    private String technician;
    private String status;

    public ServiceOrder(String orderNumber, String customerName,
                        String contactNumber, String serviceType,
                        String problem, String technician) {

        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.serviceType = serviceType;
        this.problem = problem;
        this.technician = technician;

        this.status = "Pending";
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayOrder() {

        System.out.println("-----------------------------");
        System.out.println("Order Number: " + orderNumber);
        System.out.println("Customer: " + customerName);
        System.out.println("Contact: " + contactNumber);
        System.out.println("Service Type: " + serviceType);
        System.out.println("Problem: " + problem);
        System.out.println("Technician: " + technician);
        System.out.println("Status: " + status);
        System.out.println("-----------------------------");
    }
}