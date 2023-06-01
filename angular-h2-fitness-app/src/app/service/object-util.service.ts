import {Injectable} from '@angular/core';
import {ExerciseDTO} from "../models/exerciseDTO";

@Injectable({
  providedIn: 'root'
})
export class ObjectUtilService {
  constructor() {
  }

  copyExerciseDTOExcludeId(exerciseDTO: ExerciseDTO) {
    // let obj = {}, key;
    const obj = Object.assign({}, exerciseDTO);
    let key: any;
    for (key in exerciseDTO) {
      if (key === 'id') {
        obj[key] = "";
      }
      // else {
      //   obj[key] = exerciseDTO[key];
      // }
    }
    console.log('ObjectUtilService > copyExerciseDTOExcludeId > ' + JSON.stringify(obj));
    return obj;
  }

  copyExerciseDTOIncludeDurationAndCalories(
    exerciseDTO: ExerciseDTO, duration: number, calories: number, state: string): ExerciseDTO {
    // let obj = {}, key;
    const obj = Object.assign({}, exerciseDTO);
    let key: any;
    for (key in exerciseDTO) {
      if (key === 'duration') {
        obj[key] = duration;
      } else if (key === 'calories') {
        obj[key] = calories;
      } else if (key === 'state') {
        obj[key] = state;
      }
      // else {
      //   obj[key] = exerciseDTO[key];
      // }
    }
    console.log('ObjectUtilService > copyExerciseDTOIncludeDurationAndCalories > ' + JSON.stringify(obj));
    return obj;
  }

}
