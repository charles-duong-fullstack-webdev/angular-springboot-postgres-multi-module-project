import {AfterViewInit, Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {MatNgtableH2Service} from './service/mat-ngtable-h2.service';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {MatNgdialogH2Component} from '../matdialogh2/mat-ngdialog-h2.component';
import {PersonExerciseH2} from './models/person-exercise-h2';
import {
  MatFormH2DialogPersonInfoComponent
} from '../matformh2/matformh2dialogpersoninfo/mat-form-h2-dialog-person-info.component';
import {Subscription} from 'rxjs/Subscription';
import {PersonH2} from './models/person-h2';


@Component({
  selector: 'app-ngtable-h2',
  templateUrl: './mat-ngtable-h2.component.html',
  styleUrls: ['./mat-ngtable-h2.component.css']
})
export class MatNgtableH2Component implements OnInit, AfterViewInit, OnDestroy {
  private exercisePersonInfo =
    {
      name: 'MatNgtableH2Service Charles', email: 'chares@gmail.com', dob: '30.01.1995',
      address: '8 dbdbdb', country: 'Swiss', gender: 'Man'
    };

  message: string;
  subscriptionMessage: Subscription;
  subscriptionPersonExerciseH: Subscription;

  displayedColumns = ['date', 'name', 'duration', 'calories',
    'state', 'edit', 'delete', 'showDetail', 'showEditDialog'];
  dataSource = new MatTableDataSource([]);
  personExerciseH2Array: PersonExerciseH2[];
  selectedPersonExerciseH2: PersonExerciseH2 = new PersonExerciseH2();

  @ViewChild(MatSort, {static: false}) sort: MatSort;
  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;

  constructor(private matableh2Service: MatNgtableH2Service, private dialog: MatDialog,
              private matFormH2DialogPersonInfoComponent: MatFormH2DialogPersonInfoComponent) {
  }

  ngOnInit() {
    this.subscriptionMessage = this.matableh2Service.currentMessage.subscribe(message => this.message = message);
    this.matableh2Service.getExercise().subscribe((result: PersonExerciseH2[]) => {
      console.log('result ' + result[0].id);
      console.log('result ' + result[0].name);
      this.personExerciseH2Array = result;
      this.dataSource = new MatTableDataSource(this.personExerciseH2Array);
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


  doFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  onDelete(element: PersonExerciseH2): void {
    window.alert('Delete ID/Name:' + element.id + '/' + element.name);
    this.deleteExerciseWithoutDeleteH2(element);
  }

  onEdit(element: PersonExerciseH2): void {
    window.alert('Edit ID/Name:' + element.id + '/' + element.name);
    this.matableh2Service.setPersonExerciseH2ForDialog(element);
    // exercisePersonInfo
    this.openDialog(element);
    // this.matableh2Service.setEditExercise(element);
  }

  onShowDetail(element: PersonExerciseH2): void {
    window.alert('Edit ID/Name:' + element.id + '/' + element.name);

    this.selectedPersonExerciseH2 = Object.assign({}, element);

    window.alert('onShowDetail this.selectedPersonExerciseH2.name: ' + this.selectedPersonExerciseH2.name);

    this.selectedPersonExerciseH2.personH2 = new PersonH2();
    this.selectedPersonExerciseH2.personH2.id = 1;
    this.selectedPersonExerciseH2.personH2.name = this.exercisePersonInfo.name;
    this.selectedPersonExerciseH2.personH2.dob = this.exercisePersonInfo.dob;
    this.selectedPersonExerciseH2.personH2.address = this.exercisePersonInfo.address;
    this.selectedPersonExerciseH2.personH2.email = this.exercisePersonInfo.email;
    this.selectedPersonExerciseH2.personH2.country = this.exercisePersonInfo.country;
    this.selectedPersonExerciseH2.personH2.gender = this.exercisePersonInfo.gender;

  }

  update(personExerciseH2: PersonExerciseH2) {
    console.log(personExerciseH2);
    const persExerciseH2 = this.personExerciseH2Array
      .find(e => e.id === personExerciseH2.id);
    Object.assign(persExerciseH2, personExerciseH2);
    this.dataSource = new MatTableDataSource(this.personExerciseH2Array);
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    window.alert('Customer Saved');
  }

  onClosePerson(element: PersonExerciseH2): void {
    window.alert('Edit ID/Name:' + element.id + '/' + element.name);
    this.selectedPersonExerciseH2 = new PersonExerciseH2();
  }

  onAddNew(element: PersonExerciseH2): void {
    window.alert('Add New:' + element.id + '/' + element.name);
    this.matableh2Service.setEditExercise(element);
  }

  deleteExerciseWithoutDeleteH2(element: PersonExerciseH2): void {
    const indexToDelete = this.personExerciseH2Array.findIndex(
      (exerciseElement) => exerciseElement.id === element.id
    );
    this.personExerciseH2Array.splice(indexToDelete, 1);
    this.dataSource = new MatTableDataSource(this.personExerciseH2Array);
  }
}
