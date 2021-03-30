package functionalinterfece;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {

        // Normal Java Function
        Customer customer = new Customer("Anna", "32131242");
        greetCustomer(customer);

        // Consumer Functional Interface
        greetCustomerConsumer.accept(customer);

        greetCustomerConsumerV2.accept(customer, false);
    }

    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println("Hello customer "
            + customer.customerName + " for registering your phone number " + customer.customerPhoneNumber);

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber)
            -> System.out.println("Hello customer " + customer.customerName + " for registering your phone number "
            + (showPhoneNumber ? customer.customerPhoneNumber : "************"));

    static void greetCustomer(Customer customer) {
        System.out.println("Hello customer " + customer.customerName + " for registering your phone number "
                + customer.customerPhoneNumber);
    }

    static class Customer {

        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
