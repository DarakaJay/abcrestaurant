document.addEventListener("DOMContentLoaded", function() {
    const reservationForm = document.getElementById("reservation");
    const popup = document.getElementById("popup");
    const closePopupButton = document.getElementById("close-popup");
    const cancelButton = document.getElementById("cancel");

    // Handle reservation form submission
    reservationForm.addEventListener("submit", function(event) {
        event.preventDefault(); // Prevents the default form submission

        // Display the popup message
        popup.style.display = "flex"; // Shows the popup

        // Send the reservation form data to the servlet
        sendReservationPostRequest();
    });

    // Close the popup and reset the form
    closePopupButton.addEventListener("click", function() {
        popup.style.display = "none"; // Hides the popup
        reservationForm.reset(); // Resets the form fields
    });

    // Handle reservation cancellation
    cancelButton.addEventListener("click", function() {
        window.location.href = "home.html"; // Redirects to the home page
    });
});

function sendReservationPostRequest() {
    const url = '/abc_restaurant_v2/reserve'; // Ensure this URL matches your servlet's mapping

    // Collect reservation form data
    const formData = new URLSearchParams();
    formData.append('customerName', document.getElementById('customerName').value);
    formData.append('reservationDate', document.getElementById('reservationDate').value);
    formData.append('reservationTime', document.getElementById('reservationTime').value);
    formData.append('numberOfGuests', document.getElementById('numberOfGuests').value);
    formData.append('specialRequests', document.getElementById('specialRequests').value);

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
        alert('Reservation Successful!');
    })
    .catch(error => {
        console.error('Error:', error);
        // Handle the error
        alert('Reservation Failed!');
    });
}
