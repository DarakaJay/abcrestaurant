
const galleryItems = document.querySelectorAll('.gallery-item');
const lightbox = document.getElementById('lightbox');
const lightboxImage = document.getElementById('lightbox-image');
const caption = document.getElementById('caption');
const close = document.querySelector('.close');


galleryItems.forEach(item => {
    item.addEventListener('click', () => {
        lightbox.style.display = 'block';
        lightboxImage.src = item.querySelector('img').src;
        caption.innerHTML = item.querySelector('img').alt;
    });
});


close.addEventListener('click', () => {
    lightbox.style.display = 'none';
});


lightbox.addEventListener('click', (e) => {
    if (e.target !== lightboxImage) {
        lightbox.style.display = 'none';
    }
});
