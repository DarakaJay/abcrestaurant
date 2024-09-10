function confirmLogout() {
    if (confirm("Logging out")) {
        window.location.href = "home.html";
    }
}

function cancelLogout() {
    window.history.back();
}
