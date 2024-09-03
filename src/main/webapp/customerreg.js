// scripts.js

document.getElementById('registration-form').addEventListener('submit', function(event) {
    event.preventDefault();

    // Display popup message
    const popup = document.getElementById('popup');
    popup.style.display = 'block';

    // Hide the popup after 3 seconds
    setTimeout(function() {
        popup.style.display = 'none';
    }, 3000);

    // Send email to the customer (mock implementation)
    const email = document.getElementById('email').value;
    sendRegistrationEmail(email);
	
});

function sendRegistrationEmail(email) {
    // Mock implementation of sending an email (can be implemented with a backend server)
    console.log(`Registration email sent to ${email}`);
    alert(`A confirmation email has been sent to ${email}`);

        cancelButton.addEventListener("click", function() {
        window.location.href = "home.html"; // Redirects to home page
    });
}

function saveCustomer() {
    // Mock implementation of sending an email (can be implemented with a backend server)
	<form action="product?action=add" method="post">
	            <div class="form-group">
	                <label for="name">Name:</label>
	                <input type="text" class="form-control" id="name" name="name" required>
	            </div>
	            <div class="form-group">
	                <label for="price">Price:</label>
	                <input type="number" class="form-control" step="0.01" id="price" name="price" required>
	            </div>
	            <button type="submit" class="btn btn-primary">Add Product</button>
	        </form>
}

