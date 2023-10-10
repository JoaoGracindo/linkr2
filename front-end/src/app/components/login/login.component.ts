import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ConfigService } from 'src/app/services/auth.service';
import { StorageService } from 'src/app/services/storage.service';
import { loginDTO } from 'src/protocols';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  providers: [ConfigService]
})
export class LoginComponent {
  constructor(
    private authService: ConfigService,
    private storageService: StorageService
  ) {};

  form = new FormGroup({
    email: new FormControl(''),
    password: new FormControl(''),
  });

  submit() {
    this.authService.login(this.form.value as loginDTO)
    .subscribe((token) => this.storageService.setToken(token));
  }
}
