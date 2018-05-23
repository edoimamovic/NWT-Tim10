import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { VideoService } from '../video.service';
import { Video } from 'src/app/shared/video';

@Component({
  selector: 'app-video-details',
  templateUrl: './video-details.component.html',
  styleUrls: ['./video-details.component.css']
})
export class VideoDetailsComponent implements OnInit {
  private id: number;
  private video: Video;

  constructor(private route: ActivatedRoute,
              private videoService: VideoService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = +params['id'];

      this.videoService.get(this.id).subscribe(video => {this.video = video; });
    });
  }

}
