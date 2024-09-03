// Toggle visibility of card details section
function toggleCardDetails() {
    var paymentMethod = document.querySelector('input[name="paymentMethod"]:checked').value;
    var cardDetails = document.getElementById('card-details');
    var paymentDetails = document.querySelector('.payment-details');

    if (paymentMethod === 'Online Payment') {
        cardDetails.style.display = 'block';
    } else {
        cardDetails.style.display = 'none';
    }
    paymentDetails.style.display = 'block';
}

// Handle payment form submission
document.getElementById('payment-form').addEventListener('submit', function(event) {
    event.preventDefault();

    // Collect payment details
    var paymentMethod = document.querySelector('input[name="paymentMethod"]:checked').value;
    var reservationId = document.getElementById('reservation-id').value;
    var paymentDate = document.getElementById('payment-date').value;
    var amount = document.getElementById('amount').value;

    // Display the collected information
    alert('Payment Confirmed!\n\n' +
          'Payment Method: ' + paymentMethod + '\n' +
          'Reservation ID: ' + reservationId + '\n' +
          'Payment Date: ' + paymentDate + '\n' +
          'Amount: ' + amount);

    // Further logic for handling payment processing can be added here
});

// Handle payment cancellation
function cancelPayment() {
    var confirmCancel = confirm('Are you sure you want to cancel the payment?');
    if (confirmCancel) {
        // Logic to cancel payment can be added here
        alert('Payment Cancelled');
    }
}

// Initialize the form to ensure correct initial display
document.addEventListener('DOMContentLoaded', function() {
    document.querySelectorAll('input[name="paymentMethod"]').forEach(function(radio) {
        radio.addEventListener('change', toggleCardDetails);
    });
});
