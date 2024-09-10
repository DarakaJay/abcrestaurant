document.addEventListener("DOMContentLoaded", function() {
    const reservationForm = document.getElementById("reservation");
    const popup = document.getElementById("popup");
    const closePopupButton = document.getElementById("close-popup");
    const cancelButton = document.getElementById("cancel");

    reservationForm.addEventListener("submit", function(event) {
        event.preventDefault();

        popup.style.display = "flex";

        sendReservationPostRequest();
    });

    closePopupButton.addEventListener("click", function() {
        popup.style.display = "none";
        reservationForm.reset();
    });

    cancelButton.addEventListener("click", function() {
        window.location.href = "home.html";
    });
});

function sendReservationPostRequest() {
    const url = '/abc_restaurant_v2/reserve';

    const formData = new URLSearchParams();
    formData.append('customerName', document.getElementById('customerName').value);
    formData.append('reservationDate', document.getElementById('reservationDate').value);
    formData.append('reservationTime', document.getElementById('reservationTime').value);
    formData.append('numberOfGuests', document.getElementById('numberOfGuests').value);
    formData.append('specialRequests', document.getElementById('specialRequests').value);

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
        alert('Reservation Successful!');
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Reservation Failed!');
    });
}
