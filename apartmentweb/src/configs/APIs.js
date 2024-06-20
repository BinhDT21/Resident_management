import axios from "axios"
import Cookies from 'js-cookie'
import cookie from "react-cookies"

const BASE_URL = 'http://localhost:8080/ResidentManagement/'

export const endpoints = {
    'login':'/api/login/',
    'current-user':'api/current-user/',
    'update-user':'api/update-user',
    'feedback': 'api/feedbacks',
    'no-process': 'api/feedbacks?status=0',
    'processed': 'api/feedbacks?status=1',
    'create-feedback': 'api/feedbacks',
}

const authApi = axios.create({
    baseURL:BASE_URL,
    headers:{
        'Authorization': cookie.load('token')
    }
})

authApi.interceptors.request.use(
    (config) => {
      const token = Cookies.get('token')
      if (token) {
        config.headers['authorization'] = token
      }
      return config
    },
    (error) => {
      return Promise.reject(error)
    }
  )

export { authApi }

export default axios.create({
    baseURL:BASE_URL
})