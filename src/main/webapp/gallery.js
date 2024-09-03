// Select all gallery items
const galleryItems = document.querySelectorAll('.gallery-item');
const lightbox = document.getElementById('lightbox');
const lightboxImage = document.getElementById('lightbox-image');
const caption = document.getElementById('caption');
const close = document.querySelector('.close');

// Add click event to each gallery item
galleryItems.forEach(item => {
    item.addEventListener('click', () => {
        lightbox.style.display = 'block';
        lightboxImage.src = item.querySelector('img').src;
        caption.innerHTML = item.querySelector('img').alt;
    });
});

// Close the lightbox
close.addEventListener('click', () => {
    lightbox.style.display = 'none';
});

// Close lightbox when clicking outside the image
lightbox.addEventListener('click', (e) => {
    if (e.target !== lightboxImage) {
        lightbox.style.display = 'none';
    }
});
