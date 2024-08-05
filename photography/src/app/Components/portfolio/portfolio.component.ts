// portfolio.component.ts
import { Component, OnInit } from '@angular/core';
import { PhotographerService } from 'src/app/Services/photographer.service';

@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.scss']
})
export class PortfolioComponent implements OnInit {
  portfolio: any[] = [];

  constructor(private photographerService: PhotographerService) { }

  ngOnInit(): void {
    this.loadPortfolio();
  }

  loadPortfolio() {
    this.photographerService.getPortfolio().subscribe(
      (data) => {
        this.portfolio = data;
      },
      (error) => {
        console.error('Error fetching portfolio', error);
      }
    );
  }
}
