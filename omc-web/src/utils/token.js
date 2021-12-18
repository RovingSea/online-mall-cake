export function getToken() {
  let token = window.localStorage.getItem('token')
  if (token) {
    return token
  } else {
    return null
  }
}

export function setToken(token) {
  window.localStorage.setItem('token', token)
}

