document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('payment-form');
    const cancelButton = document.getElementById('cancel-button');

    form.addEventListener('submit', (event) => {
        event.preventDefault();

        alert('Payment updated successfully');
    });

    cancelButton.addEventListener('click', () => {
        window.location.href = 'menu.html';
    });
});
