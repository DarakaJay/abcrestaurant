// staffreg.js

document.getElementById('registration-form').addEventListener('submit', function(event) {
    event.preventDefault();

    // Display popup message
    const popup = document.getElementById('popup');
    popup.style.display = 'block';

    // Hide the popup after 3 seconds
    setTimeout(function() {
        popup.style.display = 'none';
    }, 3000);

    // Send the form data to the servlet
    sendPostRequest();
});

function sendPostRequest() {
    const url = '/abc_restaurant_v2/register'; // Ensure this URL matches your servlet's mapping

    // Collect form data
    const formData = new URLSearchParams();
    formData.append('name', document.getElementById('name').value);
    formData.append('email', document.getElementById('email').value);
    formData.append('password', document.getElementById('password').value);
    formData.append('role', document.getElementById('role').value); // Assuming you have a role field for staff

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
    })
    .catch(error => {
        console.error('Error:', error);
        // Handle the error
    });
}

// Cancel button redirects to home page
document.getElementById('cancel').addEventListener('click', function() {
    window.location.href = 'staffhome.html';
});
