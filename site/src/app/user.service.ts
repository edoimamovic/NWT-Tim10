import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { UserData } from './shared/user-data';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }
  private readonly API_URL: string = 'http://localhost:8090/users/';

  public getUserData(email: string):  Observable<UserData> {
    return this.http.get<UserData>(`${this.API_URL}getInfoByEmail?email=${email}`);
  }

  public updateUserData(userData: UserData):  Observable<boolean> {
    const response = new Observable<any>(observer => {
        // tslint:disable-next-line:max-line-length
        this.http.put(`${this.API_URL}update`, userData)
        .subscribe((res: any) => {
        observer.next(true);
    },
    (err: HttpErrorResponse) => {
        observer.next(false);
    });
});

return response;
}
}
