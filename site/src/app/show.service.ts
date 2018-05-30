import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Show } from 'src/app/shared/show';
import { debounceTime, map, filter} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class ShowService {
  private readonly API_URL: string = 'http://localhost:8090/videoinfo/shows/';

  constructor(private http: HttpClient) { }

  public getAllShows(): Observable<Show[]> {
    return this.http.get<Show[]>(`${this.API_URL}all`);
  }
}
