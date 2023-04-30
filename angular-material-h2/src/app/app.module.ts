import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FlexLayoutModule, FlexModule} from '@angular/flex-layout';

import {AppComponent} from './app.component';
import {MaterialModule} from './material.module';
import {SignupComponent} from './auth/signup/signup.component';
import {LoginComponent} from './auth/login/login.component';
import {TrainingComponent} from './training/training.component';
import {CurrentTrainingComponent} from './training/current-training/current-training.component';
import {NewTrainingComponent} from './training/new-training/new-training.component';
import {PastTrainingsComponent} from './training/past-trainings/past-trainings.component';
import {WelcomeComponent} from './welcome/welcome.component';
import {AppRoutingModule} from './app-routing.module';
import {HeaderComponent} from './navigation/header/header.component';
import {SidenavListComponent} from './navigation/sidenav-list/sidenav-list.component';
import {StopTrainingComponent} from './training/current-training/stop-training.component';
import {AuthService} from './auth/auth.service';
import {TrainingService} from './training/training.service';
import {MatNgtableH2Component} from './mattableh2/mat-ngtable-h2.component';
import {MatNgtableH2Service} from './mattableh2/service/mat-ngtable-h2.service';
import {HttpClientModule} from '@angular/common/http';
import {MatNgdialogH2Component} from './matdialogh2/./mat-ngdialog-h2.component';
import {MatNgformH2Component} from './matformh2/mat-ngform-h2.component';
import {
  MatFormH2DialogPersonInfoComponent
} from './matformh2/matformh2dialogpersoninfo/mat-form-h2-dialog-person-info.component';
import { Ngformh2DetailEventEmitterComponent } from './mattableh2detaileventemitter/ngformh2-detail-event-emitter.component';
import {CommonModule} from "@angular/common";
import {MatButtonModule} from "@angular/material/button";
import {MatCardModule} from "@angular/material/card";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatOptionModule} from "@angular/material/core";
import {MatSelectModule} from "@angular/material/select";
import {MatInputModule} from "@angular/material/input";
import {RestApiService} from "./service/rest-api-service";

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    TrainingComponent,
    CurrentTrainingComponent,
    NewTrainingComponent,
    PastTrainingsComponent,
    WelcomeComponent,
    HeaderComponent,
    SidenavListComponent,
    StopTrainingComponent,
    MatNgtableH2Component,
    MatNgdialogH2Component,
    MatNgformH2Component,
    MatFormH2DialogPersonInfoComponent,
    Ngformh2DetailEventEmitterComponent,

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    AppRoutingModule,
    FlexLayoutModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    CommonModule,
    FlexModule,
    FormsModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    MatOptionModule,
    MatSelectModule,
    CommonModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    FlexModule,
    FormsModule,
  ],
  providers: [AuthService, RestApiService, TrainingService, MatNgtableH2Service, MatFormH2DialogPersonInfoComponent],
  bootstrap: [AppComponent],
  entryComponents: [StopTrainingComponent, MatNgdialogH2Component]
})
export class AppModule {
}
