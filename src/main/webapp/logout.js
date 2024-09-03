function confirmLogout() {
    if (confirm("Logging out")) {
        window.location.href = "home.html"; // Redirect to home page
    }
}

function cancelLogout() {
    window.history.back(); // Go back to the previous page
}
