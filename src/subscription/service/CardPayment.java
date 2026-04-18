package subscription.service;

public class CardPayment extends PaymentInfo {

    String cardNumber;
    String cardHolderName;
    String expiryDate;

     public CardPayment(int amount, String cardNumber, String cardHolderName, String expiryDate) {
        this.amount = amount;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
    }
}
