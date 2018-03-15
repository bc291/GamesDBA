import { Injectable } from '@angular/core';
import{Http, Response, Headers, RequestOptions} from '@angular/http';
import{Observable}   from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import{Statistics}  from '../statistics';



@Injectable()
export class StatisticsService {
private baseUrl:string='http://192.168.0.248:42488/api/statistics';
private headers = new Headers({'Content-Type':'application/json'});
private options = new RequestOptions({headers:this.headers});
private statistics = new Statistics();

constructor(private _http:Http) { }

  getStatistics(){

    return this._http.get(this.baseUrl,this.options).map((response:Response)=>response.json())
      .catch(this.errorHandler);
  }

  errorHandler(error:Response){

     return Observable.throw(error||"SERVER ERROR");
  }

   setter(statistics:Statistics){
     this.statistics=statistics;
   }




  getter(){
    return this.statistics;
  }
}
