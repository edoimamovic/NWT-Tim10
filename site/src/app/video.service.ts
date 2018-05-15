import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Video } from './video';

@Injectable({
  providedIn: 'root'
})
export class VideoService {
  private readonly API_URL: string = 'http://localhost:8090/videoinfo/video/';

  constructor(private http: HttpClient) { }

  public search(string: string = ''): Observable<Array<Video>> {
    return this.http.get<Array<Video>>(`${this.API_URL}search?string=${string}`);
  }

  public get(id: number): Observable<Video> {
    return this.http.get<Video>(`${this.API_URL}data?id=${id}`);
  }
}
