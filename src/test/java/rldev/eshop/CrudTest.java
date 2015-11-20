package rldev.eshop;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import rldev.eshop.configuration.AppConfiguration;
import rldev.eshop.controller.LoginBean;
import rldev.eshop.controller.TestBean;
import rldev.eshop.dao.CustomerDAO;
import rldev.eshop.entity.*;
import rldev.eshop.entity.enums.OrderStatus;
import rldev.eshop.service.CustomerDetailsService;
import rldev.eshop.service.CustomerService;
import rldev.eshop.service.OrderService;
import rldev.eshop.service.ProductService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ContextConfiguration(classes = AppConfiguration.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class CrudTest extends Assert {

    @Autowired private CustomerService customerService;
    @Autowired private OrderService orderService;
    @Autowired private ProductService productService;
    @Autowired private CustomerDetailsService customerDetailsService;
    @Autowired TestBean testBean;
    @Autowired LoginBean loginBean;
    @Autowired
    CustomerDAO customerDAO;

    @Ignore
    @Test
    @Rollback(value = false)
    public void testSaveCustomer() {
        for(int i = 0; i < 50; i++) {
            Customer customer = new Customer();
            customer.setFirstName("cFirstName" + i);
            customer.setLastName("cLastName" + i);
            customer.setAddress("cAddress" + i);
            customer.setPhoneNumber(Integer.toString(i));
            customerService.save(customer);
        }
    }

    @Ignore
    @Test
    @Rollback(value = false)
    public void deleteCustomers() {
        List<Customer> customers = customerService.readAll();
        for(Customer customer : customers) {
            System.out.println(customer.getLastName());
            //customerService.delete(customer);
        }
    }

    @Ignore
    @Test
    @Rollback(value = false)
    public void createAll(){
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer();
            customer.setId((long)1);
            customer.setFirstName("cFirstName" + i);
            customer.setLastName("cLastName" + i);
            customer.setAddress("cAddress" + i);
            customer.setPhoneNumber(Integer.toString(i));
            customerService.save(customer);

            Product product = new Product();
            product.setId((long)1);
            product.setName("product" + i);
            product.setBrandName("Brand");
            product.setDescription("desc" + i);
            product.setPrice(Math.random() * 100);
            productService.save(product);

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(productService.readById(Integer.toUnsignedLong(i)));
            orderItem.setQuantity((int )(Math.random() * 5));

            Order order = new Order();
            order.setCreationDate(new Timestamp(new Date().getTime()));
            order.setOrderStatus(OrderStatus.EXPECTED);
            order.setTotalCost(Math.random() * 1000);
            //order.setCustomer(customerService.readById((long)i));
            //order.addOrderItem(orderItem);
            //orderService.save(order);
        }
    }

    @Ignore
    @Test
    @Rollback(value = false)
    public void testXmlMapping() {
        Customer customer = new Customer();
        customer.setUsername("atticus");
        customer.setPassword("password");
        customer.setFirstName("cFirstName");
        customer.setLastName("cLastName");
        customer.setAddress("cAddress");
        customer.setPhoneNumber("+94894756");
        customerService.save(customer);

        Product product = new Product();
        product.setName("product");
        product.setBrandName("Brand");
        product.setDescription("desc");
        product.setPrice(Math.random() * 100);
        productService.save(product);
    }

    @Ignore
    @Test
    @Rollback(value = false)
    public void addOrder() {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(productService.readById((long) 1));
        orderItem.setQuantity((int) (Math.random() * 5));
        List<OrderItem> items = new ArrayList<OrderItem>();
        items.add(orderItem);

        Order order = new Order();
        order.setCreationDate(new Timestamp(new Date().getTime()));
        order.setOrderStatus(OrderStatus.EXPECTED);
        order.setTotalCost(Math.random() * 1000);
        order.setCustomer(customerService.readById((long) 1));
        order.setItems(items);
        orderService.save(order);
    }

    @Ignore
    @Test
    public void testFindByUsername() {
        Customer customer = customerService.findByUsername("atticus");
        assertTrue(customer.getPassword().equals("pass"));
    }

    @Ignore
    @Test
    public void loadUserSecurityTest() {
        String s = customerDetailsService.loadUserByUsername("LizardKing").getPassword();
        assertTrue(s.equals("jim"));
    }

    @Ignore
    @Test
    public void testBeanTest() {
        for (Object customer : testBean.getCustomers()) {
            System.out.println(customer);
        }
    }

    //@Ignore
    @Test
    public void loginBeanTest() {
        loginBean.setUsername("LizardKing");
        loginBean.setPassword("jim");
        System.out.println(loginBean.login());
    }

    @Ignore
    @Test
    public void getRolesByUserIdTest() {
        System.out.println(customerDAO.getRolesByUsername("LizardKing"));
    }

    @Ignore
    @Test
    public void findUserByUsername() {
        String username = customerDAO.findByUsername("LizardKing").getUsername();
        System.out.println(customerDAO.findByUsername("LizardKing"));
        assertTrue(username.equals("LizardKing"));
    }
}
