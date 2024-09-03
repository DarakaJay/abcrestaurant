package com.abcresttaurant.service;

import java.sql.SQLException;
import java.util.List;

import com.abcresttaurant.dao.PaymentDAO;
import com.abcresttaurant.model.Payment;

public class PaymentService {
	
	private static PaymentService instance;
    private PaymentDAO paymentDAO;

    private PaymentService() {
        this.paymentDAO = new PaymentDAO();
    }

    public static PaymentService getInstance() {
        if (instance == null) {
            synchronized (PaymentService.class) {
                if (instance == null) {
                    instance = new PaymentService();
                }
            }
        }
        return instance;
    }

    public void addPayment(Payment payment) {
        paymentDAO.addPayment(payment);
    }

    public List<Payment> getAllPayments() throws SQLException {
        return paymentDAO.getAllPayments();
    }

    public Payment getPaymentByReservationId(int reservationId) throws SQLException {
        return paymentDAO.getPaymentByReservationId(reservationId);
    }

}
