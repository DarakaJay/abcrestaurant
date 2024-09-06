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

    // Display popup message
    const popup = document.getElementById('popup');
    popup.style.display = 'block';

    // Hide the popup after 3 seconds
    setTimeout(function() {
        popup.style.display = 'none';
    }, 3000);

    // Send the form data to the servlet
    sendPaymentPostRequest();
});

function sendPaymentPostRequest() {
    const url = '/abc_restaurant_v2/payment'; // Ensure this URL matches your servlet's mapping

    // Collect payment details
    const formData = new URLSearchParams();
    formData.append('paymentMethod', document.querySelector('input[name="paymentMethod"]:checked').value);
    formData.append('reservationId', document.getElementById('reservation-id').value);
    formData.append('paymentDate', document.getElementById('payment-date').value);
    formData.append('amount', document.getElementById('amount').value);

    if (document.querySelector('input[name="paymentMethod"]:checked').value === 'Online Payment') {
        formData.append('cardNumber', document.getElementById('card-number').value);
        formData.append('cardExpiry', document.getElementById('card-expiry').value);
        formData.append('cardCVV', document.getElementById('card-cvv').value);
    }

    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded', // Sending data as form URL encoded
        },
        body: formData.toString(), // Convert form data to URL-encoded string
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json(); // Assuming the servlet returns a JSON response
    })
    .then(result => {
        console.log('Success:', result);
        // Handle the success response (e.g., display a message or redirect)
        alert('Payment Successful!');
    })
    .catch(error => {
        console.error('Error:', error);
        // Handle the error
        alert('Payment Failed!');
    });
}

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
