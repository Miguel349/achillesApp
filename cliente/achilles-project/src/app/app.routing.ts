// COnfigurar rutas basicas
import {ModuleWithProviders} from '@angular/core'; // importa componentes del router
import {Routes, RouterModule} from '@angular/router';


import {AppComponent} from './app.component';

const appRoutes:Routes = [
  {path:'', component:AppComponent},


  {path:'**',component:AppComponent} //INtroduces URL que no existe

];


export const appRoutingProviders: any[] = []; // COnfiguracion basica para el Routing
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
