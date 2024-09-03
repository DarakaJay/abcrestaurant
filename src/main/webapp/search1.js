function displayFacilities() {
    const facilitiesHTML = `
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ABC Restaurant - Facilities</title>
        <link rel="stylesheet" href="facilities.css">
    </head>
    <body>

        <section id="facilities">
            <h2>Our Facilities</h2>
            <div class="facility-list">
                <div class="facility-item">
                    <img src="out.jpeg" alt="Dining Area">
                    <h3>Outdoor Seating</h3>
                    <p>An outdoor dining space where guests can enjoy their meals in the fresh air, often featuring scenic views or garden settings.</p>
                </div>
                <div class="facility-item">
                    <img src="bar.jpg" alt="Bar and Lounge">
                    <h3>Bar and Lounge</h3>
                    <p>A stylish area for guests to enjoy a wide range of beverages, from cocktails and wines to soft drinks, with a relaxed atmosphere for socializing.</p>
                </div>
                <div class="facility-item">
                    <img src="wifi.jpg" alt="Wi-Fi Access">
                    <h3>Wi-Fi Access</h3>
                    <p>Complimentary Wi-Fi service available throughout the restaurant, allowing guests to stay connected while they dine.</p>
                </div>
                <div class="facility-item">
                    <img src="liveenter.jpg" alt="Live Entertainment">
                    <h3>Live Entertainment</h3>
                    <p>Regular live music, DJs, or cultural performances to enhance the dining experience with entertainment.</p>
                </div>
                <div class="facility-item">
                    <img src="meeting.jpg" alt="Conference and Meeting Facilities">
                    <h3>Conference and Meeting Facilities</h3>
                    <p>Rooms equipped with AV technology and seating arrangements for corporate meetings, seminars, or workshops.</p>
                </div>
                <div class="facility-item">
                    <img src="playing.jpg" alt="Children’s Play Area">
                    <h3>Children’s Play Area</h3>
                    <p>A designated area with toys, games, and activities to keep young children entertained while their parents enjoy a meal.</p>
                </div>
            </div>
        </section>

        <footer>
            <p>&copy; 2024 ABC Restaurant. All rights reserved.</p>
        </footer>

        <script src="facilities.js"></script>
    </body>
    </html>
    `;

    document.getElementById('search-results').innerHTML = facilitiesHTML;
}
