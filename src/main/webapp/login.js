document.getElementById("login-form").addEventListener("submit", function(event) {
    event.preventDefault();

    window.location.href = "home.html";
});

document.getElementById("cancel-btn").addEventListener("click", function() {

    document.getElementById("login-form").reset();
});
