import {ExerciseDTO} from './exerciseDTO';

export class PersonExerciseDTO {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  dob: any;
  address: string;
  country: string;
  gender: string;
  exerciseDTOs: ExerciseDTO[];
}
