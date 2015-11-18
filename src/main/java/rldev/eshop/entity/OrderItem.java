package rldev.eshop.entity;

import javax.persistence.*;

//@Embeddable
public class OrderItem {

    private Order order;
    private Product product;
    private int quantity;

    //@Column(name = "ORDER_ID")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    //@Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;

        OrderItem orderItem = (OrderItem) o;

        if (getQuantity() != orderItem.getQuantity()) return false;
        if (!getOrder().equals(orderItem.getOrder())) return false;
        return getProduct().equals(orderItem.getProduct());

    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + getOrder().hashCode();
        result = 31 * result + getProduct().hashCode();
        result = 31 * result + getQuantity();
        return result;
    }
}
