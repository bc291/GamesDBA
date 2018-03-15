import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Component, OnInit } from '@angular/core';
import{UserService}  from '../../shared-service/user.service';
import{Router}  from '@angular/router';
import { fadeInAnimation } from '../_animations/index';
import{StatisticsService}  from '../../shared-service/statistics.service';
import{Statistics}  from '../../statistics';
import { MatGridListModule, MatCardModule } from '@angular/material';

@Component({
  moduleId: module.id.toString(),
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css'],
  animations: [fadeInAnimation],
  host: { '[@fadeInAnimation]': '' }
})


export class StatisticsComponent implements OnInit {
 private statistics2:Statistics[];

tiles: any[] = [
    {text: 'One', cols: 3, rows: 1, color: 'lightblue'},
    {text: 'Two', cols: 1, rows: 2, color: 'lightgreen'},
    {text: 'Three', cols: 1, rows: 1, color: 'lightpink'},
    {text: 'Four', cols: 2, rows: 1, color: '#DDBDF1'},
  ];

   dogs: Object[] = [
      { name: 'sdsd', human: 'Kara' },
      { name: 'Mal', human: 'Jeremy' },
      { name: 'Koby', human: 'Igor' },
      { name: 'Razzle', human: 'Ward' },
      { name: 'Molly', human: 'Rob' },
      { name: 'Husi', human: 'Matias' },
    ];

    basicRowHeight = 80;
    fixedCols = 4;
    fixedRowHeight = 100;
    ratioGutter = 1;
    fitListHeight = '400px';
    ratio = '4:1';

    addTileCols() { this.tiles[2].cols++; }

// Pie
  public pieChartLabels:string[] = ['PC', 'PS3', 'PS4'];
  public pieChartData:number[] = [300, 500, 100];
  public pieChartType:string = 'pie';

  // events
  public chartClicked(e:any):void {
    console.log(e);
  }

  public chartHovered(e:any):void {
    console.log(e);
  }


  public pieChartOptions: any = {
      responsive: true,
      maintainAspectRatio: false
  };


  constructor(private _statisticsService:StatisticsService, private _router:Router) { }

  ngOnInit() {

      this._statisticsService.getStatistics().subscribe((statistics)=>{
        console.log(statistics);
        this.statistics2=statistics;



      },(error)=>{
        console.log(error);
      })



}
}
