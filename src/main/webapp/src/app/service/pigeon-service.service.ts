import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Pigeon } from 'src/main/webapp/src/app/model/pigeons';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PigeonService {

  private pigeonsUrl: string;

  constructor(private http: HttpClient) {
    this.pigeonsUrl = 'http://localhost:8080/';
  }

  public findAll(): Observable<Pigeon[]> {
    return this.http.get<Pigeon[]>(this.pigeonsUrl);
  }

  public save(pigeon: Pigeon) {
    return this.http.post<Pigeon>(this.pigeonsUrl, pigeon);
  }

}
