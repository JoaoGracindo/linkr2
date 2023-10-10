import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs'; 

import { environment } from 'src/environments/environment';
import { loginDTO, signUpDTO } from 'src/protocols';
import { StorageService } from './storage.service';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  private uri = environment.API_URL + '/auth';
  private storage = new StorageService();

  constructor(private httpClient: HttpClient) { }

  login(payload: loginDTO): Observable<string> {
    const url = this.uri + '/login';
    return this.httpClient.post<string>(url, payload, {responseType: 'text' as 'json'});
    // this.storage.setToken(JSON.stringify(token));
  }

  signUp(payload: signUpDTO): Observable<signUpDTO> {
    const url = this.uri + '/signup';
    const response = this.httpClient.post<signUpDTO>(url, payload);

    this.login({
      email: payload.email,
      password: payload.password
    });

    return response;
  }
}
