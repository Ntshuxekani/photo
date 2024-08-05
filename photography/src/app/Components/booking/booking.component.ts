// booking.component.ts
import { Component, OnInit } from '@angular/core';
import { BookingService } from 'src/app/Services/booking.service';
import { PhotographerService } from 'src/app/Services/photographer.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.scss']
})
export class BookingComponent implements OnInit {
  booking: any = {};
  photographers: any[] = [];

  constructor(private bookingService: BookingService, private photographerService: PhotographerService) {}

  ngOnInit(): void {
    this.loadPhotographers();
  }

  loadPhotographers() {
    this.photographerService.getPhotographers().subscribe(
      (data) => {
        this.photographers = data;
      },
      (error) => {
        console.error('Error fetching photographers', error);
      }
    );
  }

  onSubmit() {
    this.bookingService.createBooking(this.booking).subscribe(
      (response) => {
        console.log('Booking successful', response);
      },
      (error) => {
        console.error('Error creating booking', error);
      }
    );
  }
}
