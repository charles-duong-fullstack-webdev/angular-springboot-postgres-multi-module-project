import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {Subject} from 'rxjs/Subject';
import {LoginDTO} from "../models/loginDTO";
import {Observable} from "rxjs-compat/Observable";
import {catchError, map, retry} from "rxjs/operators";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {throwError} from "rxjs/internal/observable/throwError";
import {ExerciseDTO} from "../models/exerciseDTO";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  authChange = new Subject<boolean>();
  public isAuthenticated = false;

  // Define API
  private apiURL = 'http://localhost:8084/api/fitness';
  private apiExerciseURL = 'http://localhost:8084/api/fitness/exercise';

  constructor(
    private httpClient: HttpClient,
    private router: Router) {
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

  getDefaultSignupDTO(): Observable<LoginDTO> {
    return this.httpClient.get<LoginDTO>(this.apiURL + '/defaultsignup').pipe(
      map((response) => response), catchError(this.handleError)
    );
  }

  // fetchAvailableExercises(): ExerciseDTO[] {
  //   console.log('run... fetchAvailableExercises ');
  //   let fetchExerciseDTO: ExerciseDTO[] = [];
  //   this.fetchAvailableExercisesDTO().subscribe((exercises: ExerciseDTO[]) => {
  //     console.log('fetchAvailableExercises id >>' + exercises[0].id);
  //     console.log('fetchAvailableExercises name >>' + exercises[0].name);
  //     console.log('fetchAvailableExercises calories >>' + exercises[0].calories);
  //     fetchExerciseDTO = Object.assign({}, exercises);
  //     // this.loginForm.get('email').setValue(loginDTO.userid);
  //     // this.loginForm.get('password').setValue(loginDTO.password);
  //     // this.availableExercises = exercises;
  //     // this.exercisesChanged.next([...this.availableExercises]);
  //   });
  //   // console.log('availableExercises id >>' + availableExercises[0].id);
  //   return fetchExerciseDTO;
  // }

  getDefaultLoginDTO(): Observable<LoginDTO> {
    return this.httpClient.get<LoginDTO>(this.apiURL + '/defaultlogin').pipe(
      map((response) => response), catchError(this.handleError)
    );
  }

  fetchAvailableExercisesDTO(): Observable<ExerciseDTO[]> {
    return this.httpClient.get<ExerciseDTO[]>(this.apiExerciseURL + '/fetchAvailableExercises').pipe(
      map((response) => response), catchError(this.handleError)
    );
  }

  createExersiceDTO(exerciseDTO: ExerciseDTO): Observable<ExerciseDTO[]> {
    return this.httpClient
      .post<ExerciseDTO[]>(
        this.apiExerciseURL + '/addExercise',
        exerciseDTO,
        this.httpClientOptions
      )
      .pipe(retry(1), catchError(this.handleError));
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
      ).pipe(
        map((response) => response), catchError(this.handleError)
      );
  }

  login(userid: any, password: any) {
    return this.httpClient
      .get<Boolean>(this.apiURL + '/checklogin/userid/' + userid + /password/ + password,
        this.httpClientOptions
      )
      .pipe(retry(1), catchError(this.handleError));
  }

  // logout() {
  //   // this.afAuth.auth.signOut();
  // }

  logout() {
    this.authChange.next(false);
    this.router.navigate(['/login']);
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
      errorMessage = 'Get client-side error' + error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Get server-side error: Error Status: ${error.status}\nMessage: ${error.message}\nBody: ${error.body}`;
    }
    console.log("handleError >> " + errorMessage);
    window.alert(errorMessage);
    return throwError(() => {
      return errorMessage;
    });
  }
}
