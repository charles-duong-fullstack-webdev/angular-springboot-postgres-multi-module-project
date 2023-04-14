import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {Exercise} from '../training/exercise.model';
import {MatNgtableH2Service} from './mat-ngtable-h2.service';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {MatNgdialogH2Component} from '../matdialogh2/mat-ngdialog-h2.component';
import {PersonExerciseH2} from "./models/person-exercise-h2";


@Component({
  selector: 'app-ngtable-h2',
  templateUrl: './mat-ngtable-h2.component.html',
  styleUrls: ['./mat-ngtable-h2.component.css']
})
export class MatNgtableH2Component implements OnInit, AfterViewInit {
  displayedColumns = ['date', 'name', 'duration', 'calories', 'state', 'edit', 'delete'];
  dataSource = new MatTableDataSource([]);
  personExerciseH2: PersonExerciseH2[];

  @ViewChild(MatSort, {static: false}) sort: MatSort;
  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;

  constructor(private matableh2Service: MatNgtableH2Service, private dialog: MatDialog) {
  }

  ngOnInit() {
    this.matableh2Service.getExercise().subscribe((result: PersonExerciseH2[]) => {
      console.log('result ' + result[0].id);
      console.log('result ' + result[0].name);
      this.personExerciseH2 = result;
      this.dataSource = new MatTableDataSource(result);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
    });
  }

  openDialog(element: PersonExerciseH2) {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    window.alert('openDialog ID/Name:' + element.id + '/' + element.name);

    dialogConfig.data = {
      id: element.id,
      title: element.name,
      description: element.name
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

  onDelete(element: PersonExerciseH2): void {
    window.alert('Delete ID/Name:' + element.id + '/' + element.name);
    this.deleteExerciseWithoutDeleteH2(element);
  }

  onEdit(element: PersonExerciseH2): void {
    window.alert('Edit ID/Name:' + element.id + '/' + element.name);
    this.openDialog(element);
    // this.matableh2Service.setEditExercise(element);
  }

  onAddNew(element: PersonExerciseH2): void {
    window.alert('Add New:' + element.id + '/' + element.name);
    this.matableh2Service.setEditExercise(element);
  }

  deleteExerciseWithoutDeleteH2(element: PersonExerciseH2): void {
    const indexToDelete = this.personExerciseH2.findIndex(
      (exerciseElement) => exerciseElement.id === element.id
    );
    this.personExerciseH2.splice(indexToDelete, 1);
    this.dataSource = new MatTableDataSource(this.personExerciseH2);
  }
}
