import java.util.*;

class Customer {
    String name;
    int unitsConsumed;

    Customer(String name, int unitsConsumed) {
        this.name = name;
        this.unitsConsumed = unitsConsumed;
    }
}

class LightbillManagementSystem {
    final int MAX_CUSTOMERS = 100;
    Customer[] customers;
    int customerCount;

    LightbillManagementSystem() {
        customers = new Customer[MAX_CUSTOMERS];
        customerCount = 0;
    }

    void addCustomer(String name, int unitsConsumed) {
        if (customerCount < MAX_CUSTOMERS) {
            customers[customerCount++] = new Customer(name, unitsConsumed);
            System.out.println("Customer added successfully!");
        } else {
            System.out.println("Maximum number of customers reached. Cannot add more customers.");
        }
    }

    void displayCustomers() {
        if (customerCount == 0) {
            System.out.println("No customers found.");
        } else {
            System.out.println("Customer List:");
            for (int i = 0; i < customerCount; i++) {
                System.out.println("Name: " + customers[i].name + ", Units Consumed: " + customers[i].unitsConsumed);
            }
        }
    }
    void calculateBill() {
        for (int i = 0; i < customerCount; i++) {
            double billAmount = customers[i].unitsConsumed * 5.0; // Assuming rate is 5.0 per unit
            System.out.println("Customer: " + customers[i].name + ", Bill Amount: $" + billAmount);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LightbillManagementSystem lightbillSystem = new LightbillManagementSystem();

        while (true) {
            System.out.println("1. Add Customer");
            System.out.println("2. Display Customers");
            System.out.println("3. Calculate Bills");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = sc.next();
                    System.out.print("Enter units consumed: ");
                    int unitsConsumed = sc.nextInt();
                    lightbillSystem.addCustomer(name, unitsConsumed);
                    break;

                case 2:
                    lightbillSystem.displayCustomers();
                    break;

                case 3:
                    lightbillSystem.calculateBill();
                    break;

                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}