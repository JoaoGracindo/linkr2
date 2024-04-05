import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { loginDTO } from 'src/protocols';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  providers: [AuthService]
})
export class LoginComponent {
  constructor(
    private authService: AuthService,
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

    //to-do: navigation to main page
    this.router.navigate(['/']);
  }
}
