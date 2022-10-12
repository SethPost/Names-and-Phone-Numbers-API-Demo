const tableName = "Search Results";
const noResultsMessageText = "No results found. Please try a different search.";
const rowNumberCellText = "Row Number";
const userIdCellText = "User ID";
const nameCellText = "Name";
const phoneNumberCellText = "Phone Number";

const userList = document.getElementById('users');
const searchButton = document.getElementById('search-button');

let users = [];
let params = new URLSearchParams({});

function getSearchParameters() {
    let searchQuery = "";
    if (document.getElementById('searchQuery').value != null) {
        searchQuery = document.getElementById('searchQuery').value;
    }
    console.log(searchQuery);
    
    let sortIndication = "";
    if (document.querySelector('input[name="sortIndication"]:checked')) {
        sortIndication = document.querySelector('input[name="sortIndication"]:checked').value;
    }
    console.log(sortIndication);

    let pageSize = 50;
    if (document.getElementById('pageSize').value != null) {
        pageSize = document.getElementById('pageSize').value;
    }
    console.log(pageSize);

    let pageNumber = 1;
    if (document.getElementById('pageNumber').value != null) {
        pageNumber = document.getElementById('pageNumber').value;
    }
    console.log(pageNumber);

    params = {
        searchQuery,
        sortIndication,
        pageSize,
        pageNumber
    };

    return params;
}

function loadUsers() {
    console.log(params);
    params = getSearchParameters();
    console.log(params);
    // let xhr = new XMLHttpRequest();
    // xhr.open("GET", "http://localhost:8080/users");
    // xhr.send();
    // xhr.onload = () => console.log(xhr.responseText);

    // const axios = require('axios');
    // const res = await axios.get('http://localhost:8080/users', { params });
    // res.data.args;

    axios.get('http://localhost:8080/users', { params
        // headers: {
        //     "Content-Type": "application/json",
        //     "Access-Control-Allow-Origin": "*",
        //     "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE, OPTIONS",
        //     "Access-Control-Allow-Headers": "Origin, Content-Type, X-Auth-Token, Authorization, Accept,charset,boundary,Content-Length"
        // }
    }).then(
        (response) => {
            console.log(response);
            if (users !== []) {
                users = [];
            }
            users = response.data;

            const searchResults = document.getElementById("users");

            let i = 1;

            // If table already exists, remove it.
            if (document.getElementById("user-table")) {
                const table = document.getElementById("user-table");
                searchResults.removeChild(table);
            }

            // If table title already exists, remove it.
            if (document.getElementById("table-title")) {
                const tableTitle = document.getElementById("table-title");
                searchResults.removeChild(tableTitle);
            }

            //If no results message already exists, remove it.
            if (document.getElementById("no-results-message")) {
                const noResultsMessage = document.getElementById("no-results-message");
                searchResults.removeChild(noResultsMessage);
            }

            //Create "Search Results" heading
            const tableTitle = document.createElement('h2');
            tableTitle.setAttribute("id", "table-title");
            tableTitle.innerText = tableName;
            searchResults.appendChild(tableTitle);

            //Create message if no results are found.
            if (users.length == 0) {
                const noResultsMessage = document.createElement('p');
                noResultsMessage.setAttribute("id", "no-results-message");
                noResultsMessage.innerText = noResultsMessageText;
                searchResults.appendChild(noResultsMessage);
            }

            //If there are results, create table
            if (users.length != 0) {
                const table = document.createElement('table');
                table.setAttribute("id", "user-table");
                searchResults.appendChild(table);

                //Create thead
                const tableHead = document.createElement('thead');
                table.appendChild(tableHead);

                //Create table head row
                const tableHeadRow = document.createElement('tr');
                tableHead.appendChild(tableHeadRow);

                //Create rowNumber column thead cell
                const rowNumberCell = document.createElement('td');
                rowNumberCell.innerText = rowNumberCellText;
                tableHeadRow.appendChild(rowNumberCell);

                //Create userId column thead cell
                const userIdCell = document.createElement('td');
                userIdCell.innerText = userIdCellText;
                tableHeadRow.appendChild(userIdCell);

                //Create name column thead cell
                const nameCell = document.createElement('td');
                nameCell.innerText = nameCellText;
                tableHeadRow.appendChild(nameCell);

                //Create phoneNumber column thead cell
                const phoneNumberCell = document.createElement('td');
                phoneNumberCell.innerText = phoneNumberCellText;
                tableHeadRow.appendChild(phoneNumberCell);

                //Create tableBody
                const tableBody = document.createElement('tbody');
                table.appendChild(tableBody);

                //Create table row with data for each user
                users.forEach((user) => {
                    const row = document.createElement('tr');
                    tableBody.appendChild(row);

                    const rowNumber = document.createElement('td');
                    rowNumber.innerText = i;
                    row.appendChild(rowNumber);
                    i++;

                    const userIdData = document.createElement('td');
                    userIdData.innerText = user.userId;
                    row.appendChild(userIdData);

                    const nameData = document.createElement('td');
                    nameData.innerText = user.name;
                    row.appendChild(nameData);

                    const phoneNumberData = document.createElement('td');
                    phoneNumberData.innerText = user.phoneNumber;
                    row.appendChild(phoneNumberData);
                });
            }
        }
    )
}

// function displaySearchResults() {

//     const table = document.getElementById("user-table");
//     const tableBody = document.createElement('tbody');
//     table.appendChild(tableBody);

//     users.forEach((user) => {
//         const row = document.createElement('tr');
//         tableBody.appendChild(row);

//         const userIdData = document.createElement('td');
//         userIdData.innerText = user.userId;
//         row.appendChild(userIdData);

//         const nameData = document.createElement('td');
//         nameData.innerText = user.name;
//         row.appendChild(nameData);

//         const phoneNumberData = document.createElement('td');
//         phoneNumberData.innerText = user.phoneNumber;
//         row.appendChild(phoneNumberData);
//     });

//     //userList.appendChild(table);
//     // const testP = document.createElement('p');
//     // testP.innerText = "This is a test";
//     // userList.appendChild(testP);
// }

searchButton.addEventListener('click', (event) => {
    event.preventDefault();
    loadUsers();
});
