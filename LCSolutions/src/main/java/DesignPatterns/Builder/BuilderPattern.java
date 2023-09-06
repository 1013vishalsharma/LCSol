package DesignPatterns.Builder;

import java.time.LocalDateTime;

enum OrderType {
    REGULAR,
    RENEWAL,
    RETURN
}

enum InternalType {
    TYPE1,
    TYPE2
}
class Order {
    String id;
    OrderType orderType;
    String offer;
    LocalDateTime renewalDate;
    boolean isNewOrder;

    private Order(Builder builder) {
        this.isNewOrder = builder.isNewOrder;
        this.orderType = builder.orderType;
        this.renewalDate = builder.renewalDate;
        this.id = builder.id;
        this.offer = builder.offer;
    }

    public static class Builder {
        private String id;
        private OrderType orderType;
        private String offer;
        private LocalDateTime renewalDate;
        private boolean isNewOrder;

        public Builder(){}

        public Builder id(String id){
            this.id = id;
            return this;
        }
        public Builder orderType(OrderType orderType){
            this.orderType = orderType;
            return this;
        }
        public Builder offer(String offer){
            this.offer = offer;
            return this;
        }
        public Builder renewalDate(LocalDateTime renewalDate){
            this.renewalDate = renewalDate;
            return this;
        }
        public Builder isNewOrder(boolean isNewOrder){
            this.isNewOrder = isNewOrder;
            return this;
        }

        public Order build(){
            return new Order(this);
        }
    }
}
public class BuilderPattern {

    public static void main(String[] args) {
        Order order = new Order.Builder()
                .id("order-id-1")
                .isNewOrder(true)
                .orderType(OrderType.REGULAR)
                .renewalDate(LocalDateTime.now())
                .build();

        Order.Builder builder1 = new Order.Builder()
                .id("order-id-1")
                .isNewOrder(true)
                .orderType(OrderType.REGULAR);

        Order o1 = builder1.build();
         builder1.id("order 3 kardeya");
        System.out.println(o1.id);

        Order.Builder builder2 = new Order.Builder()
                .id("order-id-2")
                .isNewOrder(false)
                .orderType(OrderType.RENEWAL);

        //System.out.println(order.id + ", " + order.renewalDate + ", " + order.orderType);
    }
}
