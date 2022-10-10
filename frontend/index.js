// import axios from "axios";


const tableName = "Search Results";
const userIdCellText = "User ID";
const nameCellText = "Name";
const phoneNumberCellText = "Phone Number";
const userList = document.getElementById('users');
const searchButton = document.getElementById('search-button');
let users = [];

function init() {
    users = [
        {
            userId: 1,
            name: 'Seth Post',
            phoneNumber: '3308073006'
        },
        {
            userId: 2,
            name: 'Test Name',
            phoneNumber: '1234567890'
        }
    ];
}

function loadUsers() {
    axios.get('http://localhost:8080/users', {
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE, OPTIONS",
            "Access-Control-Allow-Headers": "Origin, Content-Type, X-Auth-Token, Authorization, Accept,charset,boundary,Content-Length"
        }
    }).then(
        (response) => {
            this.users = response.data;
        }
    )
}

function displaySearchResults() {

    const table = document.getElementById("user-table");
    const tableBody = document.createElement('tbody');
    table.appendChild(tableBody);

    users.forEach((user) => {
        const row = document.createElement('tr');
        tableBody.appendChild(row);

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

    userList.appendChild(table);
    const testP = document.createElement('p');
    testP.innerText = "This is a test";
    userList.appendChild(testP);
}

searchButton.addEventListener('click', (event) => {
    event.preventDefault();
    loadUsers();
});

init();
displaySearchResults();