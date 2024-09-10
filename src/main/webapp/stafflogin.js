document.getElementById("login-form").addEventListener("submit", function(event) {
    event.preventDefault();


    var userRole = document.getElementById("userRole").value;

    if (userRole === "admin") {
        window.location.href = "admindash.html"; 
    } else if (userRole === "staff") {
        window.location.href = "stafffhome.html"; 
    }
});


document.getElementById("cancel-btn").addEventListener("click", function() {

    document.getElementById("login-form").reset();
});
