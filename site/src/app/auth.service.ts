import { Injectable } from '@angular/core';
import { RequestOptions, Response } from '@angular/http';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable()
export class AuthService {

    API_URL = 'http://localhost:8090/auth';
    TOKEN_KEY = 'token';

    constructor(private http: HttpClient, private router: Router) { }

    get token() {
        return localStorage.getItem(this.TOKEN_KEY);
    }

    get isAuthenticated() {
        return !!localStorage.getItem(this.TOKEN_KEY);
    }

    logout() {
        localStorage.removeItem(this.TOKEN_KEY);
        this.router.navigateByUrl('/');
    }

    login(username: string, pass: string) {
        this.http.post(this.API_URL + '/login', {
                            username: username,
                            password: pass
                        },
                        {
                          headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Cache-Control': 'no-cache' }), observe: 'response'
                      }).subscribe(
            (res: any) => {
              let token: string = res.headers.get('Authorization');
              token = token.replace('Bearer ', '');
              localStorage.setItem(this.TOKEN_KEY, token);

              this.router.navigateByUrl('');
            }
        );
    }

    getAccount() {
        return this.http.get(this.API_URL + '/account');
    }
}
