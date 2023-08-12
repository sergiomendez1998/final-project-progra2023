import axios from "axios";

const usersApi = axios.create({
    baseURL: 'http://localhost:9090/api/v1/userList'
});

usersApi.interceptors.request.use(config => {
    config.headers = {
        ...config.headers,
        'Authorization': sessionStorage.getItem('token'),
    }
    return config;
});

export default usersApi;