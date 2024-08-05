// photographer-profile.component.ts
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { PhotographerService } from 'src/app/Services/photographer.service'; // Create this service for handling data

@Component({
  selector: 'app-photographer-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  photographer = {
    name: '',
    surname: '',
    email: '',
    bio: '',
    portfolio: ''
  };

  constructor(private photographerService: PhotographerService, private router: Router) {}

  ngOnInit() {
    this.loadProfile();
  }

  loadProfile() {
    // Fetch photographer's profile data from the backend
    this.photographerService.getProfile().subscribe(
      (data) => {
        this.photographer = data;
      },
      (error) => {
        console.error('Error fetching profile', error);
      }
    );
  }

  onSubmit() {
    // Update photographer's profile
    this.photographerService.updateProfile(this.photographer).subscribe(
      (response) => {
        console.log('Profile updated successfully');
        // Redirect or display a success message
        this.router.navigate(['/home']);
      },
      (error) => {
        console.error('Error updating profile', error);
      }
    );
  }
}

