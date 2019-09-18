export class User{
  userName: string;
  eMail: string;
}

export function createUser(userName?: string, eMail?: string) {
  return{
    userName,
    eMail
  }
}
