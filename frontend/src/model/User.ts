import { Role } from "./Role";

export type User = {

  id: number
  role: Role
  password: string
  username: string
  email: string
  phoneNumber: string
  isAccountNonExpired: boolean
  isAccountNonLocked: boolean
  isCredentialsNonExpired: boolean
  isEnabled: boolean

}