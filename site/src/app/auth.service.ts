import { Injectable } from '@angular/core';
import { RequestOptions, Response } from '@angular/http';

import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { UserService } from './user.service';
import { UserData } from './shared/user-data';

@Injectable()
export class AuthService {

    API_URL = 'http://localhost:8090/auth';
    TOKEN_KEY = 'token';
    private userData: UserData;

    constructor(private http: HttpClient, private router: Router, private userService: UserService) { }

    get token() {
        return localStorage.getItem(this.TOKEN_KEY);
    }

    get isAuthenticated(): boolean {
        return !!localStorage.getItem(this.TOKEN_KEY);
    }

    logout() {
        localStorage.removeItem(this.TOKEN_KEY);
        this.router.navigateByUrl('/');
    }

    public get user(): UserData {
        return this.userData;
    }

    login(email: string, pass: string): Observable<any> {
        const response = new Observable<any>(observer => {
            this.http.post(this.API_URL + '/login', {
                email: email,
                password: pass
            },
            {
            headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Cache-Control': 'no-cache' }), observe: 'response'
        })
        .subscribe(
            (res: any) => {
                let token: string = res.headers.get('Authorization');
                token = token.replace('Bearer ', '');
                localStorage.setItem(this.TOKEN_KEY, token);
                this.router.navigateByUrl('');
                observer.next({email: email});

                this.userService.getUserData(email).subscribe(data => {
                    this.userData = new UserData(data);
                });
            },
        (err: HttpErrorResponse) => {
            observer.next({errorMessage: 'Email/password combination is incorrect.'});
        });
        });

        return response;
    }

public refreshUserData(): void {
    this.userService.getUserData(this.userData.email).subscribe(data => {
        this.userData = new UserData(data);
    });
}

public isAdmin(): boolean {
    return !!this.user && this.user.email.includes('admin');
}

    public changePassword(password: string, newPassword: string): Observable<boolean> {
        const response = new Observable<any>(observer => {
            // tslint:disable-next-line:max-line-length
            this.http.put(`${this.API_URL}/auth-data/change-password?email=${this.user.email}&password=${password}&newPassword=${newPassword}`, {})
            .subscribe((res: any) => {
            observer.next(true);
        },
        (err: HttpErrorResponse) => {
            observer.next(false);
        });
    });

    return response;
    }

    getAccount() {
        return this.http.get(this.API_URL + '/account');
    }

}
