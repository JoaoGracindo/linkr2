import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from 'src/environments/environment';
import { loginDTO, signUpDTO } from 'src/protocols';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private uri = environment.API_URL + '/auth';

  constructor(private httpClient: HttpClient) {}

  login(payload: loginDTO): Observable<string> {
    const url = this.uri + '/login';

    return this.httpClient.post<string>(url, payload, {
      responseType: 'text' as 'json',
    });
  }

  signUp(payload: signUpDTO): Observable<signUpDTO> {
    const url = this.uri + '/signup';
    const response = this.httpClient.post<signUpDTO>(url, payload, {
      responseType: 'text' as 'json',
    });


    return response;
  }

  isLoggedIn(): boolean {
    return localStorage.getItem('token') !== null;
  }

  getToken(): string {
    return localStorage.getItem('token') ?? '';
  }
}
