document.getElementById("login-form").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent the default form submission behavior

    // Get the selected user role
    var userRole = document.getElementById("userRole").value;

    // Redirect to the appropriate dashboard based on the selected role
    if (userRole === "admin") {
        window.location.href = "admindash.html"; // Replace with the actual admin dashboard page
    } else if (userRole === "staff") {
        window.location.href = "stafffhome.html"; // Replace with the actual staff dashboard page
    }
});

// Handle the cancel button click
document.getElementById("cancel-btn").addEventListener("click", function() {
    // Clear the form inputs
    document.getElementById("login-form").reset();
});
