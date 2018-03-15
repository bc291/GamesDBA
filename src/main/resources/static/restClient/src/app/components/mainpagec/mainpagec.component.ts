import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Component, OnInit } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import{Router}  from '@angular/router';
import { fadeInAnimation } from '../_animations/index';

@Component({
  moduleId: module.id.toString(),
  selector: 'app-mainpagec',
  templateUrl: './mainpagec.component.html',
  styleUrls: ['./mainpagec.component.css'],
  animations: [fadeInAnimation],
  host: { '[@fadeInAnimation]': '' }
})
export class MainpagecComponent implements OnInit {

  constructor(private _router:Router) { }

  ngOnInit() {
  document.body.classList.add('bg-img');
  }

}

