import {AfterViewInit, Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {MatNgtableH2Service} from './service/mat-ngtable-h2.service';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {MatNgdialogH2Component} from '../matdialogh2/mat-ngdialog-h2.component';
import {PersonExerciseDTO} from './models/person-exercise-DTO';
import {
  MatFormH2DialogPersonInfoComponent
} from '../matformh2/matformh2dialogpersoninfo/mat-form-h2-dialog-person-info.component';
import {Subscription} from 'rxjs/Subscription';
import {ExerciseDTO} from './models/exerciseDTO';


@Component({
  selector: 'app-ngtable-h2',
  templateUrl: './mat-ngtable-h2.component.html',
  styleUrls: ['./mat-ngtable-h2.component.css']
})
export class MatNgtableH2Component implements OnInit, AfterViewInit, OnDestroy {
  private exercisePersonInfo =
    {
      name: 'MatNgtableH2Component Charles', email: 'chares@gmail.com', dob: '30.01.1995',
      address: 'MatNgtableH2Component 8 ', country: 'Swiss', gender: 'Man'
    };

  message: string;
  subscriptionMessage: Subscription;
  subscriptionPersonExerciseH: Subscription;

  displayedColumns = ['date', 'name', 'duration', 'calories',
    'state', 'edit', 'delete', 'showDetail', 'showEditDialog'];
  dataSource = new MatTableDataSource([]);
  exerciseDTOs: ExerciseDTO[];
  personExerciseDTO: PersonExerciseDTO = new PersonExerciseDTO();
  selectedExerciseH2: ExerciseDTO = new ExerciseDTO();

  @ViewChild(MatSort, {static: false}) sort: MatSort;
  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;

  constructor(private matableh2Service: MatNgtableH2Service, private dialog: MatDialog,
              private matFormH2DialogPersonInfoComponent: MatFormH2DialogPersonInfoComponent) {
  }

  ngOnInit() {
    this.subscriptionMessage = this.matableh2Service.currentMessage.subscribe(message => this.message = message);
    this.matableh2Service.getExercise().subscribe((responsePersonExcerciseDTO: PersonExerciseDTO) => {
      console.log('responsePersonExcerciseDTO id >>' + responsePersonExcerciseDTO.id);
      console.log('responsePersonExcerciseDTO firstName >>' + responsePersonExcerciseDTO.firstName);
      this.personExerciseDTO = responsePersonExcerciseDTO;
      this.exerciseDTOs = responsePersonExcerciseDTO.exerciseDTOs;
      console.log('responsePersonExcerciseDTO.exerciseDTOS.length >>' +
        responsePersonExcerciseDTO.exerciseDTOs[0].id);
      //console.log('exerciseDTOs.length >>' + this.exerciseDTOs.length);
      this.dataSource = new MatTableDataSource(this.exerciseDTOs);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
    });
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  ngOnDestroy() {
    this.subscriptionMessage.unsubscribe();
    // this.subscriptionPersonExerciseH.unsubscribe();
  }

  openDialog(editExercise: ExerciseDTO) {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    window.alert('openDialog EditExercise ID/Name:' + editExercise.id + '/' + editExercise.name);

    dialogConfig.data = {
      id: editExercise.id,
      title: editExercise.name,
      description: editExercise.name
    };

    this.dialog.open(MatNgdialogH2Component, dialogConfig);

    const dialogRef = this.dialog.open(MatNgdialogH2Component, dialogConfig);

    dialogRef.afterClosed().subscribe(
      data => console.log('Dialog output:', data)
    );

    this.matableh2Service.setPersonExerciseH2ForDialog(editExercise);
  }


  doFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  onDelete(element: PersonExerciseDTO): void {
    window.alert('Delete ID/firstName:' + element.id + '/' + element.firstName);
    this.deleteExerciseWithoutDeleteH2(element);
  }

  onEdit(exercise: ExerciseDTO): void {
    window.alert('Edit Exercise ID/Name:' + exercise.id + '/' + exercise.name);
    this.openDialog(exercise);
  }

  onShowDetail(exercise: ExerciseDTO): void {
    window.alert('Edit Exercise ID/name:' + exercise.id + '/' + exercise.name);

    this.selectedExerciseH2 = Object.assign({}, exercise);

    window.alert('onShowDetail this.selectedPersonExerciseH2.firstName: ' + this.selectedExerciseH2.name);

    // this.selectedPersonExerciseH2.exercise = new Exercise();
    // this.selectedPersonExerciseH2.exercise.id = 1;
    // this.selectedPersonExerciseH2.exercise.name = this.exercisePersonInfo.name;
    // this.selectedPersonExerciseH2.exercise.dob = this.exercisePersonInfo.dob;
    // this.selectedPersonExerciseH2.exercise.address = this.exercisePersonInfo.address;
    // this.selectedPersonExerciseH2.exercise.email = this.exercisePersonInfo.email;
    // this.selectedPersonExerciseH2.exercise.country = this.exercisePersonInfo.country;
    // this.selectedPersonExerciseH2.exercise.gender = this.exercisePersonInfo.gender;

  }

  update(personExerciseH2: PersonExerciseDTO) {
    console.log(personExerciseH2);
    const persExerciseH2 = this.exerciseDTOs
      .find(e => e.id === personExerciseH2.id);
    Object.assign(persExerciseH2, personExerciseH2);
    this.dataSource = new MatTableDataSource(this.exerciseDTOs);
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    window.alert('Customer Saved');
  }

  onClosePerson(exercise: ExerciseDTO): void {
    window.alert('Edit Exercise ID/Name:' + exercise.id + '/' + exercise.name);
    this.selectedExerciseH2 = new ExerciseDTO();
  }

  onAddNew(element: PersonExerciseDTO): void {
    window.alert('Add New ID/firstName::' + element.id + '/' + element.firstName);
    this.matableh2Service.setEditExercise(element);
  }

  deleteExerciseWithoutDeleteH2(element: PersonExerciseDTO): void {
    const indexToDelete = this.exerciseDTOs.findIndex(
      (exerciseElement) => exerciseElement.id === element.id
    );
    this.exerciseDTOs.splice(indexToDelete, 1);
    this.dataSource = new MatTableDataSource(this.exerciseDTOs);
  }
}
