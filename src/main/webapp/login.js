document.getElementById("login-form").addEventListener("submit", function(event) {
    event.preventDefault();
    // Redirect to the home page after clicking "Login"
    window.location.href = "home.html";
});

document.getElementById("cancel-btn").addEventListener("click", function() {
    // Clear the form inputs
    document.getElementById("login-form").reset();
});
