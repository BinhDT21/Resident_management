import axios from "axios"

const BASE_URL = 'http://localhost:8080/ResidentManagement/'

export const endpoints = {
    //ví dụ: 'categories' = '/api/categories/'
}

export default axios.create({
    baseURL:BASE_URL
})