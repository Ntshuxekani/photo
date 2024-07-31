// booking.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  private apiUrl = 'http://localhost:3000/booking'; // Replace with your actual backend URL

  constructor(private http: HttpClient) {}

  createBooking(booking: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, booking);
  }
}

