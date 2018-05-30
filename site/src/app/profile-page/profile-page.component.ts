import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {

  private password: string;
  private newPassword: string;
  private passwordRepeat: string;
  private notificationMessage: string;
  private profileNotificationMessage: string;
  private profileForm: FormGroup;
  private passwordForm: FormGroup;

  private getDateString(date: Date): string {
    return (new Date(date)).toISOString().substring(0, 10);
  }

  constructor(private authService: AuthService, private userService: UserService) { }

  ngOnInit() {
    this.profileForm = new FormGroup({
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      birthDate: new FormControl('', Validators.required),
      email: new FormControl('', [Validators.required, Validators.pattern('[^ @]*@[^ @]*')]),
    });

    this.passwordForm = new FormGroup({
      password: new FormControl('', Validators.required),
      newPassword: new FormControl('', Validators.required),
      passwordRepeat: new FormControl('', Validators.required),
    });

    this.profileForm.patchValue(this.authService.user);
    this.profileForm.get('birthDate').setValue(this.getDateString(this.authService.user.birthDate));
  }

  private changePassword(): void {
    const newPassword = this.passwordForm.get('newPassword').value;
    const password = this.passwordForm.get('password').value;
    const passwordRepeat = this.passwordForm.get('passwordRepeat').value;

    if (this.newPassword !== this.passwordRepeat) {
      this.notificationMessage = 'Entered passwords do not match.';
    } else {
      this.authService.changePassword(password, newPassword).subscribe((resp: boolean) => {
        this.notificationMessage = resp ? 'Data successfully changed.' : 'You have entered a wrong password.';
        this.passwordForm.reset();
      });
    }
  }

  private updateData(): void {
    const reqObject = this.profileForm.value;
    const oldData = this.authService.user;
    reqObject.id = oldData.id;

    this.userService.updateUserData(this.profileForm.value).subscribe(resp => {
      this.profileNotificationMessage = resp ? 'Password successfully changed.' : 'You have entered a wrong password.';
      this.authService.refreshUserData();
    }
    );
  }

  private getusername(): void {  }
  private getpassword(): void {}


}
