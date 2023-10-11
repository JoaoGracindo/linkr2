import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ConfigService } from 'src/app/services/auth.service';
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
    private router: Router
  ) {
    localStorage.clear();
  };

  form = new FormGroup({
    email: new FormControl(''),
    password: new FormControl(''),
  });

  submit() {
    this.authService.login(this.form.value as loginDTO)
    .subscribe(token => localStorage.setItem('token', token));
  }
}
