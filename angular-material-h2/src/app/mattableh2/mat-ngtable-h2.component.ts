import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {Exercise} from '../training/exercise.model';
import {MatNgtableH2Service} from './mat-ngtable-h2.service';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {MatNgdialogH2Component} from '../matdialogh2/mat-ngdialog-h2.component';

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

  constructor(private matableh2Service: MatNgtableH2Service, private dialog: MatDialog) {
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

  openDialog() {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    dialogConfig.data = {
      id: 1,
      title: 'Angular For Beginners'
    };

    this.dialog.open(MatNgdialogH2Component, dialogConfig);

    const dialogRef = this.dialog.open(MatNgdialogH2Component, dialogConfig);

    dialogRef.afterClosed().subscribe(
      data => console.log('Dialog output:', data)
    );
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

  onEdit(element: Exercise): void {
    window.alert('Edit ID/Name:' + element.id + '/' + element.name);
    this.matableh2Service.setEditExercise(element);
  }

  onAddNew(element: Exercise): void {
    window.alert('Add New:' + element.id + '/' + element.name);
    this.matableh2Service.setEditExercise(element);
  }

  deleteExerciseWithoutDeleteH2(element: Exercise): void {
    const indexToDelete = this.exercises.findIndex(
      (exerciseElement) => exerciseElement.id === element.id
    );
    this.exercises.splice(indexToDelete, 1);
    this.dataSource = new MatTableDataSource(this.exercises);
  }
}
