
const addImageBtn = document.getElementById('add-image-btn');
const modal = document.getElementById('image-modal');
const closeModalBtn = document.querySelector('.close-modal');
const imageForm = document.getElementById('image-form');
const galleryGrid = document.querySelector('.gallery-grid');


addImageBtn.addEventListener('click', () => {
    modal.style.display = 'block';
    imageForm.dataset.action = 'add';
});


closeModalBtn.addEventListener('click', () => {
    modal.style.display = 'none';
});


imageForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const action = imageForm.dataset.action;
    const fileInput = document.getElementById('image-file');
    const descriptionInput = document.getElementById('image-description');

    if (action === 'add') {

        console.log('Adding image:', fileInput.files[0], descriptionInput.value);

    } else if (action === 'update') {

        console.log('Updating image:', fileInput.files[0], descriptionInput.value);

    }


    modal.style.display = 'none';
    imageForm.reset();
});


galleryGrid.addEventListener('click', (e) => {
    if (e.target.classList.contains('update-image-btn')) {

        modal.style.display = 'block';
        imageForm.dataset.action = 'update';
        console.log('Updating image', e.target.parentElement);
    }

    if (e.target.classList.contains('delete-image-btn')) {

        console.log('Deleting image', e.target.parentElement);

    }
});

window.addEventListener('click', (e) => {
    if (e.target === modal) {
        modal.style.display = 'none';
    }
});
