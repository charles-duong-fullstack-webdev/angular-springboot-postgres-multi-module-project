import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { MatTableDataSource, MatSort, MatPaginator } from '@angular/material';
import {Exercise} from '../training/exercise.model';
import {Matableh2Service} from './matableh2.service';

@Component({
  selector: 'app-ngtable-h2',
  templateUrl: './mat-ngtable-h2.component.html',
  styleUrls: ['./mat-ngtable-h2.component.css']
})
export class MatNgtableH2Component implements OnInit, AfterViewInit {
  displayedColumns = ['date', 'name', 'duration', 'calories', 'state'];
  dataSource = new MatTableDataSource<Exercise>();

  @ViewChild(MatSort, { static: false }) sort: MatSort;
  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;

  constructor(private matableh2Service: Matableh2Service) {}

  ngOnInit() {
    this.dataSource.data = this.matableh2Service.getCompletedOrCancelledExercises();
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  doFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
