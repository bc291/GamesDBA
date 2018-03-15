import { Component, OnInit } from '@angular/core';
import{Router}  from '@angular/router';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-navbar',
  templateUrl: 'navbar.component.html',
  styleUrls: ['navbar.component.css']
})
export class NavbarComponent implements OnInit {
 constructor(private _router:Router) { }

ngOnInit(){
}


}
