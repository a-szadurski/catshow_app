document.addEventListener('DOMContentLoaded', categoryHighlight)

function categoryHighlight() {
    const category = document.getElementsByTagName("span");

    for (let i = 0; i < category.length; i++) {
        if(category[i].innerText === "true"){
            category[i].style.background = "DarkGreen";
            category[i].style.color = "AntiqueWhite";
        } else if (category[i].innerText === "false"){
            category[i].style.background = "DarkRed";
            category[i].style.color = "AntiqueWhite";
        }
    }

}