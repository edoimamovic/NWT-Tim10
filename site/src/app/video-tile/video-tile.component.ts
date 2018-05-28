import { Component, OnInit, Input } from '@angular/core';
import { Video } from 'src/app/shared/video';

@Component({
  selector: 'app-video-tile',
  templateUrl: './video-tile.component.html',
  styleUrls: ['./video-tile.component.css']
})

export class VideoTileComponent implements OnInit {
  @Input('video') video: Video;

  ngOnInit() {
  }

}
