document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('query-form');

    form.addEventListener('submit', (event) => {
        event.preventDefault();

        alert('Response sent successfully');

        form.reset();
    });
});
