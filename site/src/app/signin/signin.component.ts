import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
  private username: string;
  private password: string;

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

  private login(): void {
    this.authService.login(this.username, this.password);
  }

}
