package subscription;

import subscription.dto.Customer;
import subscription.dto.PaymentMethods;
import subscription.dto.ProductSubscription;

import java.util.List;

public interface PaymentService {

    List<ProductSubscription> getAllSubscription();

    List<PaymentMethods> fetchPaymentMethods();



    boolean processPayment(Customer customer, PaymentMethods paymentMethod, double amount);

    boolean updateCustomerSubscription(Customer customer, ProductSubscription subscription);





    boolean extendSubscription(int customerID, int subscriptionID);

    boolean cancelSubscription(int customerID, int subscriptionID);


}
