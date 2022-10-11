


const tableName = "Search Results";
const userIdCellText = "User ID";
const nameCellText = "Name";
const phoneNumberCellText = "Phone Number";
const userList = document.getElementById('users');
const searchButton = document.getElementById('search-button');
let users = [
    // {
    //     userId: 0,
    //     name: "asdf",
    //     phoneNumber: "32"
    // },
    // {
    //     userId: 1,
    //     name: "hey there",
    //     phoneNumber: "93282"
    // }
];
let params = new URLSearchParams({
    searchQuery: "",
    sortIndication: "",
    pageSize: 50,
    pageNumber: 1
});

function loadUsers() {
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
            console.log(response.data);
            if (users !== []) {
                users = [];
            }
            users = response.data;

            const table = document.getElementById("user-table");
            const tableBody = document.createElement('tbody');
            tableBody.setAttribute("id", "table-body");
            tableBody.setAttribute("class", "table-body");
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
