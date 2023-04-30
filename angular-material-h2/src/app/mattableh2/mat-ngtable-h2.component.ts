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
import {$EQ} from "codelyzer/angular/styles/chars";


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
  selectedExerciseDTO: ExerciseDTO = new ExerciseDTO();
  selectedPersonExerciseDTO: PersonExerciseDTO = new PersonExerciseDTO();

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
      console.log('responsePersonExcerciseDTO.exerciseDTOs[0].id >>' +
        responsePersonExcerciseDTO.exerciseDTOs[0].id);
      console.log('exerciseDTOs.length >>' + this.exerciseDTOs.length);
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

  onShowDetail(exerciseDTO: ExerciseDTO): void {
    // window.alert('Edit exerciseDTO ID/name:' + exerciseDTO.id + '/' + exerciseDTO.name);

    this.selectedExerciseDTO = Object.assign({}, exerciseDTO);

    // window.alert('onShowDetail this.selectedExerciseDTO.id: ' + this.selectedExerciseDTO.id);
    // window.alert('onShowDetail this.selectedExerciseDTO.name: ' + this.selectedExerciseDTO.name);

    this.selectedPersonExerciseDTO = this.personExerciseDTO;
  }

  update(updatePersonExerciseDTO: PersonExerciseDTO) {
    console.log('personExerciseDTO >> ' + JSON.stringify(this.personExerciseDTO));
    console.log('updatePersonExerciseDTO >> ' + JSON.stringify(updatePersonExerciseDTO));
    // console.log('selectedExerciseDTO >> ' + JSON.stringify(this.selectedExerciseDTO));
    // console.log('selectedPersonExerciseDTO >> ' + JSON.stringify(this.selectedPersonExerciseDTO));
    Object.assign(this.personExerciseDTO, updatePersonExerciseDTO);
    console.log('UPDATED personExerciseDTO >> ' + JSON.stringify(this.personExerciseDTO));
    //
    // this.personExerciseDTO
    // const persExerciseH2 = this.exerciseDTOs
    //   .find(e => e.id === updatePersonExerciseDTO.id);
    // Object.assign(persExerciseH2, updatePersonExercise);
    // this.dataSource = new MatTableDataSource(this.exerciseDTOs);
    // this.dataSource.sort = this.sort;
    // this.dataSource.paginator = this.paginator;
    // window.alert('Customer Saved');

    // TODO use url to update data through Spring Boot
  }

  onClosePerson(exercise: ExerciseDTO): void {
    window.alert('Edit Exercise ID/Name:' + exercise.id + '/' + exercise.name);
    this.selectedExerciseDTO = new ExerciseDTO();
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

  protected readonly $EQ = $EQ;
}
