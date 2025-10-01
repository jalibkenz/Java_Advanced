const form = document.getElementById('scrapForm');
const mobile = document.getElementById('mobile');
const scrapMsg = document.getElementById('scrapMsg');
const mobileError = document.getElementById('mobileError');
const msgError = document.getElementById('msgError');

form.addEventListener('submit', (e) => {
    let valid = true;

    // Reset errors
    mobileError.textContent = '';
    msgError.textContent = '';

    // Mobile validation: must be 10 digits
    const mobileValue = mobile.value.trim();
    if (!/^\d{10}$/.test(mobileValue)) {
        mobileError.textContent = "Please enter Indian mobile number of 10 digits";
        valid = false;
    }

    // Message validation: not empty
    if (scrapMsg.value.trim() === '') {
        msgError.textContent = "Empty Scrap Messages neednot be send";
        valid = false;
    }

    if (!valid) {
        e.preventDefault(); // Prevent form submission if invalid
    }
});