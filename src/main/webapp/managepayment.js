document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('payment-form');
    const cancelButton = document.getElementById('cancel-button');

    form.addEventListener('submit', (event) => {
        event.preventDefault(); // Prevent form from submitting normally

        // Perform any form validation or data processing here if needed

        // Show the success message
        alert('Payment updated successfully');
    });

    cancelButton.addEventListener('click', () => {
        window.location.href = 'menu.html'; // Redirect to the menu page
    });
});
