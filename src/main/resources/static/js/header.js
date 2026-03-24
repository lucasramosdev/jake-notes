function toggleMobileSearchInput() {
    const input = document.getElementById("mobile-search-input");
    const menuHamburguer = document.getElementById("menu-hamburguer");
    const logo = document.getElementById("logo");
    let classes = input.className;

    if (classes.includes("search-input-mobile-on")) {
        input.className = "d-none"
        menuHamburguer.className = "navbar-toggler"
        logo.className = "navbar-brand"
        return
    }

    menuHamburguer.className = "navbar-toggler hide-on-header"
    logo.className = "navbar-brand hide-on-header"
    input.className = "form-control search-notes search-input-mobile-on"
    return
}


function onSubmitSearch(event) {
    event.preventDefault();
    const query = event.target.children[0].value;
    window.location.replace("/search?q="+query)
}

document.addEventListener("DOMContentLoaded", function () {
    const mobileSearchIcon = document.getElementById("mobile-search-icon");
    mobileSearchIcon.addEventListener("click", toggleMobileSearchInput);

    const forms = document.getElementsByClassName('search-form');
    for (let form of forms) {
        form.addEventListener('submit', onSubmitSearch)
    }
});