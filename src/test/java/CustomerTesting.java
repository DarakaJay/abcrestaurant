import static org.junit.Assert.*;

import org.junit.Test;
import com.abcresttaurant.model.Customer;

public class CustomerTesting {

    @Test
    public void testCustomerConstructorWithArgs() {
        int customerId = 1;
        String name = "Gihan Fernando";
        String email = "gihan@gmail.com";
        String password = "gihan123";

        Customer customer = new Customer(customerId, name, email, password);

        assertEquals(customerId, customer.getCustomerId());
        assertEquals(name, customer.getName());
        assertEquals(email, customer.getEmail());
        assertEquals(password, customer.getPassword());
    }

    @Test
    public void testCustomerDefaultConstructorAndSetters() {

        Customer customer = new Customer();

        customer.setCustomerId(1);
        customer.setName("Gihan Fernando");
        customer.setEmail("gihan@gmail.com");
        customer.setPassword("gihan123");

        assertEquals(1, customer.getCustomerId());
        assertEquals("Gihan Fernando", customer.getName());
        assertEquals("gihan@gmail.com", customer.getEmail());
        assertEquals("gihan123", customer.getPassword());
    }

    @Test
    public void testGettersAndSetters() {

        Customer customer = new Customer();

        customer.setCustomerId(3);
        customer.setName("Nethmi Gunarathna");
        customer.setEmail("nethmigunarathna@gmail.com");
        customer.setPassword("nethmi00");

        assertEquals(3, customer.getCustomerId());
        assertEquals("Nethmi Gunarathna", customer.getName());
        assertEquals("nethmigunarathna@gmail.com", customer.getEmail());
        assertEquals("nethmi00", customer.getPassword());
    }

    @Test
    public void testCustomerEmailSetter() {
        Customer customer = new Customer();
        String email = "test@example.com";

        customer.setEmail(email);

        assertEquals(email, customer.getEmail());
    }

    @Test
    public void testCustomerPasswordSetter() {
        Customer customer = new Customer();
        String password = "newPassword123";

        customer.setPassword(password);

        assertEquals(password, customer.getPassword());
    }
}



