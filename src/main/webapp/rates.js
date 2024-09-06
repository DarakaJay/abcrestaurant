// Handle availability check
document.getElementById('rates-form').addEventListener('submit', function(event) {
    event.preventDefault();

    // Extract form data
    const serviceType = document.getElementById('service').value;
    const date = document.getElementById('date').value;
    const time = document.getElementById('time').value;
    const guests = document.getElementById('guests').value;

    // Combine date and time into a single Date object
    const selectedDateTime = new Date(`${date}T${time}`);

    // Get current date and time
    const currentDateTime = new Date();

    // Simulated availability check (Replace with actual server call)
    let availabilityMessage = `Service: ${serviceType}\nDate: ${date}\nTime: ${time}\nGuests: ${guests}\n\n`;

    if (serviceType && date && time && guests) {
        if (selectedDateTime > currentDateTime) {
            availabilityMessage += "Status: Available";
            // Send availability information to the server
            sendAvailabilityData(serviceType, date, time, guests, true);
        } else {
            availabilityMessage += "Status: Not Available";
            sendAvailabilityData(serviceType, date, time, guests, false);
        }
    } else {
        availabilityMessage += "Status: Not Available";
        sendAvailabilityData(serviceType, date, time, guests, false);
    }

    // Display the result
    const resultDiv = document.getElementById('availability-result');
    resultDiv.textContent = availabilityMessage;
    resultDiv.classList.remove('hidden');
});

function sendAvailabilityData(serviceType, date, time, guests, isAvailable) {
    const url = '/abc_restaurant_v2/checkAvailability'; // Ensure this URL matches your servlet's mapping

    // Collect availability data
    const formData = new URLSearchParams();
    formData.append('serviceType', serviceType);
    formData.append('date', date);
    formData.append('time', time);
    formData.append('guests', guests);
    formData.append('isAvailable', isAvailable);

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
        console.log('Availability Check Success:', result);
        // Handle the success response (e.g., display a message or update UI)
    })
    .catch(error => {
        console.error('Availability Check Error:', error);
        // Handle the error
    });
}
