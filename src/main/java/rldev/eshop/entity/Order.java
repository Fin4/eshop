package rldev.eshop.entity;

import rldev.eshop.entity.enums.OrderStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//@Entity
//@Table(name = "ORDERS", schema = "ESHOP")
public class Order {

    private Long id;
    private Customer customer;
    private List<OrderItem> items;
    private Date creationDate;
    private double totalCost;
    private OrderStatus orderStatus;

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name="id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //@ManyToOne
    //@JoinColumn(name = "CUSTOMER_ID", nullable = false, insertable = true)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    //@ElementCollection
    //@CollectionTable(name = "ORDER_ITEMS", schema = "ESHOP",
            //joinColumns = @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID"))
    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    //@Temporal(TemporalType.TIMESTAMP)
    //@Column(name="CREATION_DATE")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    //@Enumerated(EnumType.STRING)
    //@Column(name = "ORDER_STATUS")
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    //@Column(name = "TOTAL_COST")
    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public boolean addOrderItem(OrderItem orderItem) {
        return items.add(orderItem);
    }
}
