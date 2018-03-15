import { Component, OnInit } from '@angular/core';
import{User}  from '../../user';
import{Router}  from '@angular/router';
import{UserService}  from '../../shared-service/user.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  currentRate: number;

  private user:User;
  percentageCompleted : string='';
    playersRating : string='';
isDone: boolean = false;
isRatingLegit: boolean = false;
  constructor(private _userService:UserService,private _rotuer:Router) { }

  ngOnInit() {
    this.user=this._userService.getter();
  }

  processForm(){
    if(this.user.id==undefined){
       this._userService.createUser(this.user).subscribe((user)=>{
         console.log(user);
         this._rotuer.navigate(['/gamelibrary']);
       },(error)=>{
         console.log(error);
       });
    }else{
       this._userService.updateUser(this.user).subscribe((user)=>{
         console.log(user);
         this._rotuer.navigate(['/gamelibrary']);
       },(error)=>{
         console.log(error);
       });
    }
  }


  textVerification(percentageCompleted)
  {
if(percentageCompleted>=0 && percentageCompleted<=100)
 {

this.isDone=false;
 }
else
{
this.isDone=true;

}

if(this.isDone){ console.log('prawda');}
else {console.log('falsz');}
  }


  ratingVerification(playerRating)
  {
if(playerRating>=1 && playerRating<=5)
 {

this.isRatingLegit=false;
 }
else
{
this.isRatingLegit=true;

}

if(this.isRatingLegit){ console.log('prawda');}
else {console.log('falsz');}


this.currentRate=playerRating;
  }


  refreshStyle()
  {
    if(this.isDone){ return 'solid 1px #ff0000';}
    else { return 'solid 1px #00ff00';}
  }

  refreshStyleRating()
  {
    if(this.isRatingLegit){ return 'solid 1px #ff0000';}
    else { return 'solid 1px #00ff00';}
  }

}
