document.addEventListener("DOMContentLoaded", function() {
    const reservationForm = document.getElementById("reservation");
    const popup = document.getElementById("popup");
    const closePopupButton = document.getElementById("close-popup");
    const cancelButton = document.getElementById("cancel");

    reservationForm.addEventListener("submit", function(event) {
        event.preventDefault(); // Prevents the default form submission
        popup.style.display = "flex"; // Shows the popup
    });

    closePopupButton.addEventListener("click", function() {
        popup.style.display = "none"; // Hides the popup
        reservationForm.reset(); // Resets the form fields
    });

    cancelButton.addEventListener("click", function() {
        window.location.href = "home.html"; // Redirects to home page
    });
});
