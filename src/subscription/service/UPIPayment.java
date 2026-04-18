package subscription.service;

public class UPIPayment extends PaymentInfo {

    String upiId;

     public UPIPayment(int amount, String upiId) {
        this.amount = amount;
        this.upiId = upiId;
    }
}
