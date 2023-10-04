import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent {
  form = new FormGroup({
    email: new FormControl(''),
    password: new FormControl(''),
    username: new FormControl(''),
    picUrl: new FormControl(''),
  });

  onSubmit() {
    console.log(this.form.value);
  }
}
