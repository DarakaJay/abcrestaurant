
document.getElementById('load-offers').addEventListener('click', loadMoreOffers);

function loadMoreOffers() {
    const offersContainer = document.getElementById('offers-container');


    const newOffers = [
        { title: 'Weekend Special', description: 'Enjoy a 20% discount on all main courses every weekend.' },
        { title: 'Family Feast', description: 'Get a free dessert with every family meal.' },
        { title: 'Happy Hours', description: '50% off on selected drinks from 5 PM to 7 PM.' },
    ];

    newOffers.forEach(offer => {
        const offerDiv = document.createElement('div');
        offerDiv.classList.add('offer-item');
        offerDiv.innerHTML = `<h3>${offer.title}</h3><p>${offer.description}</p>`;
        offersContainer.appendChild(offerDiv);
    });


    document.getElementById('load-offers').disabled = true;
    document.getElementById('load-offers').textContent = "All Offers Loaded";
}
