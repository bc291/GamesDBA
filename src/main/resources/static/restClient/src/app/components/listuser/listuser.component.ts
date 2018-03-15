import { Component, OnInit } from '@angular/core';
import{UserService}  from '../../shared-service/user.service';
import{User}  from '../../user';
import{Router}  from '@angular/router';
import{Gameselection}  from '../../gameselection';
import {Observable} from 'rxjs/Rx';
import {MatTableModule} from '@angular/material/table';
import { fadeInAnimation } from '../_animations/index';

@Component({
  moduleId: module.id.toString(),
  selector: 'app-listuser',
  templateUrl: './listuser.component.html',
  styleUrls: ['./listuser.component.css'],
   animations: [fadeInAnimation],
    host: { '[@fadeInAnimation]': '' }
})
export class ListuserComponent implements OnInit {
  str:string = '';
str2:string='';
isAdded:string='';
  private users:User[];
    private gameselections:Gameselection[];
  constructor(private _userService:UserService, private _router:Router) { }

  ngOnInit() {
      this._userService.getUsers().subscribe((users)=>{
        console.log(users);
        this.users=users;
      },(error)=>{
        console.log(error);
      })

let timer = Observable.timer(2000, 1000);
        timer.subscribe(() => this.test34());


        let timer2 = Observable.timer(500, 8000);
                timer2.subscribe(() => this.checkForAdding());
  }

  deleteUser(user){
    this._userService.deleteUser(user.id).subscribe((data)=>{
        this.users.splice(this.users.indexOf(user),1);
    },(error)=>{
      console.log(error);
    });
  }

   updateUser(user){
     this._userService.setter(user);
     this._router.navigate(['/op']);


   }


newUser()
{
let user = new User();
     this._userService.setter(user);
     this._router.navigate(['/op']);
}

sendValues(): void {
console.log(this.str);
}


submitMyForm(): void {


 this._userService.setter2(this.str).subscribe((isAdded)=>{
         console.log(isAdded);
         this.isAdded=isAdded;
         if(this.isAdded==='true') this.theHtmlString = '<div class="alert alert-success" role="alert">Dodano pomyślnie</div>';
         if(this.isAdded==='false') this.theHtmlString = '<div class="alert alert-danger" role="alert">Gra znajduje się już w bibliotece</div>';
       },(error)=>{
         console.log(error);
       });
this.clear();


}

theHtmlString: string='';

test34()
{
 this._userService.getUsers().subscribe((users)=>{

        console.log(users);
        this.users=users;
      },(error)=>{
        console.log(error);
      })
console.log("odswiezam");





this.isAdded='';

}


 clear(){
   this.str = "";
 }

 checkForAdding()
 {
 this.theHtmlString='';
 }


}


