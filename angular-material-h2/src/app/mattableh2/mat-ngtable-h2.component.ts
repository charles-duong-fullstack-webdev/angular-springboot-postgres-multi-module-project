import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {Exercise} from '../training/exercise.model';
import {Matableh2Service} from './matableh2.service';

@Component({
  selector: 'app-ngtable-h2',
  templateUrl: './mat-ngtable-h2.component.html',
  styleUrls: ['./mat-ngtable-h2.component.css']
})
export class MatNgtableH2Component implements OnInit, AfterViewInit {
  displayedColumns = ['date', 'name', 'duration', 'calories', 'state', 'edit', 'delete'];
  dataSource = new MatTableDataSource([]);
  exercises: Exercise[];

  @ViewChild(MatSort, {static: false}) sort: MatSort;
  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;

  constructor(private matableh2Service: Matableh2Service) {
  }

  ngOnInit() {
    this.matableh2Service.getExercise().subscribe((result: Exercise[]) => {
      console.log('result ' + result[0].id);
      console.log('result ' + result[0].name);
      this.exercises = result;
      this.dataSource = new MatTableDataSource(result);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
    });
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  doFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  onDelete(element: Exercise): void {
    window.alert('Delete ID/Name:' + element.id + '/' + element.name);
    this.deleteExerciseWithoutDeleteH2(element);
  }

  deleteExerciseWithoutDeleteH2(element: Exercise): void {
    const indexToDelete = this.exercises.findIndex(
      (exerciseElement) => exerciseElement.id === element.id
    );
    this.exercises.splice(indexToDelete, 1);
    this.dataSource = new MatTableDataSource(this.exercises);
  }

  onEdit(element: Exercise): void {
    window.alert('Edit ID/Name:' + element.id + '/' + element.name);
  }
}
