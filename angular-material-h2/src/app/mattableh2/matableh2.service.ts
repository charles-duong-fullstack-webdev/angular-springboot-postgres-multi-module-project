import {Exercise} from '../training/exercise.model';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {map} from 'rxjs/operators';
import {Observable} from "rxjs";

/**
 * see training.service.ts
 */
@Injectable({
  providedIn: 'root'
})
export class Matableh2Service {

  private getUrl = 'http://localhost:8084/api/mattableh2/exercises';

  constructor(private httpClient: HttpClient) {
  }

  getExercise(): Observable<Exercise[]> {
    return this.httpClient.get<Exercise[]>(this.getUrl).pipe(
      map((response) => response)
    );
  }

}
