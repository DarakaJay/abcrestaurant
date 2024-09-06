import static org.junit.Assert.*;

import org.junit.Test;
import com.abcresttaurant.model.Payment;

public class PaymentTesting {

    @Test
    public void testPaymentConstructorWithArgs() {
        int paymentId = 201;
        int reservationId = 101;
        double amount = 1500.00;
        String paymentDate = "2024-09-05";
        String paymentMethod = "Credit Card";

        Payment payment = new Payment(paymentId, reservationId, amount, paymentDate, paymentMethod);

        assertEquals(paymentId, payment.getPaymentId());
        assertEquals(reservationId, payment.getReservationId());
        assertEquals(amount, payment.getAmount(), 0.001);
        assertEquals(paymentDate, payment.getPaymentDate());
        assertEquals(paymentMethod, payment.getPaymentMethod());
    }

    @Test
    public void testPaymentDefaultConstructorAndSetters() {
        Payment payment = new Payment();

        payment.setPaymentId(202);
        payment.setReservationId(102);
        payment.setAmount(2000.00);
        payment.setPaymentDate("2024-09-06");
        payment.setPaymentMethod("PayPal");

        assertEquals(202, payment.getPaymentId());
        assertEquals(102, payment.getReservationId());
        assertEquals(2000.00, payment.getAmount(), 0.001);
        assertEquals("2024-09-06", payment.getPaymentDate());
        assertEquals("PayPal", payment.getPaymentMethod());
    }

    @Test
    public void testGettersAndSetters() {
        Payment payment = new Payment();

        payment.setPaymentId(203);
        payment.setReservationId(103);
        payment.setAmount(3500.00);
        payment.setPaymentDate("2024-09-07");
        payment.setPaymentMethod("Cash");

        assertEquals(203, payment.getPaymentId());
        assertEquals(103, payment.getReservationId());
        assertEquals(3500.00, payment.getAmount(), 0.001);
        assertEquals("2024-09-07", payment.getPaymentDate());
        assertEquals("Cash", payment.getPaymentMethod());
    }

    @Test
    public void testPaymentDateSetter() {
        Payment payment = new Payment();
        String paymentDate = "2024-09-08";

        payment.setPaymentDate(paymentDate);

        assertEquals(paymentDate, payment.getPaymentDate());
    }

    @Test
    public void testPaymentMethodSetter() {
        Payment payment = new Payment();
        String paymentMethod = "Bank Transfer";

        payment.setPaymentMethod(paymentMethod);

        assertEquals(paymentMethod, payment.getPaymentMethod());
    }
}



