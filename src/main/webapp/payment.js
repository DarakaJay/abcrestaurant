
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


document.getElementById('payment-form').addEventListener('submit', function(event) {
    event.preventDefault();


    const popup = document.getElementById('popup');
    popup.style.display = 'block';


    setTimeout(function() {
        popup.style.display = 'none';
    }, 3000);


    sendPaymentPostRequest();
});

function sendPaymentPostRequest() {
    const url = '/abc_restaurant_v2/payment';


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
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: formData.toString(),
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(result => {
        console.log('Success:', result);
        alert('Payment Successful!');
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Payment Failed!');
    });
}


function cancelPayment() {
    var confirmCancel = confirm('Are you sure you want to cancel the payment?');
    if (confirmCancel) {
        alert('Payment Cancelled');
    }
}

document.addEventListener('DOMContentLoaded', function() {
    document.querySelectorAll('input[name="paymentMethod"]').forEach(function(radio) {
        radio.addEventListener('change', toggleCardDetails);
    });
});
