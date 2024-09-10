
document.getElementById('rates-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const serviceType = document.getElementById('service').value;
    const date = document.getElementById('date').value;
    const time = document.getElementById('time').value;
    const guests = document.getElementById('guests').value;

    const selectedDateTime = new Date(`${date}T${time}`);

    const currentDateTime = new Date();

    let availabilityMessage = `Service: ${serviceType}\nDate: ${date}\nTime: ${time}\nGuests: ${guests}\n\n`;

    if (serviceType && date && time && guests) {
        if (selectedDateTime > currentDateTime) {
            availabilityMessage += "Status: Available";
            sendAvailabilityData(serviceType, date, time, guests, true);
        } else {
            availabilityMessage += "Status: Not Available";
            sendAvailabilityData(serviceType, date, time, guests, false);
        }
    } else {
        availabilityMessage += "Status: Not Available";
        sendAvailabilityData(serviceType, date, time, guests, false);
    }

    const resultDiv = document.getElementById('availability-result');
    resultDiv.textContent = availabilityMessage;
    resultDiv.classList.remove('hidden');
});

function sendAvailabilityData(serviceType, date, time, guests, isAvailable) {
    const url = '/abc_restaurant_v2/checkAvailability';

    const formData = new URLSearchParams();
    formData.append('serviceType', serviceType);
    formData.append('date', date);
    formData.append('time', time);
    formData.append('guests', guests);
    formData.append('isAvailable', isAvailable);

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
        console.log('Availability Check Success:', result);
    })
    .catch(error => {
        console.error('Availability Check Error:', error);
    });
}
