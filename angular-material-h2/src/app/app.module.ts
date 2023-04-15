import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FlexLayoutModule} from '@angular/flex-layout';

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
import {MatNgtableH2Service} from './mattableh2/mat-ngtable-h2.service';
import {HttpClientModule} from '@angular/common/http';
import {MatNgdialogH2Component} from './matdialogh2/./mat-ngdialog-h2.component';
import {MatNgformH2Component} from './matformh2/mat-ngform-h2.component';
import {
  MatFormH2DialogPersonInfoComponent
} from './matformh2/matformh2dialogpersoninfo/mat-form-h2-dialog-person-info.component';

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
  ],
  providers: [AuthService, TrainingService, MatNgtableH2Service, MatFormH2DialogPersonInfoComponent],
  bootstrap: [AppComponent],
  entryComponents: [StopTrainingComponent, MatNgdialogH2Component]
})
export class AppModule {
}
