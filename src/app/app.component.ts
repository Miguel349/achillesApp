import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute, Params} from '@angular/router';
import {UserService} from './services/user.service';
import {GLOBAL} from './services/global';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  providers: [UserService]

})
export class AppComponent implements OnInit {
  title = 'ACHILLES APP';
  //public user: User; // Create obj bbdd model
  public user;
  public url;

  constructor(
    private _route: ActivatedRoute,
    private _router: Router,
    private _userService: UserService,

  ){


    this.user = '';
    this.url = GLOBAL.url;


  }


  ngOnInit(){

    console.log("Cargaremos usuario");
  
    // Llamar al metodo del api para sacar un artsita en base a su id getArtist

}


}
