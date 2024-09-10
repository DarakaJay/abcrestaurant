

document.getElementById('registration-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const popup = document.getElementById('popup');
    popup.style.display = 'block';

    setTimeout(function() {
        popup.style.display = 'none';
    }, 3000);

    const email = document.getElementById('email').value;
    sendRegistrationEmail(email);
});

function sendRegistrationEmail(email) {
    console.log(`Registration email sent to ${email}`);
    alert(`A confirmation email has been sent to ${email}`);
}

document.getElementById('cancel').addEventListener('click', function() {
    window.location.href = 'admindash.html';
});
