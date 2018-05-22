import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
  private email: string;
  private password: string;
  private message: string;

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

  private login(): void {
   this.authService.login(this.email, this.password).subscribe(resp => {
      if (resp.errorMessage) {
        this.message = resp.errorMessage;
      } else {
        this.message = '';
      }
    });
  }

}
