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
  displayedColumns = ['date', 'name', 'duration', 'calories', 'state'];
  dataSource = new MatTableDataSource([]);

  @ViewChild(MatSort, {static: false}) sort: MatSort;
  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;

  constructor(private matableh2Service: Matableh2Service) {
  }

  ngOnInit() {
    this.matableh2Service.getExercise().subscribe((result: Exercise[]) => {
      console.log('result ' + result[0].id);
      console.log('result ' + result[0].name);
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
}
