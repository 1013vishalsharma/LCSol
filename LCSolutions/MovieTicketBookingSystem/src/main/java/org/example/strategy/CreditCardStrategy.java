package org.example.strategy;

public class CreditCardStrategy implements PaymentStrategy{
    @Override
    public void makePayment() {
        System.out.println("making payment via credit card");
    }
}
