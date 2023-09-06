package org.example.strategy;

public class CashStrategy implements PaymentStrategy{
    @Override
    public void makePayment() {
        System.out.println("making payment via cash");
    }
}
