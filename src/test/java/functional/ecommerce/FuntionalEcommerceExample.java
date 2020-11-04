package functional.ecommerce;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

public class FuntionalEcommerceExample {
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

        BigDecimal total = BigDecimal.ZERO;
        for (Product product : products) {
            total = total.add(product.getPrice());
        }
        System.out.println("total price : " + total);
        System.out.println("function price: " + totalPrice(products, product -> product.getPrice()));

        Order order = new Order(1L, "no_1", Arrays.asList(
                new OrderItem(1L, productA, 1),
                new OrderItem(2L, productB, 4),
                new OrderItem(3L, productD, 1),
                new OrderItem(4L, productE, 9)
        ));

        BigDecimal orderedTotal = totalPrice(order.getOrderItems(), orderItem -> orderItem.total());
        System.out.println(" new way total : " + orderedTotal);

        BigDecimal oldWayTotal = BigDecimal.ZERO;
        for (OrderItem orderItem : order.getOrderItems()) {
            oldWayTotal = oldWayTotal.add(orderItem.getProduct().getPrice().multiply(new BigDecimal(orderItem.quantity)));
        }
        System.out.println(" old way total : " + oldWayTotal);

    }

    public static <T> BigDecimal totalPrice(List<T> list, Function<T, BigDecimal> funtion){
        BigDecimal total = BigDecimal.ZERO;
        for (T t : list) {
            total = total.add(funtion.apply(t));
        }
        return total;
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

        public BigDecimal total(){
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

    }


    @Data
    @AllArgsConstructor
    static class Product{
        private Long id;
        private String name;
        private BigDecimal price;
    }

    @ToString(callSuper = true)
    class DiscountedProduct extends Product{
        public DiscountedProduct(Long id, String name, BigDecimal price) {
            super(id, name, price);
        }
    }
}

