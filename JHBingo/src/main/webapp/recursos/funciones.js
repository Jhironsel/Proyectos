function generateNumber() {
    // Generate a random number between 1 and 25
    var randomNumber = Math.floor(Math.random() * 25) + 1;

    // Get the cell with the matching number
    var cell = document.getElementById("cell-" + randomNumber);

    // Mark the cell as selected
    cell.style.background = "green";
    cell.innerHTML = randomNumber;

    //check if player win
    checkWin();
}

function checkWin() {
    // Check for horizontal wins
    for (var i = 1; i <= 5; i++) {
        var row = "";
        for (var j = 1; j <= 5; j++) {
            row += document.getElementById("cell-" + (i + j * 5)).innerHTML;
        }
        if (row.indexOf("5") === -1) {
            displayWinnerMessage();
            return;
        }
    }
    // Check for vertical wins
    for (var i = 1; i <= 5; i++) {
        var col = "";
        for (var j = 1; j <= 5; j++) {
            col += document.getElementById("cell-" + (i + j)).innerHTML;
        }
        if (col.indexOf("5") === -1) {
            displayWinnerMessage();
            return;
        }
    }
    // Check for diagonal wins
    var diagonal1 = "";
    var diagonal2 = "";
    for (var i = 1; i <= 5; i++) {
        diagonal1 += document.getElementById("cell-" + i * 6).innerHTML;
        diagonal2 += document.getElementById("cell-" + (i * 4 + 1)).innerHTML;
    }
    if (diagonal1.indexOf("5") === -1 || diagonal2.indexOf("5") === -1) {
        displayWinnerMessage();
    }
}

function displayWinnerMessage() {
    var message = document.createElement("div");
    message.innerHTML = "¡GANASTE!";
    message.style.fontSize = "50px";
    message.style.color = "green";
    message.style.textAlign = "center";
    document.body.appendChild(message);
}