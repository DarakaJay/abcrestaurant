// scripts.js




// meka hadanna ona availability eka

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
        } else {
            availabilityMessage += "Status: Not Available";
        }
    } else {
        availabilityMessage += "Status: Not Available";
    }

    // Display the result
    const resultDiv = document.getElementById('availability-result');
    resultDiv.textContent = availabilityMessage;
    resultDiv.classList.remove('hidden');
});
