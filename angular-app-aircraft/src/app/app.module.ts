import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Routes, Router, RouterModule} from '@angular/router';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { AircraftTypeListComponent } from './components/aircraft-type-list/aircraft-type-list.component';
import { AircraftTypeEditComponent } from './components/aircraft-type-edit/aircraft-type-edit.component';
import { HomeComponent } from './components/home/home.component';
import { AppNavbarComponent } from './components/app-navbar/app-navbar.component';

const PATH_HOME = '';
const PATH_APP = 'fboace04';
const PATH_AIRCRAFT_TYPE = '/AircraftType';
const PATH_AIRCRAFT_TYPE_ID = '/:aircraftTypeId';

const appRoutes: Routes = [
  {path: '', component: HomeComponent },
  {path: PATH_APP + PATH_AIRCRAFT_TYPE, component: AircraftTypeListComponent},
  {path: PATH_APP + PATH_AIRCRAFT_TYPE + PATH_AIRCRAFT_TYPE_ID, component: AircraftTypeEditComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AircraftTypeListComponent,
    AircraftTypeEditComponent,
    AppNavbarComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes, { onSameUrlNavigation: 'reload' })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
