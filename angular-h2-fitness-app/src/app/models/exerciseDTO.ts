export interface ExerciseDTO {
  id: string;
  name: string;
  duration: number;
  calories: number;
  trainingdate: Date;
  state: 'completed' | 'cancelled' | null;
}




