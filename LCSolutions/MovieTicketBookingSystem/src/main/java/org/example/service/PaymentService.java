package org.example.service;

import org.example.entity.PaymentType;
import org.example.strategy.CashStrategy;
import org.example.strategy.CreditCardStrategy;
import org.example.strategy.PaymentStrategy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PaymentService {

    Map<PaymentType, PaymentStrategy> strategyMap = new HashMap<>();
    public PaymentService(){
        strategyMap.put(PaymentType.CREDIT_CARD, new CreditCardStrategy());
        strategyMap.put(PaymentType.CASH, new CashStrategy());
    }

    public void payForTickets(double amount, PaymentType paymentType){
        strategyMap
                .get(paymentType)
                .makePayment();

    }
}
