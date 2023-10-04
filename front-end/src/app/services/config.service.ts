import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs'; 

import { env } from 'src/environment/environment';
import { loginDTO, signUpDTO } from 'src/protocols';
import { StorageService } from './storage.service';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  private uri = env.API_URL;
  private storage = new StorageService();

  constructor(private httpClient: HttpClient) { }

  login(payload: loginDTO): void {
    const url = this.uri + '/login';
    const token = this.httpClient.post(url, payload);

    this.storage.setToken(JSON.stringify(token));
  }

  signUp(payload: signUpDTO): void {
    const url = this.uri + '/signup';
    this.httpClient.post(url, payload);

    this.login({
      email: payload.email,
      password: payload.password
    });
  }
}
