import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class StorageService {
  private storage: Storage;

  constructor() {
    this.storage = window.localStorage;
  }

  getToken(){
    const token = this.storage.getItem('token')
    token ? JSON.parse(token) :  '';
  }

  setToken(token: string): void{
    this.storage.setItem(token, 'token');
  }
}
