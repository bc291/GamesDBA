import { Injectable } from '@angular/core';
import{Http, Response, Headers, RequestOptions} from '@angular/http';
import{Observable}   from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import{User}  from '../user';
import{Gameselection}  from '../gameselection';



@Injectable()
export class UserService {
private baseUrl:string='http://192.168.0.248:42488/api';
private headers = new Headers({'Content-Type':'application/json'});
private options = new RequestOptions({headers:this.headers});
private user = new User();
private gameselection = new Gameselection();
testResponse: any;

constructor(private _http:Http) { }

  getUsers(){

    return this._http.get(this.baseUrl+'/games',this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }
  getUser(id:Number){

    return this._http.get(this.baseUrl+'/games/'+id,this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }
  deleteUser(id:Number){

    return this._http.delete(this.baseUrl+'/games/'+id,this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }


  createUser(user:User){

    return this._http.post(this.baseUrl+'/games',JSON.stringify(user),  this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }

   updateUser(user:User){

    return this._http.put(this.baseUrl+'/games',JSON.stringify(user),  this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }




  errorHandler(error:Response){

     return Observable.throw(error||"SERVER ERROR");
  }

   setter(user:User){
     this.user=user;
   }

      setter2(obj3:string){

var jsonObj = {"tytulgry" : "wolfenstein2"}
var jsonObj2 = {"tytulgry" : obj3}



 return this._http.post(this.baseUrl+'/searchgame', JSON.stringify(jsonObj2), { headers: new Headers({ 'Content-Type': 'application/json' }) }).map((response:Response)=>response.text())
                                                                                                                                                     .catch(this.errorHandler);



      }


  getter(){
    return this.user;
  }

getTimeSpend()
    {
 return this._http.get(this.baseUrl+'/totalHoursPlayed').map(res => {
        return res.text();
      });
    }

getAmountGames()
    {
 return this._http.get(this.baseUrl+'/totalgames').map(totalg => {
        return totalg.text();
      });
    }

getAveragePercentage()
    {
 return this._http.get(this.baseUrl+'/averagePercentage').map(totalp => {
        return totalp.text();
      });
    }


getMostTimeSpend()
    {
 return this._http.get(this.baseUrl+'/mosttimespend').map(mosttime => {
        return mosttime.text();
      });
    }


    getHighestRated()
        {
     return this._http.get(this.baseUrl+'/highestrated').map(highestrated => {
            return highestrated.text();
          });
        }


    getLowestRated()
        {
     return this._http.get(this.baseUrl+'/lowestrated').map(lowestrate => {
            return lowestrate.text();
          });
        }

            getPcGames()
                {
             return this._http.get(this.baseUrl+'/getpcgames').map(pcgamesamount => {
                    return pcgamesamount.text();
                  });
                }





}
