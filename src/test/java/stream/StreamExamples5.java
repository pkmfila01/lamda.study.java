package stream;

import static java.util.stream.Collectors.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

public class StreamExamples5 {
    public static void main(String[] args) {

        Product productA = new Product(1L, "A", new BigDecimal("10.00"));
        Product productB = new Product(2L, "B", new BigDecimal("20.50"));
        Product productC = new Product(3L, "C", new BigDecimal("60.00"));
        Product productD = new Product(4L, "D", new BigDecimal("17.00"));
        Product productE = new Product(5L, "E", new BigDecimal("150.00"));
        final List<Product> products = Arrays.asList(
                productA,
                productB,
                productC ,
                productD,
                productE
        );

        System.out.println(
                products.stream()
                .filter(product -> product.getPrice().compareTo(new BigDecimal("30.00")) > 0)
                .collect(toList())
        );

        System.out.println("\n=======================");
        System.out.println(
                IntStream.of(1, 2, 3, 4)
                .sum()
        );

        System.out.println("\n=======================");
        System.out.println("\n Total Price: " +
                           products.stream()
                                   .map(product -> product.getPrice())
                                   .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2))


        );
        System.out.println("\n=======================");
        System.out.println("\n filtered and count: " +
                           products.stream()
                                   .filter(product -> product.getPrice().compareTo(new BigDecimal("30.00")) > 0)
                                   .count()


        );
        System.out.println("\n=======================");
        Order order = new Order(1L, "on_1", Arrays.asList(
                new OrderItem(1L, productA, 1),
                new OrderItem(2L, productB, 2),
                new OrderItem(3L, productC, 3),
                new OrderItem(4L, productD, 4),
                new OrderItem(5L, productE, 5)
        ));
        System.out.println("\n orderedItems totalPrice: " +
                           order.getTotalPrice()
        );

    }

    @Data
    static class OrderItem {
        private Long id;
        private Product product;
        private int quantity;

        public OrderItem(Long id, Product product, int quantity) {
            this.id = id;
            this.product = product;
            this.quantity = quantity;
        }

        public BigDecimal getTotalPrice(){
            return product.getPrice().multiply(BigDecimal.valueOf(quantity));
        }
    }

    @Data
    static class Order {
        private Long id;
        private String orderNumber;
        private List<OrderItem> orderItems;

        public Order(Long id, String orderNumber,
                     List<OrderItem> orderItems) {
            this.id = id;
            this.orderNumber = orderNumber;
            this.orderItems = orderItems;
        }

        public BigDecimal getTotalPrice(){
            return orderItems.stream()
                             .map(orderItem -> orderItem.getTotalPrice())
                             .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2));
        }
    }
    @Data
    @AllArgsConstructor
    static class Product{
        private Long id;
        private String name;
        private BigDecimal price;
    }

    @ToString(callSuper = true)
    class DiscountedProduct extends Product {
        public DiscountedProduct(Long id, String name, BigDecimal price) {
            super(id, name, price);
        }
    }
}
