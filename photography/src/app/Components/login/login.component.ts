// login.component.ts
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/Services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  user = {
    email: '',
    password: ''
  };

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    this.authService.login(this.user.email, this.user.password).subscribe(
      response => {
        console.log('Login successful');
        // Navigate to home or dashboard page on successful login
        this.router.navigate(['/home']);
      },
      error => {
        console.error('Login failed', error);
      }
    );
  }
}
