import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Video } from './shared/video';

@Injectable({
  providedIn: 'root'
})
export class VideoService {
  private readonly API_URL: string = 'http://localhost:8090/videoinfo/video/';
  private readonly STREAM_API_URL: string = 'http://localhost:8090/videostream/video/';

  constructor(private http: HttpClient) { }

  public search(string: string = ''): Observable<Array<Video>> {
    return this.http.get<Array<Video>>(`${this.API_URL}search?string=${string}`);
  }

  public get(id: number): Observable<Video> {
    return this.http.get<Video>(`${this.API_URL}data?id=${id}`);
  }

  public delete(id: number): Observable<boolean> {
    return this.http.delete<boolean>(`${this.API_URL}delete?id=${id}`);
  }

  public getCategories(): Observable<Array<object>> {
    return this.http.get<Array<object>>(`${this.API_URL}getAllCategories`);
  }

  public getVideosByCategory(category: string): Observable<Array<Video>> {
    return this.http.get<Array<Video>>(`${this.API_URL}getVideosByCategory/${category}`);
  }

  public addVideo(data: any): Observable<number> {
    return this.http.post<number>(`${this.API_URL}add-video`, data);
  }

  public addStream(data: any): Observable<boolean> {
    return this.http.post<boolean>(`${this.STREAM_API_URL}add`, data);
  }
}
