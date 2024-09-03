document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('query-form');

    form.addEventListener('submit', (event) => {
        event.preventDefault(); // Prevent form from submitting normally

        // Perform any form validation or data processing here if needed

        // Show the success message
        alert('Response sent successfully');

        // Optionally, you could clear the form fields after submission
        form.reset();
    });
});
