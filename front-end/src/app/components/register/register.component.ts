import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

import { ConfigService } from 'src/app/services/config.service';
import { signUpDTO } from 'src/protocols';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent {
  form = new FormGroup({
    email: new FormControl(''),
    password: new FormControl(''),
    name: new FormControl(''),
    picUrl: new FormControl(''),
  });

  constructor(private api: ConfigService) {}

  submit() {
    this.api.signUp(this.form.value as signUpDTO);
  }
}
