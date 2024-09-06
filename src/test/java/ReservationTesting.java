import static org.junit.Assert.*;

import org.junit.Test;
import com.abcresttaurant.model.Reservation;

public class ReservationTesting {

    @Test
    public void testReservationConstructorWithArgs() {
        int reservationId = 101;
        String customerName = "Gihan Fernando";
        String reservationDate = "2024-09-05";
        int numberOfPeople = 4;

        Reservation reservation = new Reservation(reservationId, customerName, reservationDate, numberOfPeople);

        assertEquals(reservationId, reservation.getReservationId());
        assertEquals(customerName, reservation.getCustomerName());
        assertEquals(reservationDate, reservation.getReservationDate());
        assertEquals(numberOfPeople, reservation.getNumberOfPeople());
    }

    @Test
    public void testReservationDefaultConstructorAndSetters() {
        Reservation reservation = new Reservation();

        reservation.setReservationId(102);
        reservation.setCustomerName("Nethmi Gunarathna");
        reservation.setReservationDate("2024-09-06");
        reservation.setNumberOfPeople(3);

        assertEquals(102, reservation.getReservationId());
        assertEquals("Nethmi Gunarathna", reservation.getCustomerName());
        assertEquals("2024-09-06", reservation.getReservationDate());
        assertEquals(3, reservation.getNumberOfPeople());
    }

    @Test
    public void testGettersAndSetters() {
        Reservation reservation = new Reservation();

        reservation.setReservationId(103);
        reservation.setCustomerName("Kasun Perera");
        reservation.setReservationDate("2024-09-07");
        reservation.setNumberOfPeople(5);

        assertEquals(103, reservation.getReservationId());
        assertEquals("Kasun Perera", reservation.getCustomerName());
        assertEquals("2024-09-07", reservation.getReservationDate());
        assertEquals(5, reservation.getNumberOfPeople());
    }

    @Test
    public void testReservationDateSetter() {
        Reservation reservation = new Reservation();
        String reservationDate = "2024-09-08";

        reservation.setReservationDate(reservationDate);

        assertEquals(reservationDate, reservation.getReservationDate());
    }

    @Test
    public void testReservationNumberOfPeopleSetter() {
        Reservation reservation = new Reservation();
        int numberOfPeople = 6;

        reservation.setNumberOfPeople(numberOfPeople);

        assertEquals(numberOfPeople, reservation.getNumberOfPeople());
    }
}


