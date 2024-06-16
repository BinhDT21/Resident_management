import axios from "axios"
import cookie from "react-cookies";

const BASE_URL = 'http://localhost:8080/ResidentManagement/'

export const endpoints = {
    //ví dụ: 'categories' = '/api/categories/'
    'login' : '/api/login/',
    'current-user':"/api/current-user/",
    'update-user':"/api/update-user/",
    'visitor':(residentId) => `/api/visitor/${residentId}/`,
    'create-visitor':"/api/visitor/",
    'delete-visitor':(visitorId) => `/api/visitor/${visitorId}/`
}

export const authApi =() => {
    return axios.create({
        baseURL:BASE_URL,
        headers:{
            'Authorization':cookie.load('token')
        }
    })
}

export default axios.create({
    baseURL:BASE_URL
})