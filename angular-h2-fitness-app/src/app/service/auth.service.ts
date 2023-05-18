import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {Subject} from 'rxjs/Subject';
import {AuthData} from '../models/auth-data.model';
import {TrainingService} from '../training/training.service';
import {LoginDTO} from "../models/loginDTO";
import {Observable} from "rxjs-compat/Observable";
import {catchError, map, retry} from "rxjs/operators";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {throwError} from "rxjs/internal/observable/throwError";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  authChange = new Subject<boolean>();
  private isAuthenticated = false;

  // Define API
  private apiURL = 'http://localhost:8084/api/fitness';

  constructor(
    private httpClient: HttpClient,
    private router: Router,
    private trainingService: TrainingService) {
  }

  /*========================================
    CRUD Methods for consuming RESTful API
  =========================================*/
  // httpClient Options
  httpClientOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  getDefaultLoginDTO(): Observable<LoginDTO> {
    return this.httpClient.get<LoginDTO>(this.apiURL + '/defaultlogin').pipe(
      map((response) => response), catchError(this.handleError)
    );
  }

  initAuthListener() {
    // this.afAuth.authState.subscribe(user => {
    //   if (user) {
    //     this.isAuthenticated = true;
    //     this.authChange.next(true);
    //     this.router.navigate(['/training']);
    //   } else {
    //     this.trainingService.cancelSubscriptions();
    //     this.authChange.next(false);
    //     this.router.navigate(['/login']);
    //     this.isAuthenticated = false;
    //   }
    // });
  }

  registerUser(loginDTO: LoginDTO): Observable<LoginDTO> {
    return this.httpClient
      .post<LoginDTO>(
        this.apiURL + '/signup',
        loginDTO,
        this.httpClientOptions
      )
      .pipe(retry(1), catchError(
        this.handleError
      ));
  }

  login(authData: AuthData) {
    // this.afAuth.auth
    //   .signInWithEmailAndPassword(authData.email, authData.password)
    //   .then(result => {
    //     console.log(result);
    //   })
    //   .catch(error => {
    //     console.log(error);
    //   });
  }

  logout() {
    // this.afAuth.auth.signOut();
  }

  isAuth() {
    return this.isAuthenticated;
  }

  public authSuccessfully() {
    this.authChange.next(true);
    this.router.navigate(['/training']);
  }

  handleError(error: any) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log("handleError >> " + errorMessage);
    window.alert(errorMessage);
    return throwError(() => {
      return errorMessage;
    });
  }
}
