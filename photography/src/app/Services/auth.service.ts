import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  baseUrl: string = `${environment.apiUrl}/v1/auth`;

  constructor(private http: HttpClient, private router: Router) { }

  register(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/register`, data);
  }

  registerClient(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/register-client`, data);
  }

  registerPhotographer(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/register-photographer`, data);
  }

  login(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/authenticate`, data);
  }

  getAllUsers(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/users`);
  }

  deleteUser(userId: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/user/${userId}`);
  }

  getToken() {
    return localStorage.getItem('token');
  }

  getUserIdFromToken(): string | null {
    const token = this.getToken();
    if (token) {
      const payload = JSON.parse(atob(token.split('.')[1]));
      return payload.userId; 
    }
    return null;
  }

  getRoleFromToken(): string | null {
    const token = this.getToken();
    if (token) {
      const payload = JSON.parse(atob(token.split('.')[1]));
      return payload.role;
    }
    return null;
  }

  logout() {
    localStorage.removeItem('token'); 
    this.router.navigate(['/']); 
  }

  isAuthenticated(): boolean {
    return !!localStorage.getItem('token');
  }

  isUserRole(role: string): boolean {
    const userRole = this.getRoleFromToken();
    return userRole === role;
  }
}
