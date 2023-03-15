import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AircraftTypeModel} from './AircraftType.model';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-aircraft-type-list',
  templateUrl: './aircraft-type-list.component.html',
  styleUrls: ['./aircraft-type-list.component.css']
})
export class AircraftTypeListComponent implements OnInit {
  title = 'Aircraft Types';
  BACKEND_URL = 'http://localhost:8082/FBOAce04a/AircraftType';
  instance: AircraftTypeModel;
  instances: AircraftTypeModel[] = [];
  deleteSuccess = false;
  deleteFailure = false;

  constructor(private http: HttpClient, private router: Router, private activatedRoute: ActivatedRoute) {
    console.log('AircraftTypeListComponent constructor');
    this.ngOnInit();
  }

  ngOnInit() {
    console.log('AircraftTypeListComponent ngOnInit()');
    this.onSendGet();
  }

  private onSendGet(): void {
    console.log('AircraftTypeListComponent onSendGet()');
    this.http.get<AircraftTypeModel[]>(this.BACKEND_URL)
      .subscribe(responseData => {
        this.instances = responseData;
        console.log('this.instances:');
        console.log(this.instances);
        console.log('this.instances.length = ' + this.instances.length);
      });
  }

  public async onDelete(aircraftTypeId: number): Promise<void> {
    // alert('Deleting: ' + JSON.stringify(aircraftTypeId, null, 2));
    this.deleteSuccess = false;
    this.deleteFailure = false;
    try{
      const resp = await this.http.delete(this.BACKEND_URL + '/' + aircraftTypeId).toPromise();

      if (resp) {
        console.log('Deleted ' + aircraftTypeId);
        this.deleteSuccess = true;
        this.onSendGet();
      } else {
        console.log('Deleted...Promise never came back.' + aircraftTypeId);
      }
    } catch (err) {
      console.error('Error in aircraft-type.component onDelete()');
      console.error(err);
      this.deleteFailure = true;
    }
    this.onSendGet();
  }

}
