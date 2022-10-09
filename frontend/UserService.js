import axios, { HttpStatusCode } from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {

    getUsers() {
        return http.get('/users');
    }
}