import {Injectable} from '@angular/core';
import {AngularFirestore} from 'angularfire2/firestore';
import {Subject} from 'rxjs/Subject';
import {Subscription} from 'rxjs/Subscription';
import 'rxjs/add/operator/map';

import {ExerciseDTO} from '../models/exerciseDTO';
import {AuthService} from "../service/auth.service";
import {Observable} from "rxjs-compat/Observable";
import {catchError, map} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Injectable()
export class TrainingService {
  private apiURL = 'http://localhost:8084/api/fitness';
  exerciseChanged = new Subject<ExerciseDTO>();
  exercisesChanged = new Subject<ExerciseDTO[]>();
  finishedExercisesChanged = new Subject<ExerciseDTO[]>();
  private availableExercises: ExerciseDTO[] = [];
  private runningExercise: ExerciseDTO;
  private fbSubs: Subscription[] = [];

  constructor(
    private db: AngularFirestore,
    private authService: AuthService,
    private httpClient: HttpClient,
    private router: Router) {
  }

  // private availableExercises: Exercise[] = [
  //   { id: 'crunches', name: 'Crunches', duration: 30, calories: 8 },
  //   { id: 'touch-toes', name: 'Touch Toes', duration: 180, calories: 15 },
  //   { id: 'side-lunges', name: 'Side Lunges', duration: 120, calories: 18 },
  //   { id: 'burpees', name: 'Burpees', duration: 60, calories: 8 }
  // ];
  // private runningExercise: Exercise;
  // private exercises: Exercise[] = [];
  //
  // getAvailableExercises() {
  //   return this.availableExercises.slice();
  // }

  fetchAvailableExercisesFirebase() {
    this.fbSubs.push(this.db
      .collection('availableExercises')
      .snapshotChanges()
      .map(docArray => {
        return docArray.map(doc => {
          return {
            id: doc.payload.doc.id,
            name: doc.payload.doc.data()['name'],
            duration: doc.payload.doc.data()['duration'],
            calories: doc.payload.doc.data()['calories']
          };
        });
      })
      .subscribe((exercises: ExerciseDTO[]) => {
        this.availableExercises = exercises;
        this.exercisesChanged.next([...this.availableExercises]);
      }));
  }


  public fetchAvailableExercises() {
    // TODO
    // const exercises: ExerciseDTO[] = [
    //   { id: 'crunches', name: 'Crunches', duration: 30, calories: 8 },
    //   { id: 'touch-toes', name: 'Touch Toes', duration: 180, calories: 15 },
    //   { id: 'side-lunges', name: 'Side Lunges', duration: 120, calories: 18 },
    //   { id: 'burpees', name: 'Burpees', duration: 60, calories: 8 }
    // ];
    // let exercises: ExerciseDTO[] = [];
    const exercises = this.authService.fetchAvailableExercises();
    this.availableExercises = exercises;
    this.exercisesChanged.next([...this.availableExercises]);
    // this.authService.fetchAvailableExercises().subscribe((exercises: ExerciseDTO[]) => {
    //   console.log('fetchAvailableExercises id >>' + exercises[0].id);
    //   console.log('fetchAvailableExercises name >>' + exercises[0].name);
    //   console.log('fetchAvailableExercises calories >>' + exercises[0].calories);
    //   // this.loginForm.get('email').setValue(loginDTO.userid);
    //   // this.loginForm.get('password').setValue(loginDTO.password);
    //   this.availableExercises = exercises;
    //   this.exercisesChanged.next([...this.availableExercises]);
    // });
  }

  startExercise(selectedId: string) {
    // this.db.doc('availableExercises/' + selectedId).update({lastSelected: new Date()});
    this.runningExercise = this.availableExercises.find(
      ex => ex.id === selectedId
    );
    this.exerciseChanged.next({...this.runningExercise});
  }

  completeExercise() {
    this.addDataToDatabase({
      ...this.runningExercise,
      date: new Date(),
      state: 'completed'
    });
    this.runningExercise = null;
    this.exerciseChanged.next(null);
  }

  cancelExercise(progress: number) {
    this.addDataToDatabase({
      ...this.runningExercise,
      duration: this.runningExercise.duration * (progress / 100),
      calories: this.runningExercise.calories * (progress / 100),
      date: new Date(),
      state: 'cancelled'
    });
    this.runningExercise = null;
    this.exerciseChanged.next(null);
  }

  getRunningExercise() {
    return {...this.runningExercise};
  }

  fetchCompletedOrCancelledExercisesFireBase() {
    this.fbSubs.push(this.db
      .collection('finishedExercises')
      .valueChanges()
      .subscribe((exercises: ExerciseDTO[]) => {
        this.finishedExercisesChanged.next(exercises);
      }));
  }

  // TODO Srping Boot
  fetchCompletedOrCancelledExercises() {
    // this.fbSubs.push(this.db
    //   .collection('finishedExercises')
    //   .valueChanges()
    //   .subscribe((exercises: ExerciseDTO[]) => {
    //     this.finishedExercisesChanged.next(exercises);
    //   }));

   const exercises: ExerciseDTO[] = [
      { id: 'crunches', name: 'Crunches', duration: 30, calories: 8 },
      { id: 'touch-toes', name: 'Touch Toes', duration: 180, calories: 15 },
      { id: 'side-lunges', name: 'Side Lunges', duration: 120, calories: 18 },
      { id: 'burpees', name: 'Burpees', duration: 60, calories: 8 }
    ];
    this.finishedExercisesChanged.next(exercises);
  }

  cancelSubscriptions() {
    this.fbSubs.forEach(sub => sub.unsubscribe());
  }

  private addDataToDatabase(exercise: ExerciseDTO) {
    this.db.collection('finishedExercises').add(exercise);
  }
}
