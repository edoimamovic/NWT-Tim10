import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { VideoService } from '../video.service';
import { Video } from '../shared/video';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-video-details',
  templateUrl: './video-details.component.html',
  styleUrls: ['./video-details.component.css']
})
export class VideoDetailsComponent implements OnInit {
  private id: number;
  private video: Video;

  constructor(private route: ActivatedRoute,
    private videoService: VideoService,
    private router: Router,
    private authService: AuthService
  ) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = params['id'];
      this.videoService.get(this.id).subscribe(video => {
        this.video = video;
      });
    });
  }

  private delete() {
    this.videoService.delete(this.id).subscribe(resp => {
      this.router.navigate(['browse']);
    });
  }

  public getVideoYear() {
    return this.video.uploadDate.getFullYear();
  }
}
