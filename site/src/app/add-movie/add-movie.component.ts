import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';
import { VideoService } from '../video.service';

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.css']
})
export class AddMovieComponent implements OnInit {
  registerForm: FormGroup;

  constructor(
    private authService: AuthService,
    private videoService: VideoService
  ) { }

  ngOnInit() {
    this.registerForm = new FormGroup({
      title: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
      categoryId: new FormControl('', Validators.required),
    });
  }

  onSubmit() {
    const req = this.registerForm.value;
    req.uploadedBy = this.authService.user.id;
    req.categoryId = +req.categoryId;

    this.videoService.addVideo(req).subscribe(num => {
      const streamReq = {path: 'https://www.youtube.com/embed/tgbNymZ7vqY', videoId: num};
      this.videoService.addStream(streamReq).subscribe();
    });
    if (this.registerForm.valid) {
      alert('Form Submitted!');
    }
  }
}
