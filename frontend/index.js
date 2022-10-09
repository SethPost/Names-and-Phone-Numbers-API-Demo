import axios from "axios";

const tableName = "Search Results";
const userIdCellText = "User ID";
const nameCellText = "Name";
const phoneNumberCellText = "Phone Number";
const userList = document.getElementById('users');
const searchButton = document.getElementById('search-button');
let users = [
    {
        userId: 1,
        name: 'Seth Post',
        phoneNumber: '3308073006'
    }
];

function loadUsers() {
    axios.get('http://localhost:8080/users').then(
        (response) => {
            this.users = response.data;
        }
    )
}

function displaySearchResults() {
    const heading = document.createElement('h2');
    heading.innerText = tableName;
    userList.appendChild(heading);


    const table = document.createElement('table');
    userList.appendChild(table);

    const tableHead = document.createElement('thead');
    table.appendChild(tableHead);

    const tableRow = document.createElement('trow');
    tableHead.appendChild(tableRow);

    const userIdCell = document.createElement('td');
    userIdCell.innerText = userIdCellText;
    tableRow.appendChild(userIdCell);

    const nameCell = document.createElement('td');
    nameCell.innerText = nameCellText;
    tableRow.appendChild(nameCell);

    const phoneNumberCell = document.createElement('td');
    phoneNumberCell.innerText = phoneNumberCellText;
    tableRow.appendChild(phoneNumberCell);

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
}

searchButton.addEventListener('click', (event) => {
    event.preventDefault();
    loadUsers();
});

displaySearchResults();