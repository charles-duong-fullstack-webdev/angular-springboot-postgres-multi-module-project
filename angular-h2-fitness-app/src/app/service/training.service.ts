import {Injectable} from '@angular/core';
import {AngularFirestore} from 'angularfire2/firestore';
import {Subject} from 'rxjs/Subject';
import {Subscription} from 'rxjs/Subscription';
import 'rxjs/add/operator/map';

import {ExerciseDTO} from '../models/exerciseDTO';
import {AuthService} from "./auth.service";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {ObjectUtilService} from "./object-util.service";

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
    private objectUtilService: ObjectUtilService,
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

  // fetchAvailableExercisesFirebase() {
  //   this.fbSubs.push(this.db
  //     .collection('availableExercises')
  //     .snapshotChanges()
  //     .map(docArray => {
  //       return docArray.map(doc => {
  //         return {
  //           id: doc.payload.doc.id,
  //           name: doc.payload.doc.data()['name'],
  //           duration: doc.payload.doc.data()['duration'],
  //           calories: doc.payload.doc.data()['calories']
  //         };
  //       });
  //     })
  //     .subscribe((exercises: ExerciseDTO[]) => {
  //       this.availableExercises = exercises;
  //       this.exercisesChanged.next([...this.availableExercises]);
  //     }));
  // }


  public fetchAvailableExercises(): any {
    // TODO
    // const exercises: ExerciseDTO[] = [
    //   { id: 'crunches', name: 'Crunches', duration: 30, calories: 8 },
    //   { id: 'touch-toes', name: 'Touch Toes', duration: 180, calories: 15 },
    //   { id: 'side-lunges', name: 'Side Lunges', duration: 120, calories: 18 },
    //   { id: 'burpees', name: 'Burpees', duration: 60, calories: 8 }
    // ];
    this.authService.fetchAvailableExercisesDTO().subscribe((exercises: ExerciseDTO[]) => {
      console.log('TrainingService > fetchAvailableExercises > fetchAvailableExercises exercises.length >> ' + exercises.length);
      console.log('TrainingService > fetchAvailableExercises > fetchAvailableExercises id >> ' + exercises[0].id);
      console.log('TrainingService > fetchAvailableExercises > fetchAvailableExercises name >> ' + exercises[0].name);
      console.log('TrainingService > fetchAvailableExercises > calories >> ' + exercises[0].calories);
      console.log('TrainingService > fetchAvailableExercises > calories >> ' + JSON.stringify(exercises));
      // if WANT TO CRESTE A NEW CONSTANT
      // this.availableExercises = Object.assign({}, exercises);
      this.availableExercises = exercises;
      this.exercisesChanged.next([...this.availableExercises]);
    });
  }

  startExercise(selectedId: string) {
    // this.db.doc('availableExercises/' + selectedId).update({lastSelected: new Date()});
    this.fetchAvailableExercises();
    this.runningExercise = this.availableExercises.find(
      ex => ex.id === selectedId
    );
    this.exerciseChanged.next({...this.runningExercise});
  }

  completeExercise() {
    console.log("TrainingService > completeExercise this.runningExercise > " + JSON.stringify(this.runningExercise));
    this.addDataToDatabaseFirebase({
      ...this.runningExercise,
      date: new Date(),
      state: 'completed'
    });
    this.runningExercise = null;
    this.exerciseChanged.next(null);
  }

  cancelExerciseFirebase(progress: number) {
    console.log("TrainingService > cancelExercise this.runningExercise > " + JSON.stringify(this.runningExercise));
    this.addDataToDatabaseFirebase({
      ...this.runningExercise,
      duration: this.runningExercise.duration * (progress / 100),
      calories: this.runningExercise.calories * (progress / 100),
      date: new Date(),
      state: 'cancelled'
    });
    this.runningExercise = null;
    this.exerciseChanged.next(null);
  }

  cancelExercise(progress: number) {
    console.log("TrainingService > cancelExercise this.runningExercise > " + JSON.stringify(this.runningExercise));
    const duration = this.runningExercise.duration * (progress / 100);
    const calories = this.runningExercise.calories * (progress / 100);
    const date = new Date();
    const state = 'cancelled';

    let createNewRunningExercise: ExerciseDTO;
    createNewRunningExercise = this.objectUtilService.copyExerciseDTOExcludeId(this.runningExercise);
    console.log('this.objectUtilService.copyExerciseDTOExcludeId > '
      + JSON.stringify(createNewRunningExercise));

    createNewRunningExercise = this.objectUtilService.copyExerciseDTOIncludeDurationAndCalories(
      createNewRunningExercise,
      duration,
      calories
    );
    console.log('this.objectUtilService.copyExerciseDTOIncludeDurationAndCalories > '
      + JSON.stringify(createNewRunningExercise));

    this.addDataToDatabase(createNewRunningExercise);
    this.runningExercise = null;
    this.exerciseChanged.next(null);
  }

  getRunningExercise() {
    return {...this.runningExercise};
  }

  // fetchCompletedOrCancelledExercisesFireBase() {
  //   this.fbSubs.push(this.db
  //     .collection('finishedExercises')
  //     .valueChanges()
  //     .subscribe((exercises: ExerciseDTO[]) => {
  //       this.finishedExercisesChanged.next(exercises);
  //     }));
  // }

// TODO Srping Boot
  fetchCompletedOrCancelledExercises() {
    // const exercises: ExerciseDTO[] = [
    //   {id: 'crunches', name: 'Crunches', duration: 30, calories: 8},
    //   {id: 'touch-toes', name: 'Touch Toes', duration: 180, calories: 15},
    //   {id: 'side-lunges', name: 'Side Lunges', duration: 120, calories: 18},
    //   {id: 'burpees', name: 'Burpees', duration: 60, calories: 8},
    //   {id: 'burpees', name: 'Burpees-new', duration: 160, calories: 18}
    // ];

    this.authService.fetchAvailableExercisesDTO().subscribe((exercises: ExerciseDTO[]) => {
      console.log('TrainingService > fetchCompletedOrCancelledExercises > fetchAvailableExercises exercises.length >> ' + exercises.length);
      console.log('TrainingService > fetchCompletedOrCancelledExercises > fetchAvailableExercises id >> ' + exercises[0].id);
      console.log('TrainingService > fetchCompletedOrCancelledExercises > fetchAvailableExercises name >> ' + exercises[0].name);
      console.log('TrainingService > fetchCompletedOrCancelledExercises > calories >> ' + exercises[0].calories);
      console.log('TrainingService > fetchCompletedOrCancelledExercises > calories >> ' + JSON.stringify(exercises));
      // if WANT TO CRESTE A NEW CONSTANT
      // this.availableExercises = Object.assign({}, exercises);
      // this.availableExercises = exercises;
      // this.exercisesChanged.next([...this.availableExercises]);
      this.finishedExercisesChanged.next(exercises);
    });
  }

  cancelSubscriptions() {
    this.fbSubs.forEach(sub => sub.unsubscribe());
  }

  // TODO Add new Exercese to DB
  private addDataToDatabaseFirebase(exercise: ExerciseDTO) {
    this.db.collection('finishedExercises').add(exercise);
  }

  private addDataToDatabase(exercise: ExerciseDTO) {
    this.authService.createExersiceDTO(exercise).subscribe((exercises: ExerciseDTO[]) => {
      console.log('TrainingService > fetchCompletedOrCancelledExercises > calories >> ' + JSON.stringify(exercises));
      this.finishedExercisesChanged.next(exercises);
    });
  }
}
