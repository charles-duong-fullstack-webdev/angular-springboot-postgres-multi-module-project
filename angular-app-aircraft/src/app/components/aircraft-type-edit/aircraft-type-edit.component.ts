import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AircraftTypeModel} from '../aircraft-type-list/AircraftType.model';
import {map} from 'rxjs/operators';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-aircraft-type-edit',
  templateUrl: './aircraft-type-edit.component.html',
  styleUrls: ['./aircraft-type-edit.component.css']
})
export class AircraftTypeEditComponent implements OnInit {
  aircraftTypeId: number;
  title = 'Edit Aircraft Type ';
  BACKEND_URL = 'http://localhost:8082/FBOAce04a/AircraftType';
  instance: AircraftTypeModel = {
    shortName: '',
    longName: '',
    description: '',
    notes: ''
  } as AircraftTypeModel;
  saveSuccess = false;
  saveFailure = false;

  constructor(private http: HttpClient, private route: ActivatedRoute, private router: Router) {
    console.log('AircraftTypeEditComponent constructor');
  }

  ngOnInit(): void {
    console.log('AircraftTypeEditComponent');
    this.route.params
      .subscribe(params => {
        console.log('AircraftTypeEditComponent: params', params);
        this.aircraftTypeId = params.aircraftTypeId;
        // this.title += this.aircraftTypeId;
        console.log('AircraftTypeEditComponent ngOnInit()');
        this.onSendGet();
      });
  }

  private onSendGet(): void {
    console.log('AircraftTypeEditComponent onSendGet()');
    if (this.aircraftTypeId > 0) {
      this.http.get<AircraftTypeModel>(
        this.BACKEND_URL + '/' + this.aircraftTypeId
      )
        .subscribe(responseData => {
          this.instance = responseData;
          console.log('this.instance:' + JSON.stringify(this.instance, null, 2));
          console.log(this.instance);
        });
    }
  }

  public refresh(): void {
    this.onSendGet();
  }

  public async onSave(): Promise<void> {
    // alert('hi I am saving: ' + JSON.stringify(this.instance, null, 2));
    this.saveFailure = false;
    this.saveSuccess = false;
    const instance2Save: AircraftTypeModel = this.instance;
    try{
      // let resp: Promise<AircraftTypeModel> = null;
      let resp = null;
      if (!instance2Save.aircraftTypeId || instance2Save.aircraftTypeId < 0) {
        console.log('Calling POST');
        instance2Save.aircraftTypeId = null;
        resp = await this.http.post(this.BACKEND_URL, instance2Save).toPromise();
      } else {
        console.log('Calling PUT');
        resp = await this.http.put(this.BACKEND_URL, instance2Save).toPromise();
      }
      if (resp) {
        console.log('resp = ', {resp});
        console.log('Saved it.');
        this.saveSuccess = true;
        this.aircraftTypeId = resp.aircraftTypeId;
        this.onSendGet();
        // await this.router.navigate(['/abc'], {queryParams: {aircraftTypeId: resp.aircraftTypeId});
      }
    } catch (err) {
      console.log('Saved (error).', {err});
      this.saveFailure = true;
    }
  }

}
