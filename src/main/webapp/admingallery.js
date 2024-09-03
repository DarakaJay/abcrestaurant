// Select necessary DOM elements
const addImageBtn = document.getElementById('add-image-btn');
const modal = document.getElementById('image-modal');
const closeModalBtn = document.querySelector('.close-modal');
const imageForm = document.getElementById('image-form');
const galleryGrid = document.querySelector('.gallery-grid');

// Open modal for adding new image
addImageBtn.addEventListener('click', () => {
    modal.style.display = 'block';
    imageForm.dataset.action = 'add';
});

// Close modal
closeModalBtn.addEventListener('click', () => {
    modal.style.display = 'none';
});

// Submit image form
imageForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const action = imageForm.dataset.action;
    const fileInput = document.getElementById('image-file');
    const descriptionInput = document.getElementById('image-description');

    if (action === 'add') {
        // Logic to add image
        console.log('Adding image:', fileInput.files[0], descriptionInput.value);
        // Code to upload image and add to gallery
    } else if (action === 'update') {
        // Logic to update image
        console.log('Updating image:', fileInput.files[0], descriptionInput.value);
        // Code to update the selected image
    }

    // Close modal and reset form
    modal.style.display = 'none';
    imageForm.reset();
});

// Event delegation for update and delete buttons
galleryGrid.addEventListener('click', (e) => {
    if (e.target.classList.contains('update-image-btn')) {
        // Open modal for updating the image
        modal.style.display = 'block';
        imageForm.dataset.action = 'update';
        console.log('Updating image', e.target.parentElement);
    }

    if (e.target.classList.contains('delete-image-btn')) {
        // Logic to delete image
        console.log('Deleting image', e.target.parentElement);
        // Code to delete the image from the gallery
    }
});

// Close modal when clicking outside the modal content
window.addEventListener('click', (e) => {
    if (e.target === modal) {
        modal.style.display = 'none';
    }
});
