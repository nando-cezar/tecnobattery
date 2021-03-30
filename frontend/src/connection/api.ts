import axios from 'axios'

const API_URL = 'https://app-tecnobattery.herokuapp.com'

const options = {
  headers: {
    "Content-Type": "application/json"
  }
}

const body = {
  username: '',
  password: ''
}

export function authenticationUser(username: string, password: string){
  body.username = username
  body.password = password
  return axios.post(`${API_URL}/login`, body, options)
}