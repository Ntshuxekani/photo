import { Component } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  user = {
    name: '',
    surname: '',
    email: '',
    password: '',
    confirmPassword: '',
    role: ''
  };

  onSubmit() {
    if (this.user.password !== this.user.confirmPassword) {
      alert("Passwords do not match!");
      return;
    }

    if (this.user.role === 'photographer') {
      // Handle photographer registration logic
      console.log("Registering as a photographer", this.user);
    } else if (this.user.role === 'client') {
      // Handle client registration logic
      console.log("Registering as a client", this.user);
    }
  }
}
