import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

import { AuthService } from 'src/app/services/auth.service';
import { signUpDTO } from 'src/protocols';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
  providers: [AuthService]
})
export class RegisterComponent {
  form = new FormGroup({
    email: new FormControl(''),
    password: new FormControl(''),
    name: new FormControl(''),
    picUrl: new FormControl(''),
  });

  constructor(private api: AuthService) {}

  submit() {
    const {email, password, name, picUrl} = this.form.value;
    if(email === '' || password === '' || name === '' || picUrl ===''){
      alert("complete os campos");
      return;
    }

    this.api.signUp(this.form.value as signUpDTO).subscribe();
  }
}
