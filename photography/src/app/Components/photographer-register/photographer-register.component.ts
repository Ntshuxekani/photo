import { Component } from '@angular/core';
import { AuthService } from 'src/app/Services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-photographer-register',
  templateUrl: './photographer-register.component.html',
  styleUrls: ['./photographer-register.component.scss']
})
export class PhotographerRegisterComponent {
  name: string = '';
  surname: string = '';
  email: string = '';
  password: string = '';
  confirmPassword: string = '';

  constructor(private authService: AuthService, private router: Router) { }

  register() {
    if (this.password !== this.confirmPassword) {
      alert("Passwords do not match!");
      return;
    }
    const registerData = { name: this.name, surname: this.surname, email: this.email, password: this.password };
    this.authService.register(registerData).subscribe(
      response => {
        alert('User registered successfully!');
        this.router.navigate(['/login']);
      },
      error => {
        console.error('Registration error:', error);
      }
    );
  }
}
