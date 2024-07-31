// photographer.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PhotographerService {
  private apiUrl = 'http://your-backend-api/photographer'; // Replace with your backend API URL

  constructor(private http: HttpClient) {}

  getProfile(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/profile`);
  }

  updateProfile(profile: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/profile`, profile);
  }
  getPortfolio(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/portfolio`);
  }
  getPhotographers(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
}

