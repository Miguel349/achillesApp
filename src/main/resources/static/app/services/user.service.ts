import {Injectable} from '@angular/core';
import {Http, Response, Headers,RequestOptions} from '@angular/http';
//import 'rxjs/add/operator/map'; //mapeo de datos
//import {Observable} from 'rxjs/Observable';
import {GLOBAL} from './global';


@Injectable() // para manejar este servicio en otros lados

export class UserService{

  public url: string; // url api rest

  constructor(private _http:Http){ //para poder hacer peticiones
    this.url = GLOBAL.url;
  }

  getUser(token, id:string){
    let headers = new Headers({
      'Content-Type':'application/json',
      // 'Authorization':token
    });
    let options = new RequestOptions({headers:headers});

    // return this._http.get(this.url+'artist/'+id,options)
    //     .map(res=>res.json());
  }
}
