import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  private changepassword(): void {
    //this.authService.changepassword(this.username, this.password);
  }

  private getusername():void{  }
  private getpassword():void{}
   
   
}