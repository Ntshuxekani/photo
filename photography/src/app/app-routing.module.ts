import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Components/home/home.component';
import { ProfileComponent } from './Components/profile/profile.component';
import { PortfolioComponent } from './Components/portfolio/portfolio.component';
import { BookingComponent } from './Components/booking/booking.component';
import { LoginComponent } from './Components/login/login.component';
import { NavbarComponent } from './Components/navbar/navbar.component';
import { LandingPageComponent } from './Components/landing-page/landing-page.component';
import { ClientRegisterComponent } from './Components/client-register/client-register.component';
import { PhotographerRegisterComponent } from './Components/photographer-register/photographer-register.component';

const routes: Routes = [
{ path: '', redirectTo: '/landing', pathMatch: 'full' },
  { path: 'landing', component: LandingPageComponent },
  { path: 'home', component: HomeComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'portfolio', component: PortfolioComponent },
  { path: 'booking', component: BookingComponent },
  { path: 'login', component: LoginComponent },
  { path: 'navbar', component: NavbarComponent },
  { path: 'register-client', component: ClientRegisterComponent },
  { path: 'register-photographer', component: PhotographerRegisterComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
